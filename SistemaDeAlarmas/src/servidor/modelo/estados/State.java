package servidor.modelo.estados;

import java.util.Observable;

import servidor.modelo.Servidor;

public abstract class State extends Observable implements IState{
	protected Servidor s;

	public State(Servidor s) {
		this.s = s;
	}
	
	
}
