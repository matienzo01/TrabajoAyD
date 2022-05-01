package emisor.modelo;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

import notificacion.Notificacion;

public class Comunicacion implements IEmergencia {

	private HashMap<String, Integer> destinatarios = new HashMap<String, Integer>();

	@Override
	public void enviaNotificacion(Notificacion notificacion) {
		for (String direccion : this.destinatarios.keySet()) {
			try {
				Socket socket = new Socket(direccion, this.destinatarios.get(direccion));
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				out.writeObject(notificacion);
				out.close();
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void agregarDestinatario(String IP, int puerto) {
		this.destinatarios.put(IP, puerto);

	}

}
