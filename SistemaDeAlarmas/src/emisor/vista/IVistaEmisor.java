package emisor.vista;

import java.awt.event.ActionListener;

public interface IVistaEmisor {

	public void setActionListener(ActionListener actionListener);
	public String getUbicacion();
	public void mostrarNuevaUbicacion(String ubicacion);
	public void mostrarError(String error);
	public void limpiaCampoNuevaUbicacion();
	public void mostrarEnvio(String mensaje);
	
}
