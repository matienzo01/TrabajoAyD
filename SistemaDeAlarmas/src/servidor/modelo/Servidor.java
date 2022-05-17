package servidor.modelo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import notificacion.Notificacion;
import notificacion.Registro;

public class Servidor implements IServidor {
	private static int puertoEmisores = 1111;
	private static int puertoNuevosReceptores = 1234;
	private static Servidor instance = null;
	private ArrayList<ReceptorServer> receptores = new ArrayList<ReceptorServer>();
	private ArrayList<Notificacion> historial = new ArrayList<Notificacion>(); // podriamos extender la clase
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

						// TODO que se mande solamente a los receptores que tienen el tipo, si se envio
						// a al menos 1, confirma el envio

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
								r.isIncendio(), r.isSeguridad(), r.isAmbulancia());
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

}
