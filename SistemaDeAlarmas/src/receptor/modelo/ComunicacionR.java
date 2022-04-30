package receptor.modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

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
						BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

						String msg = in.readLine();
						System.out.println("LLEGO LA EMERGENCIA");
						System.out.println("Lo que se envio fue = "+msg);
					
						ComunicacionR c = ComunicacionR.getInstance();
						setChanged();
						c.notifyObservers(msg);
						
						
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("fin");
			}
		}.start();
	}

}
