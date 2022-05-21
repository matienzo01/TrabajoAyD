package receptor.modelo;

import notificacion.Interruptor;

public interface IReceptor {

	public void actualizarPuerto(int puerto);

	public void toggleIncendio();

	public void toggleSeguridad();

	public void toggleAmbulancia();

	public Interruptor getInterruptorTipos();
	
	public void registraEnServidor();
	
	public boolean isIncendios();
	public boolean isAmbulancia();
	public boolean isSeguridad();

}