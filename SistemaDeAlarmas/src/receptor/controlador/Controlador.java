package receptor.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import emisor.modelo.Emisor;
import emisor.vista.IVistaEmisor;
import receptor.modelo.Receptor;
import receptor.vista.IVistaReceptor;

public class Controlador implements ActionListener {
	private IVistaReceptor vista;
	private Receptor receptor = Receptor.getInstance();
	
	
	public Controlador(IVistaReceptor vista){
		this.vista=vista;
		this.vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
/*		if (e.getActionCommand().equalsIgnoreCase("actualizar puerto")) {
			try {
				int puerto = Integer.parseInt( this.vista.getNuevaPuerto());
				receptor.actualizarPuerto(puerto);
				this.vista.limpiaCampoPuerto();
			}catch(NumberFormatException err) {
				this.vista.mostrarError("El puerto debe ser un numero entero");
			}
		}else if(e.getActionCommand().equalsIgnoreCase("checkIncendios"))
			
		else if(e.getActionCommand().equalsIgnoreCase("checkAmbulancia"))
			System.out.println("Ambulancia");
		else if(e.getActionCommand().equalsIgnoreCase("checkSeguridad"))
			System.out.println("Seguridad");
		}

 * */
		
		
	}


}