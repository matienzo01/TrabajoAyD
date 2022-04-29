package emisor.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import emisor.modelo.Emisor;
import emisor.vista.IVistaEmisor;

public class Controlador implements ActionListener {
	private IVistaEmisor vista;
	private Emisor emisor = Emisor.getInstance();

	public Controlador(IVistaEmisor vista) {
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
		}else if(e.getActionCommand().equalsIgnoreCase("Incencio"))
			emisor.enviarNotificacion("incendio");
		else if(e.getActionCommand().equalsIgnoreCase("Ambulancia"))
			System.out.println("Ambulancia");
		else if(e.getActionCommand().equalsIgnoreCase("Seguridad"))
			System.out.println("Seguridad");
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
