package notificacion;

public class RegistroFactory {
	
	public static Registro getRegistro(Interruptor tipos, String ubicacion, int puerto){
		Registro respuesta = null;
		
		respuesta = new Registro(tipos, "localhost", puerto);
		
		return respuesta;
	}

}
