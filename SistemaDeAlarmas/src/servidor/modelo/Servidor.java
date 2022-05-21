package servidor.modelo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import notificacion.Notificacion;
import notificacion.Registro;
import servidor.vista.IVistaServidor;
import servidor.vista.VistaServidor;

public class Servidor implements IServidor {
	private static int puertoEmisores = 1111;
	private static int puertoNuevosReceptores = 1234;
	private static Servidor instance = null;
	private ArrayList<ReceptorServer> receptores = new ArrayList<ReceptorServer>();
	private ArrayList<Notificacion> historial = new ArrayList<Notificacion>(); 

	private IVistaServidor vista = new VistaServidor();

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
		this.vista.setPuertoEmisores(puertoEmisores);
		this.vista.setPuertoReceptores(puertoNuevosReceptores);
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

						try {
							Servidor.getInstance().reparteNotificacion(n);
			
							out.writeObject("Se envio con exito su emergencia.");
						} catch (NoReceptoresFound e) {
							out.writeObject(e.getMessage());
						}
						Servidor.getInstance().agregaAlHistorial(n);
						Servidor.getInstance().logEnvioExitoso(n);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	protected void agregaAlHistorial(Notificacion n) {
		this.historial.add(n);
		
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
						
						ReceptorServer rs = ReceptorServerFactory.getReceptorServer(r.getUbicacion(), r.getPuerto(),
								r.getTipos());
						Servidor.getInstance().agregarReceptor(rs);
						Servidor.getInstance().logNuevoRegistroReceptor(r.getUbicacion(), r.getPuerto(), r.isIncendio(), r.isSeguridad(), r.isAmbulancia());
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
		int bandera = 0;
		Iterator<ReceptorServer> it = this.receptores.iterator();
		while (it.hasNext()) {
			bandera = 1;
			ReceptorServer rs = it.next();
			if (n.mostrarse(rs.getInterruptor())) {
				bandera = 2;
				try {
					Socket socket = new Socket(rs.getDireccion(), rs.getPuerto());
					ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

					out.writeObject(n);

					out.close();
					socket.close();
				}catch(ConnectException e) {
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		if (bandera == 0)
			throw new NoReceptoresFound("No hay receptores registrados.");
		else if (bandera == 1)
			throw new NoReceptoresFound("No hay receptores que atiendan su emergencia.");
	}

	public void logNuevoRegistroReceptor(String direccion, int puerto, boolean incendio, boolean seguridad,
			boolean amblancia) {
		this.vista.agregaLogRegistro(direccion, puerto, incendio, seguridad, amblancia);
	}
	
	public void logEnvioExitoso(Notificacion n) {
		this.vista.agregaLogEmisor(n.toStringAdmin());
		
	}
	
	public void logErrorAlEnvio(String error) {
		this.vista.agregaLogError(error);
	}
	

}
