package receptor.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import emisor.modelo.Notificacion;
import receptor.modelo.ComunicacionR;
import receptor.modelo.Receptor;
import receptor.vista.IVistaReceptor;

@SuppressWarnings("deprecation")
public class ControladorReceptor implements ActionListener, Observer {
	private IVistaReceptor vista;
	private Receptor receptor;
	private ComunicacionR observado;

	
	public ControladorReceptor(IVistaReceptor vista) {
		this.vista = vista;
		this.vista.setActionListener(this);
		this.receptor = Receptor.getInstance();
		this.observado = Receptor.getC();
		Receptor.getC().addObserver(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("actualizar puerto")) {
			try {
				String puertoString = this.vista.getNuevoPuerto();
				int puerto = Integer.parseInt(puertoString);
				this.receptor.actualizarPuerto(puerto);
				this.vista.limpiaCampoPuerto();
				this.vista.muestraPuerto(puertoString);
				this.receptor.comienzaEscucha();
			} catch (NumberFormatException err) {
				this.vista.mostrarError("El puerto debe ser un numero entero");
			}
		} else if (e.getActionCommand().equalsIgnoreCase("incendio")) {
			receptor.toggleIncendio();
			this.vista.toggleIncendio(receptor.isIncendios());
		} else if (e.getActionCommand().equalsIgnoreCase("seguridad")) {
			receptor.toggleSeguridad();
			this.vista.toggleSeguridad(receptor.isSeguridad());
		} else if (e.getActionCommand().equalsIgnoreCase("medico")) {
			receptor.toggleAmbulancia();
			this.vista.toggleAmbulancia(receptor.isAmbulancia());
		}else if (e.getActionCommand().equalsIgnoreCase("confirmar")) {
			Notificacion selected = this.vista.getSelectedValue();
			System.out.println(selected);
		}
	}

	@Override
	public void update(Observable o, Object nuevaNotificacion) {
		ComunicacionR c = (ComunicacionR) o;
		Notificacion mensaje = (Notificacion) nuevaNotificacion;
		this.vista.agregarNotificacion(mensaje);
	}
}