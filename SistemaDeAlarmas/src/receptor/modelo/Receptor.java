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
		if(instance==null)
			instance=new Receptor();
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
		this.c.actualizarPuerto(puerto);
	}
	
	public void toggleIncendio() {
		//this.incendios = !this.incendios;
//		this.diceEstados();
		tipos.setIncendios(!tipos.isIncendios());
	}
	
	public void toggleSeguridad() {
		//this.seguridad = !this.seguridad;
//		this.diceEstados();
		tipos.setSeguridad(!tipos.isSeguridad());
	}
	
	public void toggleAmbulancia() {
		//this.ambulancia = !this.ambulancia;
//		this.diceEstados();
		tipos.setMedica(!tipos.isMedica());
	}
	
	private void diceEstados() {
		System.out.println("Incendio :" + tipos.isIncendios());
		System.out.println("Ambulancia :" + tipos.isMedica());
		System.out.println("Seguridad :" + tipos.isSeguridad());
	}


	public void comienzaEscucha() {
		c.comienzaEscucha();
	}

	public Interruptor getInterruptorTipos() {
		return tipos;
	}

	
}
