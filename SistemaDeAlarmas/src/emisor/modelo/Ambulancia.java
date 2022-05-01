package emisor.modelo;

import receptor.modelo.Interruptor;

public class Ambulancia extends Notificacion {

	public Ambulancia(String ubicacion) {
		super(ubicacion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Asistencia Medica en " + this.getUbicacion();
	}

	@Override
	public String getTipo() {
		return "ambulancia";
	}

	@Override
	public boolean mostrarse(Interruptor tipo) {
		// TODO Auto-generated method stub
		return tipo.isMedica();
	}
	
}
