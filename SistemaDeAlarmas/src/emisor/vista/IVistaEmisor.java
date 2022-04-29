package emisor.vista;

import java.awt.event.ActionListener;

public interface IVistaEmisor {

	void setActionListener(ActionListener actionListener);
	public String getUbicacion();
	public String getNuevaIp();
	public String getNuevaPuerto();
	public void mostrarNuevaUbicacion(String ubicacion);
	public void mostrarError(String error);
	public void limpiaCamposIP();
	public void limpiaCampoNuevaUbicacion();
	
}
