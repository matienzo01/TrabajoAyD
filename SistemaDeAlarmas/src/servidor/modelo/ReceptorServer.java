package servidor.modelo;

public class ReceptorServer {
	private String direccion;
	private int puerto;
	private boolean incendio, seguridad, ambulancia;
	
	public ReceptorServer(String direccion, int puerto, boolean incendio, boolean seguridad, boolean ambulancia) {
		this.direccion = direccion;
		this.puerto = puerto;
		this.incendio = incendio;
		this.seguridad = seguridad;
		this.ambulancia = ambulancia;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getPuerto() {
		return puerto;
	}

	public boolean isIncendio() {
		return incendio;
	}

	public boolean isSeguridad() {
		return seguridad;
	}

	public boolean isAmbulancia() {
		return ambulancia;
	}
	
	

}
