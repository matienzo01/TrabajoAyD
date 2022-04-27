package emisor.vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaConfiguracion {

	private JFrame frameConfiguracion;
	private JTextField textFieldUbicacion;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConfiguracion window = new VentanaConfiguracion();
					window.frameConfiguracion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaConfiguracion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameConfiguracion = new JFrame();
		frameConfiguracion.setTitle("Configuracion");
		frameConfiguracion.setAlwaysOnTop(true);
		frameConfiguracion.setBounds(100, 100, 340, 460);
		frameConfiguracion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameConfiguracion.getContentPane().setLayout(null);
		
		JPanel panelUbicacion = new JPanel();
		panelUbicacion.setBounds(10, 11, 304, 97);
		frameConfiguracion.getContentPane().add(panelUbicacion);
		panelUbicacion.setLayout(null);
		
		JLabel labelUbicacion = new JLabel("Nueva ubicacion : ");
		labelUbicacion.setBounds(0, 67, 117, 14);
		panelUbicacion.add(labelUbicacion);
		
		textFieldUbicacion = new JTextField();
		textFieldUbicacion.setBounds(108, 63, 122, 23);
		panelUbicacion.add(textFieldUbicacion);
		textFieldUbicacion.setColumns(10);
		
		JButton btnUbicacion = new JButton("Guardar");
		btnUbicacion.setFocusPainted(false);
		btnUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnUbicacion.setBorderPainted(false);
		btnUbicacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUbicacion.setBackground(new Color(152, 251, 152));
		btnUbicacion.setBounds(232, 63, 72, 23);
		panelUbicacion.add(btnUbicacion);
		
		JLabel labelTextoUbicacionActual = new JLabel("Ubicacion actual: ");
		labelTextoUbicacionActual.setBounds(0, 11, 117, 14);
		panelUbicacion.add(labelTextoUbicacionActual);
		
		JLabel labelUbicacionActual = new JLabel("-");
		labelUbicacionActual.setBounds(137, 11, 46, 14);
		panelUbicacion.add(labelUbicacionActual);
		
		JLabel lblNewLabel = new JLabel("Cambio de ubicaci\u00F3n");
		lblNewLabel.setBounds(97, 42, 150, 14);
		panelUbicacion.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 119, 304, 291);
		frameConfiguracion.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 304, 80);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Direcciones receptoras");
		lblNewLabel_1.setBounds(97, 0, 185, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("IP : ");
		lblNewLabel_2.setBounds(0, 28, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(32, 25, 107, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Puerto : ");
		lblNewLabel_3.setBounds(149, 28, 59, 14);
		panel_1.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(218, 25, 86, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setBackground(new Color(152, 251, 152));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(98, 57, 89, 23);
		panel_1.add(btnNewButton);
	}

}
