package receptor.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaConfiguracionR {

	private JFrame frmConfiguracion;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConfiguracionR window = new VentanaConfiguracionR();
					window.frmConfiguracion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaConfiguracionR() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConfiguracion = new JFrame();
		frmConfiguracion.getContentPane().setBackground(new Color(128, 128, 128));
		frmConfiguracion.setTitle("Configuracion");
		frmConfiguracion.setBounds(100, 100, 370, 220);
		frmConfiguracion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConfiguracion.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione el o los tipos de notificacion que desea recibir");
		lblNewLabel.setBounds(10, 11, 414, 14);
		frmConfiguracion.getContentPane().add(lblNewLabel);
		
		JCheckBox checkBoxIncendios = new JCheckBox("Focos de incendio");
		checkBoxIncendios.setBackground(new Color(128, 128, 128));
		checkBoxIncendios.setFocusPainted(false);
		checkBoxIncendios.setBounds(10, 33, 127, 23);
		frmConfiguracion.getContentPane().add(checkBoxIncendios);
		
		JCheckBox checkBoxMedica = new JCheckBox("Emergencias medicas");
		checkBoxMedica.setFocusPainted(false);
		checkBoxMedica.setBackground(Color.GRAY);
		checkBoxMedica.setBounds(10, 59, 152, 23);
		frmConfiguracion.getContentPane().add(checkBoxMedica);
		
		JCheckBox chckbxPersonalDeSeguridad = new JCheckBox("Personal de seguridad");
		chckbxPersonalDeSeguridad.setFocusPainted(false);
		chckbxPersonalDeSeguridad.setBackground(Color.GRAY);
		chckbxPersonalDeSeguridad.setBounds(10, 85, 184, 23);
		frmConfiguracion.getContentPane().add(chckbxPersonalDeSeguridad);
		
		JLabel lblNewLabel_1 = new JLabel("Configuracion de puerto: ");
		lblNewLabel_1.setBounds(10, 121, 184, 14);
		frmConfiguracion.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Puerto : ");
		lblNewLabel_2.setBounds(20, 146, 64, 14);
		frmConfiguracion.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(94, 143, 100, 20);
		frmConfiguracion.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(152, 251, 152));
		btnNewButton.setBounds(202, 142, 89, 23);
		frmConfiguracion.getContentPane().add(btnNewButton);
	}
}
