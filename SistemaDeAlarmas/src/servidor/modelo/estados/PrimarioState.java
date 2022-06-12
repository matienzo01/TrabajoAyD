package servidor.modelo.estados;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

import notificacion.Notificacion;
import notificacion.Registro;
import servidor.modelo.NoReceptoresFound;
import servidor.modelo.ReceptorServer;
import servidor.modelo.ReceptorServerFactory;
import servidor.modelo.Servidor;

public class PrimarioState extends State {

	private static int puertoEmisores = 1111;
	private static int puertoNuevosReceptores = 1234;
	private static int puertoHeartBeat = 4444;

	public PrimarioState(Servidor s) {
		super(s);
		System.out.println("El servidor esta en modo primario");
	}

	@Override
	public void initialize() {
		this.comienzoSincronizacion();
		this.comienzaEscuchaEmisores();
		this.comienzaEscuchaNuevosReceptor();

		this.s.getVista().setPuertoEmisores(puertoEmisores);
		this.s.getVista().setPuertoReceptores(puertoNuevosReceptores);
		this.s.getVista().setState(this.informarEstado());
	}

	@Override
	public void cambiaEstado() {
		this.s.setEstado(new SecundarioState(this.s));
		this.s.initialize();
	}

	@Override
	public String informarEstado() {
		return "Primario";
	}

	public void comienzaEscuchaEmisores() {
		new Thread() {
			public void run() {
				try {
					@SuppressWarnings("resource")
					ServerSocket s = new ServerSocket(puertoEmisores);
					System.out.println("Escuchando en " + puertoEmisores + " a los emisores");
					while (true) {

						Socket soc = s.accept();
						ObjectInputStream in = new ObjectInputStream(soc.getInputStream());
						ObjectOutputStream out = new ObjectOutputStream(soc.getOutputStream());

						Notificacion n = (Notificacion) in.readObject();

						try {
							Servidor.getInstance().logEnvio(n);
							this.reparteNotificacion(n);

							out.writeObject("Se envio con exito su emergencia.");
						} catch (NoReceptoresFound e) {
							out.writeObject(e.getMessage());
						}
						Servidor.getInstance().agregaAlHistorial(n);
					}

				} catch (BindException e) {
					Servidor.getInstance().cambiaEstado();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			public void reparteNotificacion(Notificacion n) throws NoReceptoresFound {
				int bandera = 0;
				int indice = 0;
				boolean huboerror = false;
				if (indice <= s.getReceptores().size())
					bandera = 1;
				while (indice < s.getReceptores().size()) {
					ReceptorServer actual = s.getReceptores().get(indice);
					if (n.mostrarse(actual.getInterruptor())) {
						bandera = 2;
						try {
							Socket socket = new Socket(actual.getDireccion(), actual.getPuerto());
							ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
							Servidor.getInstance().logReparte("Se ha enviado la emergencia al receptor con IP = "+actual.getDireccion()+" y puerto = "+actual.getPuerto()+"\n");
							out.writeObject(n);
							huboerror = false;
							out.close();
							socket.close();
						} catch (ConnectException e) {
							s.getReceptores().remove(indice);
							huboerror = true;
							bandera = 1;
						} catch (Exception e) {
							huboerror = false;
							e.printStackTrace();
						}
					}
					if (!huboerror)
						indice++;
				}

				try {
					Socket socket = new Socket("localhost", Servidor.getPuertoSyncNuevasNotificaciones());
					ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

					out.writeObject(n);

					out.close();
					socket.close();
				} catch (Exception e) {
					System.out.println("No encuentra al secundario");
				}
				
				
				if (bandera == 0) {
					Servidor.getInstance().logReparte("No hay receptores registrados.\n");
					throw new NoReceptoresFound("No hay receptores registrados.");
				}
				else if (bandera == 1) {
					Servidor.getInstance().logReparte("Ningun receptor atiende el tipo de emergencia solicitada.\n");
					throw new NoReceptoresFound("No hay receptores que atiendan su emergencia.");
				}
			}
		}.start();
	}

	public void comienzaEscuchaNuevosReceptor() {
		new Thread() {
			public void run() {
				try {
					@SuppressWarnings("resource")
					ServerSocket s = new ServerSocket(puertoNuevosReceptores);
					System.out.println("Escuchando en " + puertoNuevosReceptores + " para nuevos receptores");

					while (true) {

						Socket soc = s.accept();
						ObjectInputStream in = new ObjectInputStream(soc.getInputStream());
						Registro r = (Registro) in.readObject();

						ReceptorServer rs = ReceptorServerFactory.getReceptorServer(r.getUbicacion(), r.getPuerto(),
								r.getTipos());
						Servidor.getInstance().agregarReceptor(rs);
						Servidor.getInstance().logNuevoRegistroReceptor(r.getUbicacion(), r.getPuerto(), r.isIncendio(),
								r.isSeguridad(), r.isAmbulancia());

						Socket socket = new Socket("localhost", Servidor.getPuertoSyncNuevosReceptores());
						ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

						out.writeObject(rs);

						out.close();
						socket.close();

					}

				} catch (BindException e) {
System.out.println("Hola");
				} catch (ConnectException e) {
					System.out.println("No hay secundario aun");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	public void comienzoSincronizacion() {
		new Thread() {
			private Timer t = new Timer();

			public void run() {
				try {
					ServerSocket s = new ServerSocket(Servidor.getPuertoSincronizacion());
					System.out.println("Escuchando en " + Servidor.getPuertoSincronizacion()
							+ " para sincronizacion con secundarios");

					this.iniciaTimer();
					while (true) {

						Socket soc = s.accept();
						ObjectOutputStream out = new ObjectOutputStream(soc.getOutputStream());

						out.writeObject(Servidor.getInstance().getReceptores());
						out.writeObject(Servidor.getInstance().getHistorial());
					}

				} catch (BindException e) {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			private void iniciaTimer() {
				this.t.scheduleAtFixedRate(new TimerTask() {

					@Override
					public void run() {
						try {
							Socket socket = new Socket("localhost", puertoHeartBeat);
							ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

							out.writeObject(true);

							out.close();
							socket.close();

						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				}, 0, 5000);
			}
		}.start();
	}

}
