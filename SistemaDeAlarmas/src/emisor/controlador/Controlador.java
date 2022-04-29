package emisor.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import emisor.vista.IVistaEmisor;

public class Controlador implements ActionListener {
	private IVistaEmisor vista;

	public Controlador(IVistaEmisor vista) {
		this.vista = vista;
		this.vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Agregar IP")) {
			System.out.println("Agregar IP");
		}else if(e.getActionCommand().equalsIgnoreCase("Incencio"))
			System.out.println("Incencio");
		else if(e.getActionCommand().equalsIgnoreCase("Ambulancia"))
			System.out.println("Ambulancia");
		else if(e.getActionCommand().equalsIgnoreCase("Seguridad"))
			System.out.println("Seguridad");
		else if(e.getActionCommand().equalsIgnoreCase("Cambiar Ubicacion"))
			System.out.println("Cambiar Ubicacion");
	}
}
