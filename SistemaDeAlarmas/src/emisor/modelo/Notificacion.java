package emisor.modelo;

import java.io.Serializable;

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

}
