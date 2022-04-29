package emisor.vista;

import java.awt.event.ActionListener;

public interface IVistaConfiguracion {
	void setActionListener(ActionListener actionListener);
	public String getUbicacion();
	public String getNuevaIp();
	public String getNuevaPuerto();
	public void mostrarNuevaUbicacion(String ubicacion);
	public void mostrarError(String error);
}
