package emisor.prueba;

import emisor.controlador.ControladorEmisor;
import emisor.modelo.Emisor;
import emisor.vista.IVistaEmisor;
import emisor.vista.VentanaEmisor;

public class PruebaEmisor {

	public static void main(String[] args) {
		IVistaEmisor vista = new VentanaEmisor();
		ControladorEmisor c = new ControladorEmisor(vista);
	}

}
