package servidor.vista;

public interface IVistaServidor {
	public void setPuertoReceptores(int puerto);
	public void setPuertoEmisores(int puerto);
	public void setState(String state);
	public void agregaLogRegistro(String direccion, int puerto, boolean incendio, boolean seguridad, boolean amblancia);
	public void agregaLogNotificacion(String cadena);
	public void agregaLogReparte(String string);
}
