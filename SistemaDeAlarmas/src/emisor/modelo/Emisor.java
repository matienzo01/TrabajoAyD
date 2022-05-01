package emisor.modelo;

import notificacion.Notificacion;
import notificacion.NotificacionFactory;

public class Emisor implements IEmisor {
	private static IEmisor instance = null;
	private static Comunicacion c = new Comunicacion();
	private String ubicacion;

	private Emisor() {
	}

	public static IEmisor getInstance() {
		if (instance == null)
			instance = new Emisor();
		return instance;
	}

	@Override
	public void agregarDestinatario(String IP, int puerto) {
		c.agregarDestinatario(IP, puerto);

	}

	@Override
	public void cambiarUbicacion(String nuevaUbicacion) {
		this.ubicacion = nuevaUbicacion;
	}

	@Override
	public void enviarNotificacion(String tipo) {
		if(this.ubicacion!=null) {
			Notificacion n = NotificacionFactory.getNotificacion(tipo, this.ubicacion);
			c.enviaNotificacion(n);
		}
	}

	@Override
	public String getUbicacion() {
		return ubicacion;
	}

}
