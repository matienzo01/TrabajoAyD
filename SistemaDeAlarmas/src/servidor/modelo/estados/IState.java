package servidor.modelo.estados;

public interface IState {
	public void initialize();
	public void cambiaEstado();
	public String informarEstado();
}
