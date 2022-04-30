package receptor.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import emisor.modelo.Emisor;
import emisor.vista.IVistaEmisor;
import receptor.modelo.Receptor;
import receptor.vista.IVistaReceptor;

public class ControladorReceptor implements ActionListener {
	private IVistaReceptor vista;
	private Receptor receptor = Receptor.getInstance();
	
	
	public ControladorReceptor(IVistaReceptor vista){
		this.vista=vista;
		this.vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Llegue al controlador");
		if (e.getActionCommand().equalsIgnoreCase("actualizar puerto")) {
			try {
				String puertoString = this.vista.getNuevoPuerto();
				int puerto = Integer.parseInt(puertoString );
				receptor.actualizarPuerto(puerto);
				this.vista.limpiaCampoPuerto();
				this.vista.muestraPuerto(puertoString);
				receptor.comienzaEscucha();
			}catch(NumberFormatException err) {
				this.vista.mostrarError("El puerto debe ser un numero entero");
			}		
		}else if(e.getActionCommand().equalsIgnoreCase("incendio")) {
			receptor.toggleIncendio();
		}else if(e.getActionCommand().equalsIgnoreCase("seguridad")) {
			receptor.toggleSeguridad();
		}else if(e.getActionCommand().equalsIgnoreCase("medico")) {
			receptor.toggleAmbulancia();
		}
	}
}