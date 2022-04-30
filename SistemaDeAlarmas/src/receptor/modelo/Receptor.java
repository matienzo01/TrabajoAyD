package receptor.modelo;

public class Receptor {
	private static Receptor instance = null;
	private static ComunicacionR c = null;
	public boolean incendios,ambulancia,seguridad;
	
	
	private Receptor() {
		c = new ComunicacionR();
		this.incendios=false;
		this.ambulancia=false;
		this.seguridad=false;
	}
	
	public static Receptor getInstance() {
		if(instance==null)
			instance=new Receptor();
		return instance;
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

	public void comienzaEscucha() {
		// TODO Auto-generated method stub
		c.comienzaEscucha();
	}

	
}
