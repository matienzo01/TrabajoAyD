package notificacion;

import java.io.Serializable;

public class Registro implements Serializable{
	
	private boolean ambulancia, incendio, seguridad;
	private String ubicacion;
	private int puerto;
	
	public Registro(boolean ambulancia, boolean incendio, boolean seguridad, String ubicacion, int puerto) {
		this.ambulancia = ambulancia;
		this.incendio = incendio;
		this.seguridad = seguridad;
		this.ubicacion = ubicacion;
		this.puerto = puerto;
	}

	public boolean isAmbulancia() {
		return ambulancia;
	}

	public boolean isIncendio() {
		return incendio;
	}

	public boolean isSeguridad() {
		return seguridad;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public int getPuerto() {
		return puerto;
	}

	@Override
	public String toString() {
		return "Registro [ambulancia=" + ambulancia + ", incendio=" + incendio + ", seguridad=" + seguridad
				+ ", ubicacion=" + ubicacion + ", puerto=" + puerto + "]";
	}
	
	

}
