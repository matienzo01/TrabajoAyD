package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.SystemColor;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

public class VentanaEmisor {

	private JFrame frmSolicitudDeEmergencias;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEmisor window = new VentanaEmisor();
					window.frmSolicitudDeEmergencias.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaEmisor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSolicitudDeEmergencias = new JFrame();
		frmSolicitudDeEmergencias.setTitle("Solicitud de emergencias");
		frmSolicitudDeEmergencias.getContentPane().setForeground(Color.WHITE);
		frmSolicitudDeEmergencias.setAlwaysOnTop(true);
		frmSolicitudDeEmergencias.setResizable(false);
		frmSolicitudDeEmergencias.setBackground(Color.WHITE);
		frmSolicitudDeEmergencias.getContentPane().setBackground(Color.DARK_GRAY);
		frmSolicitudDeEmergencias.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmSolicitudDeEmergencias.setBounds(100, 100, 440, 180);
		frmSolicitudDeEmergencias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSolicitudDeEmergencias.getContentPane().setLayout(null);
		
		JButton botonEmergenciaMedica = new JButton("");
		botonEmergenciaMedica.setBorderPainted(false);
		botonEmergenciaMedica.setIcon(new ImageIcon(VentanaEmisor.class.getResource("/imgs/incendio.png")));
		botonEmergenciaMedica.setBounds(30, 29, 106, 80);
		frmSolicitudDeEmergencias.getContentPane().add(botonEmergenciaMedica);
		
		JButton botonEmergenciaMedica_1 = new JButton("");
		botonEmergenciaMedica_1.setBorderPainted(false);
		botonEmergenciaMedica_1.setIcon(new ImageIcon(VentanaEmisor.class.getResource("/imgs/medica.png")));
		botonEmergenciaMedica_1.setBounds(166, 29, 106, 80);
		frmSolicitudDeEmergencias.getContentPane().add(botonEmergenciaMedica_1);
		
		JButton botonEmergenciaMedica_2 = new JButton("");
		botonEmergenciaMedica_2.setBorderPainted(false);
		botonEmergenciaMedica_2.setIcon(new ImageIcon(VentanaEmisor.class.getResource("/imgs/seguridad.png")));
		botonEmergenciaMedica_2.setBounds(300, 29, 106, 80);
		frmSolicitudDeEmergencias.getContentPane().add(botonEmergenciaMedica_2);
	}
}
