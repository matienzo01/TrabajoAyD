package emisor.modelo;

import receptor.modelo.Interruptor;

public class Seguridad extends Notificacion {

	public Seguridad(String ubicacion) {
		super(ubicacion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Personal de seguridad en " + this.getUbicacion();
	}

	@Override
	public String getTipo() {
		return "seguridad";
	}
	
	@Override
	public boolean mostrarse(Interruptor tipo) {
		// TODO Auto-generated method stub
		return tipo.isSeguridad();
	}

}
