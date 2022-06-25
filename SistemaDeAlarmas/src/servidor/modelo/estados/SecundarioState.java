package servidor.modelo.estados;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

import notificacion.Notificacion;
import servidor.modelo.ReceptorServer;
import servidor.modelo.Servidor;

public class SecundarioState extends State {

	private static int puertoToggle = 3333;

	public SecundarioState(Servidor s) {
		super(s);
		System.out.println("El servidor esta en modo secundario");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initialize() {
		try {
			Socket socket = new Socket("localhost", Servidor.getPuertoSincronizacion());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			ArrayList<ReceptorServer> receptores = (ArrayList<ReceptorServer>) in.readObject();
			this.s.setReceptores(receptores);

			ArrayList<String> historial = (ArrayList<String>) in.readObject();

			this.s.setHistorial(historial);

			out.close();

			socket.close();

			System.out.println("Los receptores mandados son");
			System.out.println(receptores);
			System.out.println("El historial es");
			System.out.println(historial);
			this.s.getVista().setState(this.informarEstado());
			this.comienzaEspera();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void cambiaEstado() {
		this.s.setEstado(new PrimarioState(this.s));
		this.s.initialize();
	}

	@Override
	public String informarEstado() {
		return "Secundario";
	}

	public void comienzaEspera() {
		new Thread() {
			public void run() {
				try {
					ServerSocket s = new ServerSocket(puertoToggle);

					System.out.println("Escuchando en " + puertoToggle + " al momento de ser primario");
					while (true) {
						Socket soc = s.accept();
						Servidor.getInstance().cambiaEstado();
						s.close();
					}

				} catch (SocketException e) {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();

		new Thread() {
			public void run() {
				try {
					ServerSocket s = new ServerSocket(Servidor.getPuertoSyncNuevasNotificaciones());

					System.out.println("Escuchando en " + Servidor.getPuertoSyncNuevasNotificaciones()
							+ " nuevas notif mientras sea secundario");
					while (true) {
						Socket soc = s.accept();
						ObjectInputStream in = new ObjectInputStream(soc.getInputStream());

						String n = (String) in.readObject();

						Servidor.getInstance().agregaAlHistorial(n);

						System.out.println("Se ha recibido una nueva notificacion en "+ n.toString());
						
						soc.close();
					}

				} catch (SocketException e) {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();

		new Thread() {
			public void run() {
				try {
					ServerSocket s = new ServerSocket(Servidor.getPuertoSyncNuevosReceptores());

					System.out.println("Escuchando en " + Servidor.getPuertoSyncNuevosReceptores()
							+ " nuevos receptores mientras sea secundario");
					while (true) {
						Socket soc = s.accept();
						ObjectInputStream in = new ObjectInputStream(soc.getInputStream());

						ReceptorServer rs = (ReceptorServer) in.readObject();

						Servidor.getInstance().agregarReceptor(rs);
						
						System.out.println("Se ha registrado un nuevo receptor en "+ rs.getPuerto());

						soc.close();
					}

				} catch (SocketException e) {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
}
