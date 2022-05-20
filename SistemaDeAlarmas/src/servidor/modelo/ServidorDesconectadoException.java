package servidor.modelo;

import java.net.ConnectException;

public class ServidorDesconectadoException extends ConnectException{
	
	private String direccion;
	private int puerto;
	
	public ServidorDesconectadoException(String msg, String direccion, int puerto) {
		super(msg);
		this.direccion = direccion;
		this.puerto = puerto;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getPuerto() {
		return puerto;
	}
	
	
	
	

}
