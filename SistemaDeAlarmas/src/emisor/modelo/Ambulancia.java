package emisor.modelo;

public class Ambulancia extends Notificacion {

	public Ambulancia(String ubicacion) {
		super(ubicacion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Asistencia Medica en " + this.getUbicacion();
	}

}
