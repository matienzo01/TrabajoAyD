package emisor.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import emisor.modelo.Emisor;
import emisor.vista.IVistaEmisor;

public class ControladorEmisor implements ActionListener {
	private IVistaEmisor vista;
	private Emisor emisor = Emisor.getInstance();

	public ControladorEmisor(IVistaEmisor vista) {
		this.vista = vista;
		this.vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Agregar IP")) {
			String IP = this.vista.getNuevaIp();
			int puerto;
			try {
				puerto = Integer.parseInt( this.vista.getNuevaPuerto());
				System.out.println("Agregar IP " + IP +" " + puerto);
				emisor.agregarDestinatario(IP, puerto);
				this.vista.limpiaCamposIP();
			}catch(NumberFormatException err) {
				this.vista.mostrarError("El puerto y la IP deben ser numeros enteros");
			}
		}else if(e.getActionCommand().equalsIgnoreCase("Incencio")) {
			emisor.enviarNotificacion("incendio");
			vista.mostrarEnvio("Se envió la notificación de incendio.");
		}
		else if(e.getActionCommand().equalsIgnoreCase("Ambulancia")) {
			emisor.enviarNotificacion("Ambulancia");
			vista.mostrarEnvio("Se envió la notificación de asistencia medica.");
		}
		else if(e.getActionCommand().equalsIgnoreCase("Seguridad")) {
			emisor.enviarNotificacion("Seguridad");
			vista.mostrarEnvio("Se envió la notificación de seguridad.");
		}
		else if(e.getActionCommand().equalsIgnoreCase("Cambiar Ubicacion")) {
			String nuevaUbicacion = this.vista.getUbicacion();
			if(nuevaUbicacion == null || nuevaUbicacion.isBlank())
				this.vista.mostrarError("Ingrese una nueva ubicacion valida");
			else {
				this.emisor.cambiarUbicacion(nuevaUbicacion);
				this.vista.mostrarNuevaUbicacion(nuevaUbicacion);
				this.vista.limpiaCampoNuevaUbicacion();
			}
		}
	}
}
