package emisor.modelo;

import notificacion.Notificacion;

public interface IEmergencia {
	public void enviaNotificacion(Notificacion notificacion);
	//public void agregarDestinatario(String IP, int puerto);
}
