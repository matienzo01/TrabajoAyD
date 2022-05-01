package receptor.modelo;

public class Receptor {
	private static Receptor instance = null;
	private static ComunicacionR c = null;
	private Interruptor tipos;

	private Receptor() {
		c = ComunicacionR.getInstance();
		tipos = Interruptor.getInstance();
	}

	public static Receptor getInstance() {
		if (instance == null)
			instance = new Receptor();
		return instance;
	}

	public static ComunicacionR getC() {
		return ComunicacionR.getInstance();
	}

	public boolean isIncendios() {
		return tipos.isIncendios();
	}

	public boolean isAmbulancia() {
		return tipos.isMedica();
	}

	public boolean isSeguridad() {
		return tipos.isSeguridad();
	}

	public void actualizarPuerto(int puerto) {
		Receptor.c.actualizarPuerto(puerto);
	}

	public void toggleIncendio() {
		tipos.setIncendios(!tipos.isIncendios());
	}

	public void toggleSeguridad() {
		tipos.setSeguridad(!tipos.isSeguridad());
	}

	public void toggleAmbulancia() {
		tipos.setMedica(!tipos.isMedica());
	}

	public void comienzaEscucha() {
		c.comienzaEscucha();
	}

	public Interruptor getInterruptorTipos() {
		return tipos;
	}

}
