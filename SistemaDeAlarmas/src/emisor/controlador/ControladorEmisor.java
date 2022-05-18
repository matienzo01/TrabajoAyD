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
		if(e.getActionCommand().equalsIgnoreCase("Cambiar Ubicacion")) {
			String nuevaUbicacion = this.vista.getUbicacion();
			if(nuevaUbicacion == null || nuevaUbicacion.isBlank())
				this.vista.mostrarError("Ingrese una nueva ubicacion valida");
			else {
				this.emisor.cambiarUbicacion(nuevaUbicacion);
				this.vista.mostrarNuevaUbicacion(nuevaUbicacion);
				this.vista.limpiaCampoNuevaUbicacion();
			}
		}else if(e.getActionCommand().equalsIgnoreCase("Incencio")) {
			
			this.envioExitoso(emisor.enviarNotificacion("incendio"));
		}
		else if(e.getActionCommand().equalsIgnoreCase("Ambulancia")) {
			
			this.envioExitoso(emisor.enviarNotificacion("Ambulancia"));
		}
		else if(e.getActionCommand().equalsIgnoreCase("Seguridad")) {
			
			this.envioExitoso(emisor.enviarNotificacion("Seguridad"));
		}

	}

	private void envioExitoso(String resultado) {
		vista.mostrarEnvio(resultado);
	}

}
