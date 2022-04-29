package emisor.modelo;

public class NotificacionFactory {
	
	public static Notificacion getNotificacion(String tipo, String ubicacion){
		Notificacion respuesta = null;
		
		if(tipo.equalsIgnoreCase("incendio")) {
			respuesta = new Incendio(ubicacion);
		}else if(tipo.equalsIgnoreCase("seguridad")) {
			respuesta = new Seguridad(ubicacion);
		}else if(tipo.equalsIgnoreCase("ambulacia")) {
			respuesta = new Ambulancia(ubicacion);
		}
		
		return respuesta;
	}

}
