package receptor.vista;

import java.awt.event.ActionListener;

import notificacion.Notificacion;

public interface IVistaReceptor {

	void setActionListener(ActionListener actionListener);
	public void mostrarError(String error);
	public String getNuevoPuerto();
	public void limpiaCampoPuerto();
	public void muestraPuerto(String puerto);
	public void agregarNotificacion(Notificacion n);
	public void puertoDefinido();
	void eliminaNotificacion(Notificacion n);
	Notificacion getSelectedNotification();
}
