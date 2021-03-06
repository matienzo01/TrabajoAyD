package receptor.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import notificacion.Notificacion;
import receptor.modelo.IComunicacionR;
import receptor.modelo.IReceptor;
import receptor.modelo.Receptor;
import receptor.vista.IVistaReceptor;

@SuppressWarnings("deprecation")
public class ControladorReceptor implements ActionListener, Observer {
	private IVistaReceptor vista;
	private IReceptor receptor;

	public ControladorReceptor(IVistaReceptor vista) {
		this.vista = vista;
		this.vista.setActionListener(this);
		this.receptor = Receptor.getInstance();
		Receptor.getC().addObserver(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("registro")) {
			try {
				String puertoString = this.vista.getNuevoPuerto();
				int puerto = Integer.parseInt(puertoString);
				this.receptor.actualizarPuerto(puerto);
				this.vista.limpiaCampoPuerto();
				this.vista.muestraPuerto(puertoString);
				this.vista.puertoDefinido();
				this.vista.cambioDePantalla(this.receptor.isIncendios(),this.receptor.isAmbulancia(),this.receptor.isSeguridad());
				this.receptor.registraEnServidor();
			} catch (NumberFormatException err) {
				this.vista.mostrarError("El puerto debe ser un numero entero");
			}
		} else if (e.getActionCommand().equalsIgnoreCase("incendio")) {
			receptor.toggleIncendio();
		} else if (e.getActionCommand().equalsIgnoreCase("seguridad")) {
			receptor.toggleSeguridad();
		} else if (e.getActionCommand().equalsIgnoreCase("medico")) {
			receptor.toggleAmbulancia();
		} else if (e.getActionCommand().equalsIgnoreCase("confirmar")) {
			Notificacion n = this.vista.getSelectedNotification();
			this.vista.eliminaNotificacion(n);
			this.vista.agregaConfirmada(n);
		}
	}

	@Override
	public void update(Observable o, Object nuevaNotificacion) {
		IComunicacionR c = (IComunicacionR) o;
		Notificacion mensaje = (Notificacion) nuevaNotificacion;
		if (mensaje.mostrarse(receptor.getInterruptorTipos()))
			this.vista.agregarNotificacion(mensaje);
	}
}