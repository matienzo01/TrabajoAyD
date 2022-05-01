package emisor.modelo;

import receptor.modelo.Interruptor;

public class Seguridad extends Notificacion {

	public Seguridad(String ubicacion) {
		super(ubicacion);
	}

	@Override
	public String toString() {
		return "  Personal de seguridad | " + super.toString();
	}

	@Override
	public boolean mostrarse(Interruptor tipo) {
		return tipo.isSeguridad();
	}

}
