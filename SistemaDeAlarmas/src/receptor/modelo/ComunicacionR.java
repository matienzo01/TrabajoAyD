package receptor.modelo;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

import notificacion.Notificacion;

@SuppressWarnings("deprecation")
public class ComunicacionR extends Observable implements IComunicacionR {

	private int puerto;
	private static ComunicacionR instance = null;

	private ComunicacionR() {
	}

	public static ComunicacionR getInstance() {
		if (instance == null)
			instance = new ComunicacionR();
		return instance;
	}

	@Override
	public void actualizarPuerto(int puerto) {
		this.puerto = puerto;
	}

	@Override
	public void comienzaEscucha() {
		new Thread() {
			public void run() {
				try {
					@SuppressWarnings("resource")
					ServerSocket s = new ServerSocket(puerto);

					while (true) {

						Socket soc = s.accept();
						ObjectInputStream in = new ObjectInputStream(soc.getInputStream());

						Notificacion notificacion = (Notificacion) in.readObject();

						ComunicacionR c = ComunicacionR.getInstance();
						setChanged();
						c.notifyObservers(notificacion);

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

}
