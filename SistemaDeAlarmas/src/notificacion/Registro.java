package notificacion;

import java.io.Serializable;

public class Registro implements Serializable{
	
	private Interruptor tipos;
	private String ubicacion;
	private int puerto;
	
	public Registro(Interruptor tipos, String ubicacion, int puerto) {
		this.ubicacion = ubicacion;
		this.puerto = puerto;
		this.tipos = tipos;
	}

	public boolean isAmbulancia() {
		return tipos.isMedica();
	}

	public boolean isIncendio() {
		return tipos.isIncendios();
	}

	public boolean isSeguridad() {
		return tipos.isSeguridad();
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public int getPuerto() {
		return puerto;
	}

	public Interruptor getTipos() {
		return tipos;
	}

	
	
	

}
