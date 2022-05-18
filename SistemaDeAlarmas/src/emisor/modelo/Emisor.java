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
	public void cambiarUbicacion(String nuevaUbicacion) {
		this.ubicacion = nuevaUbicacion;
	}

	@Override
	public String enviarNotificacion(String tipo) {
		if(this.ubicacion!=null) {
			Notificacion n = NotificacionFactory.getNotificacion(tipo, this.ubicacion);
			return c.enviaNotificacion(n);
		}
		else
			return "Debe especificar la ubicacion antes de solicitar emergencia";
	}

	@Override
	public String getUbicacion() {
		return ubicacion;
	}

}
