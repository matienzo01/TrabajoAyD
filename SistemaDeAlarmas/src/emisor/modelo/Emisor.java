package emisor.modelo;

import notificacion.Notificacion;
import notificacion.NotificacionFactory;

public class Emisor {
	private static Emisor instance = null;
	private static Comunicacion c = new Comunicacion();
	private String ubicacion;

	private Emisor() {
	}

	public static Emisor getInstance() {
		if (instance == null)
			instance = new Emisor();
		return instance;
	}

	public void agregarDestinatario(String IP, int puerto) {
		c.agregarDestinatario(IP, puerto);

	}

	public void cambiarUbicacion(String nuevaUbicacion) {
		this.ubicacion = nuevaUbicacion;
	}

	public void enviarNotificacion(String tipo) {
		if(this.ubicacion!=null) {
			Notificacion n = NotificacionFactory.getNotificacion(tipo, this.ubicacion);
			c.enviaNotificacion(n);
		}
	}

	public String getUbicacion() {
		return ubicacion;
	}

}
