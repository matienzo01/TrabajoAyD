package emisor.modelo;

public interface IEmisor {

	public void cambiarUbicacion(String nuevaUbicacion);

	public String enviarNotificacion(String tipo);

	public String getUbicacion();

}