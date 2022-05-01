package emisor.modelo;

public class Seguridad extends Notificacion {

	public Seguridad(String ubicacion) {
		super(ubicacion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Personal de seguridad en " + this.getUbicacion();
	}

	@Override
	public String getTipo() {
		return "seguridad";
	}

}
