package servidor.modelo.estados;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import notificacion.Notificacion;
import servidor.modelo.ReceptorServer;
import servidor.modelo.Servidor;

public class SecundarioState extends State {

	public SecundarioState(Servidor s) {
		super(s);
	}

	@Override
	public void initialize() {
		try {
			Socket socket = new Socket("localhost", Servidor.getPuertoSincronizacion());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			
			ArrayList<ReceptorServer> receptores = (ArrayList<ReceptorServer>) in.readObject();
			this.s.setReceptores(receptores);
			
			ArrayList<Notificacion> historial = (ArrayList<Notificacion>) in.readObject();
			
			this.s.setHistorial(historial);
			
			out.close();
			
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void cambiaEstado() {
		this.s.setEstado(new PrimarioState(this.s));
		this.initialize();
	}

	@Override
	public String informarEstado() {
		return "Secundario";
	}

	
}
