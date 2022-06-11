package servidor.modelo;

import java.io.Serializable;

import notificacion.Interruptor;

public class ReceptorServer implements Serializable{

	private String direccion;
	private int puerto;
	private Interruptor interruptor;

	public ReceptorServer(String direccion, int puerto, Interruptor tipos) {
		this.direccion = direccion;
		this.puerto = puerto;
		this.interruptor = tipos;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getPuerto() {
		return puerto;
	}

	public boolean isIncendio() {
		return interruptor.isIncendios();
	}

	public boolean isSeguridad() {
		return interruptor.isSeguridad();
	}

	public boolean isAmbulancia() {
		return interruptor.isMedica();
	}

	public Interruptor getInterruptor() {
		return interruptor;
	}
	
	

}
