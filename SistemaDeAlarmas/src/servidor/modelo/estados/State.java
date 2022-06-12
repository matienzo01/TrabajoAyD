package servidor.modelo.estados;

import servidor.modelo.Servidor;

public abstract class State implements IState{
	protected Servidor s;

	public State(Servidor s) {
		this.s = s;
	}

	
	
	
}
