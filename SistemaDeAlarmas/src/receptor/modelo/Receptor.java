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
	
	public void cambiarPuerto(String puerto) {
		
	}
	
	
	
}
