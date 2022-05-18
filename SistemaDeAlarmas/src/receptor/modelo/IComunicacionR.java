package receptor.modelo;

import notificacion.Interruptor;

public interface IComunicacionR {

	public void actualizarPuerto(int puerto);

	public void registraEnServidor(Interruptor tipos);

}