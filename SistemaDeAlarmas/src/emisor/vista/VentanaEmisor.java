package emisor.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;

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
		this.frmSolicitudDeEmergencias = new JFrame();
		this.frmSolicitudDeEmergencias.setTitle("Solicitud de emergencias");
		this.frmSolicitudDeEmergencias.getContentPane().setForeground(Color.WHITE);
		this.frmSolicitudDeEmergencias.setAlwaysOnTop(true);
		this.frmSolicitudDeEmergencias.setResizable(false);
		this.frmSolicitudDeEmergencias.setBackground(Color.WHITE);
		this.frmSolicitudDeEmergencias.getContentPane().setBackground(Color.DARK_GRAY);
		this.frmSolicitudDeEmergencias.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		this.frmSolicitudDeEmergencias.setBounds(100, 100, 597, 311);
		this.frmSolicitudDeEmergencias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frmSolicitudDeEmergencias.getContentPane().setLayout(new BorderLayout(0, 0));
		
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.tabbedPane.setBackground(new Color(169, 169, 169));
		this.tabbedPane.setToolTipText("");
		this.frmSolicitudDeEmergencias.getContentPane().add(this.tabbedPane);
		
		this.panelSolicitudes = new JPanel();
		this.panelSolicitudes.setBackground(Color.DARK_GRAY);
		this.panelSolicitudes.setForeground(Color.BLACK);
		this.tabbedPane.addTab("Solicitudes", null, this.panelSolicitudes, null);
		this.panelSolicitudes.setLayout(null);
		
		this.txtIncendio = new JLabel("INCENDIO");
		this.txtIncendio.setBackground(Color.ORANGE);
		this.txtIncendio.setBounds(86, 112, 83, 24);
		this.txtIncendio.setForeground(Color.ORANGE);
		this.txtIncendio.setFont(new Font("Monospaced", Font.BOLD, 17));
		this.panelSolicitudes.add(this.txtIncendio);
		
		this.btnIncendio = new JButton("");
		this.btnIncendio.setIcon(new ImageIcon(VentanaEmisor.class.getResource("/img/incendio.png")));
		this.btnIncendio.setBounds(76, 26, 95, 76);
		this.btnIncendio.setActionCommand("Incencio");
		this.panelSolicitudes.add(this.btnIncendio);
		
		this.txtMedica = new JLabel("MEDICA");
		this.txtMedica.setBounds(233, 112, 62, 24);
		this.txtMedica.setForeground(new Color(255, 0, 0));
		this.txtMedica.setFont(new Font("Monospaced", Font.BOLD, 17));
		this.panelSolicitudes.add(this.txtMedica);
		
		this.botonEmergenciaMedica = new JButton("");
		this.botonEmergenciaMedica.setIcon(new ImageIcon(VentanaEmisor.class.getResource("/img/medica.png")));
		this.botonEmergenciaMedica.setBounds(212, 26, 95, 76);
		this.botonEmergenciaMedica.setActionCommand("Ambulancia");
		this.panelSolicitudes.add(this.botonEmergenciaMedica);
		
		this.txtSeguridad = new JLabel("SEGURIDAD");
		this.txtSeguridad.setBounds(371, 112, 94, 24);
		this.txtSeguridad.setForeground(SystemColor.textHighlight);
		this.txtSeguridad.setFont(new Font("Monospaced", Font.BOLD, 17));
		this.panelSolicitudes.add(this.txtSeguridad);
		
		this.btnSeguridad = new JButton("");
		this.btnSeguridad.setIcon(new ImageIcon(VentanaEmisor.class.getResource("/img/seguridad.png")));
		this.btnSeguridad.setBounds(361, 26, 105, 76);
		this.btnSeguridad.setActionCommand("Seguridad");
		this.panelSolicitudes.add(this.btnSeguridad);
		
		this.panelConfiguracion = new JPanel();
		this.panelConfiguracion.setBackground(Color.DARK_GRAY);
		this.tabbedPane.addTab("Configuracion", null, this.panelConfiguracion, null);
		this.panelConfiguracion.setLayout(new GridLayout(1, 1, 0, 0));
		
		this.panelDirecciones = new JPanel();
		this.panelDirecciones.setBackground(Color.DARK_GRAY);
		this.panelConfiguracion.add(this.panelDirecciones);
		this.panelDirecciones.setLayout(null);
		
		this.lblNewLabel = new JLabel("Direcciones receptoras");
		this.lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		this.lblNewLabel.setForeground(Color.WHITE);
		this.lblNewLabel.setBounds(68, 0, 124, 26);
		this.panelDirecciones.add(this.lblNewLabel);
		
		this.lblNewLabel_1 = new JLabel("IP : ");
		this.lblNewLabel_1.setForeground(Color.WHITE);
		this.lblNewLabel_1.setBounds(51, 36, 29, 13);
		this.panelDirecciones.add(this.lblNewLabel_1);
		
		this.textFieldIP = new JTextField();
		this.textFieldIP.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.textFieldIP.setForeground(Color.WHITE);
		this.textFieldIP.setBackground(Color.DARK_GRAY);
		this.textFieldIP.setBounds(108, 33, 96, 19);
		this.textFieldIP.setColumns(10);
		this.panelDirecciones.add(this.textFieldIP);
		
		this.lblNewLabel_2 = new JLabel("Puerto : ");
		this.lblNewLabel_2.setForeground(Color.WHITE);
		this.lblNewLabel_2.setBounds(40, 60, 58, 13);
		this.panelDirecciones.add(this.lblNewLabel_2);
		
		this.textFieldPuerto = new JTextField();
		this.textFieldPuerto.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.textFieldPuerto.setForeground(Color.WHITE);
		this.textFieldPuerto.setBackground(Color.DARK_GRAY);
		this.textFieldPuerto.setBounds(108, 57, 96, 19);
		this.textFieldPuerto.setColumns(10);
		this.panelDirecciones.add(this.textFieldPuerto);
		
		this.btnAgregarIp = new JButton("Agregar");
		this.btnAgregarIp.setBounds(89, 108, 83, 21);
		this.btnAgregarIp.setFocusPainted(false);
		this.btnAgregarIp.setBorderPainted(false);
		this.btnAgregarIp.setBackground(new Color(152, 251, 152));
		this.btnAgregarIp.setActionCommand("Agregar IP");
		this.panelDirecciones.add(this.btnAgregarIp);
		
		this.panelUbicacion = new JPanel();
		this.panelUbicacion.setBackground(Color.DARK_GRAY);
		this.panelUbicacion.setForeground(Color.WHITE);
		this.panelConfiguracion.add(this.panelUbicacion);
		this.panelUbicacion.setLayout(null);
		
		this.labelTextoUbicacionActual = new JLabel("Ubicacion actual: ");
		this.labelTextoUbicacionActual.setForeground(Color.WHITE);
		this.labelTextoUbicacionActual.setBounds(25, 20, 110, 13);
		this.panelUbicacion.add(this.labelTextoUbicacionActual);
		
		this.labelUbicacionActual = new JLabel("-");
		this.labelUbicacionActual.setBorder(null);
		this.labelUbicacionActual.setBackground(Color.DARK_GRAY);
		this.labelUbicacionActual.setForeground(Color.WHITE);
		this.labelUbicacionActual.setBounds(160, 20, 96, 13);
		this.panelUbicacion.add(this.labelUbicacionActual);
		
		this.labelUbicacion = new JLabel("Nueva ubicacion : ");
		this.labelUbicacion.setForeground(Color.WHITE);
		this.labelUbicacion.setBounds(25, 99, 99, 13);
		this.panelUbicacion.add(this.labelUbicacion);
		
		this.textFieldNuevaUbicacion = new JTextField();
		this.textFieldNuevaUbicacion.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.textFieldNuevaUbicacion.setForeground(Color.WHITE);
		this.textFieldNuevaUbicacion.setBackground(Color.DARK_GRAY);
		this.textFieldNuevaUbicacion.setBounds(134, 99, 96, 19);
		this.textFieldNuevaUbicacion.setColumns(10);
		this.panelUbicacion.add(this.textFieldNuevaUbicacion);
		
		this.btnUbicacion = new JButton("Guardar");
		this.btnUbicacion.setBounds(114, 136, 75, 27);
		this.btnUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		this.btnUbicacion.setFocusPainted(false);
		this.btnUbicacion.setBorderPainted(false);
		this.btnUbicacion.setBackground(new Color(152, 251, 152));
		this.btnUbicacion.setActionCommand("Cambiar Ubicacion");
		this.panelUbicacion.add(this.btnUbicacion);
		
		this.lblNewLabel_3 = new JLabel("Cambio de ubicaci\u00F3n");
		this.lblNewLabel_3.setForeground(Color.WHITE);
		this.lblNewLabel_3.setBounds(77, 56, 128, 13);
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
		JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	@Override
	public void mostrarEnvio(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.WARNING_MESSAGE);
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
