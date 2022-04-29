package emisor.prueba;

import emisor.controlador.Controlador;
import emisor.vista.IVistaEmisor;
import emisor.vista.VentanaEmisor;

public class Prueba {

	public static void main(String[] args) {
		IVistaEmisor vista = new VentanaEmisor();
		Controlador c = new Controlador(vista);
		System.out.println("Se ejecuto bien");

	}

}
