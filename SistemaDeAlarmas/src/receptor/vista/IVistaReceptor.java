package receptor.vista;

import java.awt.event.ActionListener;

public interface IVistaReceptor {

	void setActionListener(ActionListener actionListener);
	public void mostrarError(String error);
	public String getNuevoPuerto();
	public void limpiaCampoPuerto();
	public void muestraPuerto(String puerto);
}
