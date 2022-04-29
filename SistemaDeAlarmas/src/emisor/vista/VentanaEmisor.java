package emisor.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class VentanaEmisor extends JFrame implements IVistaEmisor{

	private JFrame frmSolicitudDeEmergencias;
	private JTabbedPane tabbedPane;
	private JPanel panelSolicitudes;
	private JLabel txtIncendio;
	private JButton btnIncendio;
	private JLabel txtMedica;
	private JButton botonEmergenciaMedica;
	private JLabel txtSeguridad;
	private JButton btnSeguridad;
	private JPanel panelConfiguracion;
	private JPanel panelDirecciones;
	private JPanel panelUbicacion;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textFieldIP;
	private JLabel lblNewLabel_2;
	private JTextField textFieldPuerto;
	private JButton btnAgregarIp;
	private JLabel labelUbicacion;
	private JTextField textFieldNuevaUbicacion;
	private JButton btnUbicacion;
	private JLabel labelTextoUbicacionActual;
	private JLabel labelUbicacionActual;
	private JLabel lblNewLabel_3;

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
		frmSolicitudDeEmergencias.setBounds(100, 100, 597, 311);
		frmSolicitudDeEmergencias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frmSolicitudDeEmergencias.getContentPane().setLayout(new BorderLayout(0, 0));
		
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.tabbedPane.setToolTipText("");
		this.frmSolicitudDeEmergencias.getContentPane().add(this.tabbedPane);
		
		this.panelSolicitudes = new JPanel();
		this.panelSolicitudes.setForeground(Color.BLACK);
		this.tabbedPane.addTab("Solicitudes", null, this.panelSolicitudes, null);
		this.panelSolicitudes.setLayout(null);
		
		this.txtIncendio = new JLabel("INCENDIO");
		this.txtIncendio.setBounds(43, 98, 83, 24);
		this.txtIncendio.setForeground(Color.GRAY);
		this.txtIncendio.setFont(new Font("Monospaced", Font.BOLD, 17));
		this.panelSolicitudes.add(this.txtIncendio);
		
		this.btnIncendio = new JButton("");
		this.btnIncendio.setIcon(new ImageIcon(VentanaEmisor.class.getResource("/img/incendio.png")));
		this.btnIncendio.setBounds(31, 12, 95, 76);
		this.btnIncendio.setBorderPainted(false);
		this.btnIncendio.setActionCommand("Incencio");
		this.panelSolicitudes.add(this.btnIncendio);
		
		this.txtMedica = new JLabel("MEDICA");
		this.txtMedica.setBounds(184, 98, 62, 24);
		this.txtMedica.setForeground(Color.GRAY);
		this.txtMedica.setFont(new Font("Monospaced", Font.BOLD, 17));
		this.panelSolicitudes.add(this.txtMedica);
		
		this.botonEmergenciaMedica = new JButton("");
		this.botonEmergenciaMedica.setIcon(new ImageIcon(VentanaEmisor.class.getResource("/img/medica.png")));
		this.botonEmergenciaMedica.setBounds(167, 12, 95, 76);
		this.botonEmergenciaMedica.setBorderPainted(false);
		this.botonEmergenciaMedica.setActionCommand("Ambulancia");
		this.panelSolicitudes.add(this.botonEmergenciaMedica);
		
		this.txtSeguridad = new JLabel("SEGURIDAD");
		this.txtSeguridad.setBounds(316, 98, 94, 24);
		this.txtSeguridad.setForeground(Color.GRAY);
		this.txtSeguridad.setFont(new Font("Monospaced", Font.BOLD, 17));
		this.panelSolicitudes.add(this.txtSeguridad);
		
		this.btnSeguridad = new JButton("");
		this.btnSeguridad.setIcon(new ImageIcon(VentanaEmisor.class.getResource("/img/seguridad.png")));
		this.btnSeguridad.setBounds(316, 12, 105, 76);
		this.btnSeguridad.setBorderPainted(false);
		this.btnSeguridad.setActionCommand("Seguridad");
		this.panelSolicitudes.add(this.btnSeguridad);
		
		this.panelConfiguracion = new JPanel();
		this.tabbedPane.addTab("Configuracion", null, this.panelConfiguracion, null);
		this.panelConfiguracion.setLayout(new GridLayout(1, 1, 0, 0));
		
		this.panelDirecciones = new JPanel();
		this.panelConfiguracion.add(this.panelDirecciones);
		this.panelDirecciones.setLayout(null);
		
		this.lblNewLabel = new JLabel("Direcciones receptoras");
		this.lblNewLabel.setBounds(9, 8, 104, 13);
		this.panelDirecciones.add(this.lblNewLabel);
		
		this.lblNewLabel_1 = new JLabel("IP : ");
		this.lblNewLabel_1.setBounds(118, 8, 19, 13);
		this.panelDirecciones.add(this.lblNewLabel_1);
		
		this.textFieldIP = new JTextField();
		this.textFieldIP.setBounds(142, 5, 96, 19);
		this.textFieldIP.setColumns(10);
		this.panelDirecciones.add(this.textFieldIP);
		
		this.lblNewLabel_2 = new JLabel("Puerto : ");
		this.lblNewLabel_2.setBounds(58, 60, 40, 13);
		this.panelDirecciones.add(this.lblNewLabel_2);
		
		this.textFieldPuerto = new JTextField();
		this.textFieldPuerto.setBounds(108, 57, 96, 19);
		this.textFieldPuerto.setColumns(10);
		this.panelDirecciones.add(this.textFieldPuerto);
		
		this.btnAgregarIp = new JButton("Agregar");
		this.btnAgregarIp.setBounds(89, 108, 69, 21);
		this.btnAgregarIp.setFocusPainted(false);
		this.btnAgregarIp.setBorderPainted(false);
		this.btnAgregarIp.setBackground(new Color(152, 251, 152));
		this.btnAgregarIp.setActionCommand("Agregar IP");
		this.panelDirecciones.add(this.btnAgregarIp);
		
		this.panelUbicacion = new JPanel();
		this.panelConfiguracion.add(this.panelUbicacion);
		this.panelUbicacion.setLayout(null);
		
		this.labelTextoUbicacionActual = new JLabel("Ubicacion actual: ");
		this.labelTextoUbicacionActual.setBounds(25, 20, 81, 13);
		this.panelUbicacion.add(this.labelTextoUbicacionActual);
		
		this.labelUbicacionActual = new JLabel("-");
		this.labelUbicacionActual.setBounds(134, 21, 96, 13);
		this.panelUbicacion.add(this.labelUbicacionActual);
		
		this.labelUbicacion = new JLabel("Nueva ubicacion : ");
		this.labelUbicacion.setBounds(25, 99, 84, 13);
		this.panelUbicacion.add(this.labelUbicacion);
		
		this.textFieldNuevaUbicacion = new JTextField();
		this.textFieldNuevaUbicacion.setBounds(134, 99, 96, 19);
		this.textFieldNuevaUbicacion.setColumns(10);
		this.panelUbicacion.add(this.textFieldNuevaUbicacion);
		
		this.btnUbicacion = new JButton("Guardar");
		this.btnUbicacion.setBounds(102, 133, 69, 21);
		this.btnUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		this.btnUbicacion.setFocusPainted(false);
		this.btnUbicacion.setBorderPainted(false);
		this.btnUbicacion.setBackground(new Color(152, 251, 152));
		this.btnUbicacion.setActionCommand("Cambiar Ubicacion");
		this.panelUbicacion.add(this.btnUbicacion);
		
		this.lblNewLabel_3 = new JLabel("Cambio de ubicaci\u00F3n");
		this.lblNewLabel_3.setBounds(77, 56, 94, 13);
		this.panelUbicacion.add(this.lblNewLabel_3);
		this.frmSolicitudDeEmergencias.setVisible(true);
		
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnIncendio.addActionListener(actionListener);
		this.botonEmergenciaMedica.addActionListener(actionListener);
		this.btnSeguridad.addActionListener(actionListener);
		this.btnAgregarIp.addActionListener(actionListener);
		this.btnUbicacion.addActionListener(actionListener);
	}

	@Override
	public String getUbicacion() {
		return this.textFieldNuevaUbicacion.getText();
	}

	@Override
	public String getNuevaIp() {
		return this.textFieldIP.getText();
	}

	@Override
	public String getNuevaPuerto() {
		return this.textFieldPuerto.getText();
	}

	@Override
	public void mostrarNuevaUbicacion(String ubicacion) {
		this.labelUbicacionActual.setText(ubicacion);
		
	}

	@Override
	public void mostrarError(String error) {
		JOptionPane.showMessageDialog(this, error, "error", 1);
	}

	@Override
	public void limpiaCamposIP() {
		this.textFieldIP.setText("");
		this.textFieldPuerto.setText("");
		
	}

	@Override
	public void limpiaCampoNuevaUbicacion() {
		this.textFieldNuevaUbicacion.setText("");
	}
	
	
}
