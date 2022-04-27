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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JDesktopPane;

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
		
		JLabel txtIncendio = new JLabel("INCENDIO");
		txtIncendio.setForeground(Color.GRAY);
		txtIncendio.setFont(new Font("Monospaced", Font.BOLD, 17));
		txtIncendio.setBounds(40, 110, 87, 14);
		frmSolicitudDeEmergencias.getContentPane().add(txtIncendio);

		JButton btnIncendio = new JButton("");
		btnIncendio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtIncendio.setForeground(Color.ORANGE);
			}
		});
		btnIncendio.setBorderPainted(false);
		btnIncendio.setIcon(new ImageIcon(VentanaEmisor.class.getResource("/img/incendio.png")));
		btnIncendio.setBounds(30, 29, 106, 80);
		frmSolicitudDeEmergencias.getContentPane().add(btnIncendio);

		JLabel txtMedica = new JLabel("MEDICA");
		txtMedica.setForeground(Color.GRAY);
		txtMedica.setFont(new Font("Monospaced", Font.BOLD, 17));
		txtMedica.setBounds(186, 110, 78, 14);
		frmSolicitudDeEmergencias.getContentPane().add(txtMedica);

		JButton botonEmergenciaMedica = new JButton("");
		botonEmergenciaMedica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMedica.setForeground(new Color(220, 20, 60));
			}
		});
		botonEmergenciaMedica.setBorderPainted(false);
		botonEmergenciaMedica.setIcon(new ImageIcon(VentanaEmisor.class.getResource("/img/medica.png")));
		botonEmergenciaMedica.setBounds(166, 29, 106, 80);
		frmSolicitudDeEmergencias.getContentPane().add(botonEmergenciaMedica);

		JLabel txtSeguridad = new JLabel("SEGURIDAD");
		txtSeguridad.setForeground(Color.GRAY);
		txtSeguridad.setFont(new Font("Monospaced", Font.BOLD, 17));
		txtSeguridad.setBounds(310, 110, 96, 14);
		frmSolicitudDeEmergencias.getContentPane().add(txtSeguridad);

		JButton btnSeguridad = new JButton("");
		btnSeguridad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSeguridad.setForeground(SystemColor.textHighlight);
			}
		});
		btnSeguridad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnSeguridad.setBorderPainted(false);
		btnSeguridad.setIcon(new ImageIcon(VentanaEmisor.class.getResource("/img/seguridad.png")));
		btnSeguridad.setBounds(300, 29, 106, 80);
		frmSolicitudDeEmergencias.getContentPane().add(btnSeguridad);

		JButton btnConfiguracion = new JButton("Configuracion");
		btnConfiguracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfiguracion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//abrir ventanaConfiguracion
			}
		});
		btnConfiguracion.setBounds(10, 163, 126, 27);
		frmSolicitudDeEmergencias.getContentPane().add(btnConfiguracion);
		
		
	}

}
