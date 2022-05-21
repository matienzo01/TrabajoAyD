package notificacion;

public class Ambulancia extends Notificacion {

	public Ambulancia(String ubicacion) {
		super(ubicacion);
	}

	@Override
	public String toString() {
		return "    Asistencia Medica   | " + super.toString();
	}

	@Override
	public boolean mostrarse(Interruptor tipo) {
		return tipo.isMedica();
	}

	@Override
	public String toStringAdmin() {
		return "Notificacion Medica " + super.toStringAdmin();
	}

}
