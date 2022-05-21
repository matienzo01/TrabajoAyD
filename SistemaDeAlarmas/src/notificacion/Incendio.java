package notificacion;

public class Incendio extends Notificacion {

	public Incendio(String ubicacion) {
		super(ubicacion);
	}

	@Override
	public String toString() {
		return "        Incendio        | " + super.toString();
	}


	@Override
	public boolean mostrarse(Interruptor tipo) {
		return tipo.isIncendios();
	}

	@Override
	public String toStringAdmin() {
		return "Notificacion de Incendio " + super.toStringAdmin();
	}
}
