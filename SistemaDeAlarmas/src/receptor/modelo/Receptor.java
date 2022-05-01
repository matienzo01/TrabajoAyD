package receptor.modelo;

import notificacion.Interruptor;

public class Receptor implements IReceptor {
	private static IReceptor instance = null;
	private static IComunicacionR c = null;
	private Interruptor tipos;

	private Receptor() {
		c = ComunicacionR.getInstance();
		tipos = Interruptor.getInstance();
	}

	public static IReceptor getInstance() {
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

	@Override
	public void actualizarPuerto(int puerto) {
		Receptor.c.actualizarPuerto(puerto);
	}

	@Override
	public void toggleIncendio() {
		tipos.setIncendios(!tipos.isIncendios());
	}

	@Override
	public void toggleSeguridad() {
		tipos.setSeguridad(!tipos.isSeguridad());
	}

	@Override
	public void toggleAmbulancia() {
		tipos.setMedica(!tipos.isMedica());
	}

	@Override
	public void comienzaEscucha() {
		c.comienzaEscucha();
	}

	@Override
	public Interruptor getInterruptorTipos() {
		return tipos;
	}

}
