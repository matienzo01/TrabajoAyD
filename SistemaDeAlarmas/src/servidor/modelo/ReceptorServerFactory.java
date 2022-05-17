package servidor.modelo;

public class ReceptorServerFactory {
	public static ReceptorServer getReceptorServer(String direccion, int puerto, boolean incendio, boolean seguridad, boolean ambulancia){
		ReceptorServer respuesta = null;
		
		respuesta = new ReceptorServer(direccion, puerto, incendio, seguridad, ambulancia);
		
		return respuesta;
	}
}
