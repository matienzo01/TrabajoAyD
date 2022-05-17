package notificacion;

public class RegistroFactory {
	
	public static Registro getRegistro(boolean ambulancia, boolean incendio, boolean seguridad, String ubicacion, int puerto){
		Registro respuesta = null;
		
		respuesta = new Registro(ambulancia, incendio, seguridad, "localhost", puerto);
		
		return respuesta;
	}

}
