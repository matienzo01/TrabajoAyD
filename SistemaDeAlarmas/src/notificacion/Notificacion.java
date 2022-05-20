package notificacion;

import java.io.Serializable;
import java.util.Calendar;

public abstract class Notificacion implements Serializable {
	private String ubicacion;
	private int hora, minutos;

	public Notificacion(String ubicacion) {
		this.ubicacion = ubicacion;
		this.hora = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		this.minutos = Calendar.getInstance().get(Calendar.MINUTE);
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getHora() {
		return hora;
	}

	public int getMinutos() {
		return minutos;
	}

	public abstract boolean mostrarse(Interruptor interruptor);

	@Override
	public String toString() {
		return ubicacion + " | " + hora + ":" + minutos ;
	}

	public String toStringAdmin() {
		return "enviada desde " + this.ubicacion + " a las " + this.hora + " y " + this.minutos;
	}
}
