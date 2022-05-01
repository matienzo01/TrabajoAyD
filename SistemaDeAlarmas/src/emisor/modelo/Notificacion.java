package emisor.modelo;

import java.io.Serializable;

import receptor.modelo.Interruptor;

public abstract class Notificacion implements Serializable{
	private String ubicacion;

	public Notificacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public abstract String getTipo();
	
	public abstract boolean mostrarse(Interruptor interruptor);

}
