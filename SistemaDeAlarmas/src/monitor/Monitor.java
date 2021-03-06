package monitor;

import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Timer;
import java.util.TimerTask;

public class Monitor{
	private Boolean activo = true;
	private Timer t = new Timer();
	private static int puertoHeartBeat = 4444; //puerto donde recibira los latidos
	private static int puertoSecundario = 3333; //puerto donde lo espera el secundario para activarlo
	
	
	private static Monitor instance = null;
	
	private Monitor() {
		this.t.scheduleAtFixedRate(new TimerTask() {
				
				@Override
				public void run() {
					if(activo) {
						Monitor.getInstance().setActivo(false);
						System.out.println("Pasando a false");
					}
					else {
						try {
							Socket socket = new Socket("localhost", puertoSecundario);
							ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

							System.out.println("Cambiando secundario a primario");
							out.writeObject(true);
							
							
							out.close();
						} catch (ConnectException e) {
							System.out.println("No hay secundario aun");
						
						}catch (SocketException e) {
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
				}
			}, 1000, 5000);
		
		this.comienzaEsperaLatidos();
	}
	
	protected void setActivo(Boolean b) {
		this.activo = b;
		
	}

	public static Monitor getInstance() {
		if(instance == null)
			instance = new Monitor();
		return instance;
	}
	
	public void comienzaEsperaLatidos() {
		new Thread() {
			public void run() {
				try {
					ServerSocket s = new ServerSocket(puertoHeartBeat);
					System.out.println("Escuchando en " + puertoHeartBeat + " a los latidos del primerio");
					while (true) {
						Socket soc = s.accept();
						Monitor.getInstance().setActivo(true);
						System.out.println("El primario sigue vivo");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
}
