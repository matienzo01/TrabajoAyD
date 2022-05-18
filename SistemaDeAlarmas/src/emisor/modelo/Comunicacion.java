package emisor.modelo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import notificacion.Notificacion;

public class Comunicacion implements IEmergencia {

	private static int puertoEmisor = 1111;

	@Override
	public String enviaNotificacion(Notificacion notificacion) {
		String resultado = null ;
		try {
			Socket socket = new Socket("localhost", Comunicacion.puertoEmisor);
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			out.writeObject(notificacion);
			resultado = (String) in.readObject();

			out.close();
			
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

}
