package emisor.modelo;

public class Gestor {
	private static Gestor instance = null;
	
	private Gestor(){}
	
	//El gestor es singleton
	public static Gestor getInstance(){
		if(instance == null)
			instance = new Gestor();
		return instance;
	}
	
	
}
