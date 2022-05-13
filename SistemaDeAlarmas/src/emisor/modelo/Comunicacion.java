package emisor.modelo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import notificacion.Notificacion;

public class Comunicacion implements IEmergencia {

	private static int puertoEmisor = 1234;
	// private HashMap<String, Integer> destinatarios = new HashMap<String,
	// Integer>();

	@Override
	public void enviaNotificacion(Notificacion notificacion) {
		try {
			Socket socket = new Socket("localhost", Comunicacion.puertoEmisor);
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			out.writeObject(notificacion);

			out.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
