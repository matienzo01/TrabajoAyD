package receptor.modelo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

import notificacion.Interruptor;
import notificacion.Notificacion;
import notificacion.Registro;
import notificacion.RegistroFactory;

@SuppressWarnings("deprecation")
public class ComunicacionR extends Observable implements IComunicacionR {

	private static int puertoServidor = 1234;
	private int puerto;
	private static ComunicacionR instance = null;

	private ComunicacionR() {
	}

	public static ComunicacionR getInstance() {
		if (instance == null)
			instance = new ComunicacionR();
		return instance;
	}

	@Override
	public void actualizarPuerto(int puerto) {
		this.puerto = puerto;
	}

	private void comienzaEscucha() {
		new Thread() {
			public void run() {
				try {
					@SuppressWarnings("resource")
					ServerSocket s = new ServerSocket(puerto);

					while (true) {

						Socket soc = s.accept();
						ObjectInputStream in = new ObjectInputStream(soc.getInputStream());
						ObjectOutputStream out = new ObjectOutputStream(soc.getOutputStream());
						
						System.out.println(s.getSoTimeout());

						Notificacion notificacion = (Notificacion) in.readObject();
						
						System.out.println(notificacion.toString());

						ComunicacionR c = ComunicacionR.getInstance();
						/*setChanged();
						c.notifyObservers(notificacion);*/

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	@Override
	public void registraEnServidor(Interruptor tipos) {
		try {
			Socket socket = new Socket("localhost", ComunicacionR.puertoServidor);
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			Registro r = RegistroFactory.getRegistro(tipos, "localhost", puerto);

			System.out.println(r.toString());

			out.writeObject(r);

			out.close();
			socket.close();

			this.comienzaEscucha();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
