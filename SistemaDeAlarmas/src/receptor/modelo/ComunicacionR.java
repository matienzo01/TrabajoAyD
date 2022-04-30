package receptor.modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ComunicacionR {

	private String host;
	private int puerto;

	public ComunicacionR() {
		this.host = "localhost";
	}

	public void actualizarPuerto(int puerto) {
		this.puerto = puerto;
	}

	public void comienzaEscucha() {
		new Thread() {
			public void run() {
				try {
					ServerSocket s = new ServerSocket(puerto);

					while (true) {

						Socket soc = s.accept();
						PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
						BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

						String msg = in.readLine();
						// jTextArea1.append(msg + "\n");
						System.out.println("LLEGO LA EMERGENCIA");
						System.out.println(in.readLine());
					}

				} catch (Exception e) {
					e.printStackTrace();
					// jTextArea1.append(e.getMessage() + "\n");
				}
				System.out.println("fin");
			}
		}.start();
	}

}
