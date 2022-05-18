package notificacion;

import java.io.Serializable;

public class Interruptor implements Serializable{
	private boolean incendios, medica, seguridad;

	public Interruptor(boolean incendios, boolean medica, boolean seguridad) {
		this.incendios = incendios;
		this.medica = medica;
		this.seguridad = seguridad;
	}

	public boolean isIncendios() {
		return incendios;
	}

	public void setIncendios(boolean incendios) {
		this.incendios = incendios;
	}

	public boolean isMedica() {
		return medica;
	}

	public void setMedica(boolean medica) {
		this.medica = medica;
	}

	public boolean isSeguridad() {
		return seguridad;
	}

	public void setSeguridad(boolean seguridad) {
		this.seguridad = seguridad;
	}

}
