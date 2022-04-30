package receptor.prueba;

import receptor.controlador.ControladorReceptor;
import receptor.vista.IVistaReceptor;
import receptor.vista.VentanaReceptor;

public class Prueba {
	public static void main(String[] args) {
		IVistaReceptor vista = new VentanaReceptor();
		ControladorReceptor c = new ControladorReceptor(vista);
	}
}
