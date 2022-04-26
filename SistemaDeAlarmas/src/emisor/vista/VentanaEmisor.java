package emisor.vista;

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
import javax.swing.JRadioButtonMenuItem;
import java.awt.Font;

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
		frmSolicitudDeEmergencias.setBounds(100, 100, 440, 230);
		frmSolicitudDeEmergencias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSolicitudDeEmergencias.getContentPane().setLayout(null);
		
		JButton btnIncendio = new JButton("");
		btnIncendio.setBorderPainted(false);
		btnIncendio.setIcon(new ImageIcon(VentanaEmisor.class.getResource("/img/incendio.png")));
		btnIncendio.setBounds(30, 29, 106, 80);
		frmSolicitudDeEmergencias.getContentPane().add(btnIncendio);
		
		JButton botonEmergenciaMedica_1 = new JButton("");
		botonEmergenciaMedica_1.setBorderPainted(false);
		botonEmergenciaMedica_1.setIcon(new ImageIcon(VentanaEmisor.class.getResource("/img/medica.png")));
		botonEmergenciaMedica_1.setBounds(166, 29, 106, 80);
		frmSolicitudDeEmergencias.getContentPane().add(botonEmergenciaMedica_1);
		
		JButton btnSeguridad = new JButton("");
		btnSeguridad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSeguridad.setBorderPainted(false);
		btnSeguridad.setIcon(new ImageIcon(VentanaEmisor.class.getResource("/img/seguridad.png")));
		btnSeguridad.setBounds(300, 29, 106, 80);
		frmSolicitudDeEmergencias.getContentPane().add(btnSeguridad);
		
		JLabel txtIncendio = new JLabel("INCENDIO");
		txtIncendio.setForeground(Color.ORANGE);
		txtIncendio.setFont(new Font("Monospaced", Font.BOLD, 17));
		txtIncendio.setBounds(40, 110, 87, 14);
		frmSolicitudDeEmergencias.getContentPane().add(txtIncendio);
		
		JLabel txtMedica = new JLabel("MEDICA");
		txtMedica.setForeground(new Color(220, 20, 60));
		txtMedica.setFont(new Font("Monospaced", Font.BOLD, 17));
		txtMedica.setBounds(186, 110, 78, 14);
		frmSolicitudDeEmergencias.getContentPane().add(txtMedica);
		
		JLabel txtSeguridad = new JLabel("SEGURIDAD");
		txtSeguridad.setForeground(SystemColor.textHighlight);
		txtSeguridad.setFont(new Font("Monospaced", Font.BOLD, 17));
		txtSeguridad.setBounds(310, 110, 96, 14);
		frmSolicitudDeEmergencias.getContentPane().add(txtSeguridad);
	}
}
