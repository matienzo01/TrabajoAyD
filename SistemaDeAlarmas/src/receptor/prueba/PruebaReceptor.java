package receptor.prueba;

import receptor.controlador.ControladorReceptor;
import receptor.modelo.Receptor;
import receptor.vista.IVistaReceptor;
import receptor.vista.VentanaReceptor;

public class PruebaReceptor {
	public static void main(String[] args) {
		IVistaReceptor vista = new VentanaReceptor();
		ControladorReceptor c = new ControladorReceptor(vista);
		Receptor.getInstance().toggleIncendio();
		Receptor.getInstance().actualizarPuerto(2222);
		Receptor.getInstance().registraEnServidor();
	}
}
