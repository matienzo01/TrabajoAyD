package emisor.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import emisor.modelo.Emisor;
import emisor.modelo.IEmisor;
import emisor.vista.IVistaEmisor;

public class ControladorEmisor implements ActionListener {
	private IVistaEmisor vista;
	private IEmisor emisor = Emisor.getInstance();

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
		}else if(e.getActionCommand().equalsIgnoreCase("Incencio")) {
			emisor.enviarNotificacion("incendio");
			envioExitoso();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Ambulancia")) {
			emisor.enviarNotificacion("Ambulancia");
			envioExitoso();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Seguridad")) {
			emisor.enviarNotificacion("Seguridad");
			envioExitoso();
		}

	}
	
	private void envioExitoso() {
		if(Emisor.getInstance().getUbicacion()!=null)
			vista.mostrarEnvio("Se notificó de la emergencia exitosamente.");
		else
			vista.mostrarError("Debe especificar la ubicacion antes de solicitar ayuda.");
	}
	
}
