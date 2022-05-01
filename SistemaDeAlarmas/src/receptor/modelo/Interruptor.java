package receptor.modelo;

public class Interruptor {
	private boolean incendios, medica, seguridad;
	private static Interruptor instance = null;

	private Interruptor() {
		this.incendios = false;
		this.medica = false;
		this.seguridad = false;
	}

	public static Interruptor getInstance() {
		if (instance == null)
			instance = new Interruptor();
		return instance;
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
