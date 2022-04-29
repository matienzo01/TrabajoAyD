package emisor.modelo;

public class Emisor {
	private static Emisor instance = null;
	
	private Emisor(){}
	
	//El emisor es singleton
	public static Emisor getInstance(){
		if(instance == null)
			instance = new Emisor();
		return instance;
	}
	
	
}
