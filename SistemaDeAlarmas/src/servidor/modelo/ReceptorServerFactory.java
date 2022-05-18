package servidor.modelo;

import notificacion.Interruptor;

public class ReceptorServerFactory {
	public static ReceptorServer getReceptorServer(String direccion, int puerto, Interruptor tipos){
		ReceptorServer respuesta = null;
		
		respuesta = new ReceptorServer(direccion, puerto, tipos);
		
		return respuesta;
	}
}
