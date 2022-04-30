package receptor.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import emisor.modelo.Emisor;
import emisor.vista.IVistaEmisor;
import receptor.modelo.ComunicacionR;
import receptor.modelo.Receptor;
import receptor.vista.IVistaReceptor;

public class ControladorReceptor implements ActionListener, Observer {
	private IVistaReceptor vista;
	private Receptor receptor;
	private ComunicacionR observado;

	@SuppressWarnings("deprecation")
	public ControladorReceptor(IVistaReceptor vista) {
		this.vista = vista;
		this.vista.setActionListener(this);
		this.receptor = Receptor.getInstance();
		this.observado = Receptor.getC();
		Receptor.getC().addObserver(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Llegue al controlador");
		if (e.getActionCommand().equalsIgnoreCase("actualizar puerto")) {
			try {
				String puertoString = this.vista.getNuevoPuerto();
				int puerto = Integer.parseInt(puertoString);
				receptor.actualizarPuerto(puerto);
				this.vista.limpiaCampoPuerto();
				this.vista.muestraPuerto(puertoString);
				receptor.comienzaEscucha();
			} catch (NumberFormatException err) {
				this.vista.mostrarError("El puerto debe ser un numero entero");
			}
		} else if (e.getActionCommand().equalsIgnoreCase("incendio")) {
			receptor.toggleIncendio();
		} else if (e.getActionCommand().equalsIgnoreCase("seguridad")) {
			receptor.toggleSeguridad();
		} else if (e.getActionCommand().equalsIgnoreCase("medico")) {
			receptor.toggleAmbulancia();
		}
	}

	@Override
	public void update(Observable o, Object nuevaNotificacion) {
		ComunicacionR c = (ComunicacionR) o;
		String mensaje = (String) nuevaNotificacion;
		//if(this.observado==c)ç
			this.vista.agregarNotificacion(mensaje);
		
		System.out.println("llega a update del controlador.....");
	}
}