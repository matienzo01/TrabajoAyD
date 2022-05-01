package emisor.modelo;

import receptor.modelo.Interruptor;

public class Incendio extends Notificacion {

	public Incendio(String ubicacion) {
		super(ubicacion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "        Incendio        | " + super.toString();
	}


	@Override
	public boolean mostrarse(Interruptor tipo) {
		// TODO Auto-generated method stub
		return tipo.isIncendios();
	}

}
