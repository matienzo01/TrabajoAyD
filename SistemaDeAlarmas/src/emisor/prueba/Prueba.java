package emisor.prueba;

import emisor.controlador.Controlador;
import emisor.vista.IVista;
import emisor.vista.VentanaEmisor;

public class Prueba {

	public static void main(String[] args) {
		IVista vista = new VentanaEmisor();
		Controlador c = new Controlador(vista);
		System.out.println("Se ejecuto bien");

	}

}
