package emisor.modelo;

public class Incendio extends Notificacion {

	public Incendio(String ubicacion) {
		super(ubicacion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Incendio en " + this.getUbicacion();
	}

	@Override
	public String getTipo() {
		return "incendio";
	}

}
