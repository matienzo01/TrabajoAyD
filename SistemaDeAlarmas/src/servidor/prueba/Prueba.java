package servidor.prueba;

import servidor.modelo.Servidor;

public class Prueba {

	public static void main(String[] args) {
		Servidor s = Servidor.getInstance();
		s.initialize(1234, 5555);

	}

}
