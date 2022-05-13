package emisor.modelo;

public interface IEmisor {

	public void cambiarUbicacion(String nuevaUbicacion);

	public void enviarNotificacion(String tipo);

	public String getUbicacion();

}