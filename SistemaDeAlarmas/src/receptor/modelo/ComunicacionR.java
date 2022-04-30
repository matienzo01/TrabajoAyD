package receptor.modelo;

public class ComunicacionR {
	
	private String host = "localhost";
	private int puerto;

	public ComunicacionR() {
		// TODO Auto-generated constructor stub
	}
	
	public void actualizarPuerto(int puerto) {
		this.puerto = puerto;
//		System.out.println("Nuevo puerto: " + puerto);
	}

}
