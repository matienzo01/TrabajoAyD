package servidor.vista;

public interface IVistaServidor {
	public void setPuertoReceptores(int puerto);
	public void setPuertoEmisores(int puerto);
	public void agregaLogRegistro(String direccion, int puerto, boolean incendio, boolean seguridad, boolean amblancia);
	public void agregaLogEmisor(String cadena);
	public void agregaLogError(String error);
}
