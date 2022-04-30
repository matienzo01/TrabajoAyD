package receptor.modelo;

public class Receptor {
	private static Receptor instance = null;
	private static ComunicacionR c = null;
	public boolean incendios,ambulancia,seguridad;
	
	
	private Receptor() {
		c = ComunicacionR.getInstance();
		this.incendios=false;
		this.ambulancia=false;
		this.seguridad=false;
	}
	
	public static Receptor getInstance() {
		if(instance==null)
			instance=new Receptor();
		return instance;
	}
	
	
	
	public boolean isIncendios() {
		return incendios;
	}

	public boolean isAmbulancia() {
		return ambulancia;
	}

	public boolean isSeguridad() {
		return seguridad;
	}

	public void actualizarPuerto(int puerto) {
		this.c.actualizarPuerto(puerto);
	}
	
	public void toggleIncendio() {
		this.incendios = !this.incendios;
		this.diceEstados();
	}
	
	public void toggleSeguridad() {
		this.seguridad = !this.seguridad;
		this.diceEstados();
	}
	
	public void toggleAmbulancia() {
		this.ambulancia = !this.ambulancia;
		this.diceEstados();
	}
	
	private void diceEstados() {
		System.out.println("Incendio :" + this.incendios);
		System.out.println("Ambulancia :" + this.ambulancia);
		System.out.println("Seguridad :" + this.seguridad);
	}

	public static ComunicacionR getC() {
		return ComunicacionR.getInstance();
	}

	public void comienzaEscucha() {
		// TODO Auto-generated method stub
		c.comienzaEscucha();
	}

	
}
