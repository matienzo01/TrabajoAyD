package emisor.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import emisor.vista.IVista;

public class Controlador implements ActionListener{
	private IVista vista;
	
	public Controlador(IVista vista) {
		this.vista = vista;
		this.vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Abrir configuracion")) System.out.println("Anda");
		
	}
}
