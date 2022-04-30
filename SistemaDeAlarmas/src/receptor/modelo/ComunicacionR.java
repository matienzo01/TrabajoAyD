package receptor.modelo;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

import emisor.modelo.Notificacion;

@SuppressWarnings("deprecation")
public class ComunicacionR extends Observable{

	private String host;
	private int puerto = 1234;
	public static ComunicacionR instance = null;

	private ComunicacionR() {
		this.host = "localhost";
	}

	public static ComunicacionR getInstance() {
		if(instance==null)
			instance=new ComunicacionR();
		return instance;
	}
	
	
	public void actualizarPuerto(int puerto) {
		this.puerto = puerto;
	}

	public void comienzaEscucha() {
		new Thread() {
			public void run() {
				try {
					ServerSocket s = new ServerSocket(puerto);

					while (true) {

						Socket soc = s.accept();
						ObjectInputStream in = new ObjectInputStream(soc.getInputStream());

						Notificacion notificacion = (Notificacion) in.readObject();
						System.out.println("LLEGO LA EMERGENCIA");
						System.out.println("Lo que se envio fue = "+ notificacion.toString());
					
						ComunicacionR c = ComunicacionR.getInstance();
						setChanged();
						c.notifyObservers(notificacion);
						
						
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("fin");
			}
		}.start();
	}

}
