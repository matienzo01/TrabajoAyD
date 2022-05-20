package notificacion;

public class Ambulancia extends Notificacion {

	public Ambulancia(String ubicacion) {
		super(ubicacion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "    Asistencia Medica   | " + super.toString();
	}

	@Override
	public boolean mostrarse(Interruptor tipo) {
		// TODO Auto-generated method stub
		return tipo.isMedica();
	}

	@Override
	public String toStringAdmin() {
		return "Notificacion Medica " + super.toStringAdmin();
	}

}
