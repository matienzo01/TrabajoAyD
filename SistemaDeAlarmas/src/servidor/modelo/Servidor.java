package servidor.modelo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import emisor.modelo.Comunicacion;
import notificacion.Notificacion;
import notificacion.Registro;

public class Servidor implements IServidor {
	private static int puertoEmisores = 1111;
	private static int puertoNuevosReceptores = 1234;
	private static Servidor instance = null;
	private ArrayList<ReceptorServer> receptores = new ArrayList<ReceptorServer>();
	private ArrayList<Notificacion> historial = new ArrayList<Notificacion>();  // podriamos extender la clase
																				// notificacion para que tenga unos
																				// datos mas y usarla para historial

	private Servidor() {
	}

	public static Servidor getInstance() {
		if (Servidor.instance == null)
			Servidor.instance = new Servidor();
		return Servidor.instance;
	}

	@Override
	public void initialize() {
		this.comienzaEscuchaEmisores();
		this.comienzaEscuchaNuevosReceptor();
	}

	private void comienzaEscuchaEmisores() {
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
						
						System.out.println(n.toString());

						// TODO que se mande solamente a los receptores que tienen el tipo, si se envio
						// a al menos 1, confirma el envio

						try {
							Servidor.getInstance().reparteNotificacion(n);
							out.writeObject("Se envio con exito su emergencia.");
						}
						catch (Exception e) {
							out.writeObject(e.getMessage());
						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	private void comienzaEscuchaNuevosReceptor() {
		new Thread() {
			public void run() {
				try {
					@SuppressWarnings("resource")
					ServerSocket s = new ServerSocket(puertoNuevosReceptores);
					System.out.println("Escuchando en " + puertoNuevosReceptores + " para nuevos receptores");

					while (true) {

						Socket soc = s.accept();
						ObjectInputStream in = new ObjectInputStream(soc.getInputStream());
						ObjectOutputStream out = new ObjectOutputStream(soc.getOutputStream());

						Registro r = (Registro) in.readObject();
						System.out.println("Se ha registrado un nuevo receptor que escucha en puerto " + r.getPuerto());
						System.out.println("Los incendios los escucha: " + r.isIncendio());
						System.out.println("Los seguridad los escucha: " + r.isSeguridad());
						System.out.println("Los ambulancia los escucha: " + r.isAmbulancia());

						ReceptorServer rs = ReceptorServerFactory.getReceptorServer(r.getUbicacion(), r.getPuerto(),
								r.getTipos());
						Servidor.getInstance().agregarReceptor(rs);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	@Override
	public void agregarReceptor(ReceptorServer rs) {
		this.receptores.add(rs);

	}

	@Override
	public void reparteNotificacion(Notificacion n) throws NoReceptoresFound {
		int bandera = 0 ;
		Iterator<ReceptorServer> it = this.receptores.iterator();
		while(it.hasNext()) {
			bandera = 1;
			ReceptorServer rs = it.next();
			if(n.mostrarse(rs.getInterruptor())) {
				bandera = 2;
				try {
					Socket socket = new Socket(rs.getDireccion(), rs.getPuerto());
					ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

					out.writeObject(n);

					out.close();
					socket.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		if(bandera == 0)
			throw new NoReceptoresFound("No hay receptores registrados.");
		else if(bandera ==1)
			throw new NoReceptoresFound("No hay receptores que atiendan su emergencia.");
	}

}
