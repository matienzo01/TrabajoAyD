package notificacion;

public class NotificacionFactory {
	
	public static Notificacion getNotificacion(String tipo, String ubicacion){
		Notificacion respuesta = null;
		
		if(tipo.equalsIgnoreCase("incendio")) {
			respuesta = new Incendio(ubicacion);
		}else if(tipo.equalsIgnoreCase("seguridad")) {
			respuesta = new Seguridad(ubicacion);
		}else if(tipo.equalsIgnoreCase("ambulancia")) {
			respuesta = new Ambulancia(ubicacion);
		}
		
		return respuesta;
	}

}
