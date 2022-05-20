package servidor.modelo;

import notificacion.Notificacion;

public interface IServidor {
	public void agregarReceptor(ReceptorServer rs);
	
	public void initialize();
	
	public void reparteNotificacion(Notificacion n) throws NoReceptoresFound, ServidorDesconectadoException;
}
