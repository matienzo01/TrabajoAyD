package emisor.modelo;

public class Emisor {
	private static Emisor instance = null;
	private static Comunicacion c = new Comunicacion();
	private String ubicacion;
	
	private Emisor(){}
	
	//El emisor es singleton
	public static Emisor getInstance(){
		if(instance == null)
			instance = new Emisor();
		return instance;
	}

	public void agregarDestinatario(int IP, int puerto) {
		c.agregarDestinatario(IP, puerto);
		
	}

	public void cambiarUbicacion(String nuevaUbicacion) {
		this.ubicacion = nuevaUbicacion;
	}
	
	
}
