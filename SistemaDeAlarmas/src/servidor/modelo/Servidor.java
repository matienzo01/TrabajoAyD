package servidor.modelo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import notificacion.Notificacion;

public class Servidor{
	private static int puertoEmisor;
	private static int puertoReceptor;
	private static Servidor instance = null;
	private ArrayList<Receptor> receptores = new ArrayList<Receptor>();
	private ArrayList<Notificacion> historial = new ArrayList<Notificacion>(); //podriamos extender la clase notificacion para que tenga unos datos mas y usarla para historial
	
	private Servidor() {}
	
	public static Servidor getInstance() {
		if(Servidor.instance == null)
			Servidor.instance = new Servidor();
		return Servidor.instance;
	}
	
	private static void setPuerto(int puertoEmisor, int puertoReceptor) {
		Servidor.puertoEmisor = puertoEmisor;
		Servidor.puertoReceptor = puertoReceptor;
	}
	
	public void initialize(int puertoEmisor, int puertoReceptor) {
		Servidor.setPuerto(puertoEmisor, puertoReceptor);
		this.comienzaEscuchaEmisor();
		this.comienzaEscuchaReceptor();
	}
	
	private void comienzaEscuchaEmisor() {
		new Thread() {
			public void run() {
				try {
					@SuppressWarnings("resource")
					ServerSocket s = new ServerSocket(puertoEmisor);
					System.out.println("Emisor escuchando en " + puertoEmisor);
					while (true) {

						Socket soc = s.accept();
						ObjectInputStream in = new ObjectInputStream(soc.getInputStream());
						ObjectOutputStream out = new ObjectOutputStream(soc.getOutputStream());

						Notificacion n = (Notificacion) in.readObject();
						
						System.out.println(n.toString());

						
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
	
	private void comienzaEscuchaReceptor() {
		new Thread() {
			public void run() {
				try {
					@SuppressWarnings("resource")
					ServerSocket s = new ServerSocket(puertoReceptor);
					System.out.println("Receptor escuchando en " + puertoReceptor);
					
					while (true) {

						Socket soc = s.accept();
						ObjectInputStream in = new ObjectInputStream(soc.getInputStream());
						ObjectOutputStream out = new ObjectOutputStream(soc.getOutputStream());

						//TODO implementacion del registro de receptores

						
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

}
