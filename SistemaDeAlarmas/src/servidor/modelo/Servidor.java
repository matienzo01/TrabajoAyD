package servidor.modelo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import notificacion.Notificacion;
import notificacion.Registro;
import servidor.vista.IVistaServidor;
import servidor.vista.VistaServidor;

public class Servidor {
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
						Servidor.getInstance().logEnvio(n);
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

	public void reparteNotificacion(Notificacion n) throws NoReceptoresFound {
		int bandera = 0;
		int indice = 0;
		boolean huboerror=false;
		if(indice<=this.receptores.size())
			bandera=1;
		while (indice<this.receptores.size()) {
			ReceptorServer actual = this.receptores.get(indice);
			if (n.mostrarse(actual.getInterruptor())) {
				bandera = 2;
				try {
					Socket socket = new Socket(actual.getDireccion(), actual.getPuerto());
					ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

					out.writeObject(n);
					huboerror=false;
					out.close();
					socket.close();
				}catch(ConnectException e) {
					Servidor.getInstance().receptores.remove(indice);
					huboerror=true;
					bandera=1;
				}catch (Exception e) {
					huboerror=false;
					e.printStackTrace();
				}
			}
			if(!huboerror)
				indice++;
		}
		
		if (bandera == 0)
			throw new NoReceptoresFound("No hay receptores registrados.");
		else if (bandera == 1)
			throw new NoReceptoresFound("No hay receptores que atiendan su emergencia.");
	}

	public void logNuevoRegistroReceptor(String direccion, int puerto, boolean incendio, boolean seguridad,
			boolean ambulancia) {
		this.vista.agregaLogRegistro(direccion, puerto, incendio, seguridad, ambulancia);
	}
	
	public void logEnvio(Notificacion n) {
		this.vista.agregaLogNotificacion(n.toStringAdmin());
		
	}
	
	protected void agregaAlHistorial(Notificacion n) {
		this.historial.add(n);
		
	}
	
	public void agregarReceptor(ReceptorServer rs) {
		this.receptores.add(rs);

	}
	

}
