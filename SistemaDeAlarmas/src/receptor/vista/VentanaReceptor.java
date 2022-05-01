package receptor.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import emisor.modelo.Notificacion;

public class VentanaReceptor extends JFrame implements IVistaReceptor{

	private JFrame frmRecepcinDeEmergencias;
	private JTextField textFieldNuevoPuerto;
	private JButton botonConfirmar;
	private JLabel labelTitulo;
	private JTabbedPane panelConfiguracion;
	private JPanel panelTipos;
	private JLabel titlePanelTipos;
	private JCheckBox checkIncendio;
	private JCheckBox checkMedica;
	private JCheckBox checkSeguridad;
	private JPanel panelPuerto;
	private JLabel txtPuerto;
	private JLabel txtNumeroPuerto;
	private JLabel txtActualizarPuerto;
	private JButton btnActualizarPuerto;
	private JTabbedPane tabbedPaneAlertas;
	private JPanel panelIncendios;
	private JPanel panelSeguridad;
	private JPanel panelAmbulancia;
	private JList<Notificacion> listIncendios;
	private JList<Notificacion> listSeguridad;
	private JList<Notificacion> listAmbulancia;
	private DefaultListModel<Notificacion> displayIncendio = new DefaultListModel<Notificacion>();
	private DefaultListModel<Notificacion> displaySeguridad = new DefaultListModel<Notificacion>();
	private DefaultListModel<Notificacion> displayAmbulancia = new DefaultListModel<Notificacion>();

	/**
	 * Create the application.
	 */
	public VentanaReceptor() {
		this.frmRecepcinDeEmergencias = new JFrame();
		this.frmRecepcinDeEmergencias.setForeground(Color.BLACK);
		this.frmRecepcinDeEmergencias.setTitle("Emergencias");
		this.frmRecepcinDeEmergencias.getContentPane().setBackground(Color.DARK_GRAY);
		
		this.botonConfirmar = new JButton("Confirmar");
		this.botonConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.botonConfirmar.setBounds(77, 263, 96, 23);
		this.botonConfirmar.setBackground(new Color(144, 238, 144));
		this.botonConfirmar.setActionCommand("confirmar");
		
		this.frmRecepcinDeEmergencias.getContentPane().setLayout(null);
		this.frmRecepcinDeEmergencias.getContentPane().add(botonConfirmar);
		
		
		this.labelTitulo = new JLabel("Ultimas notificaciones : ");
		this.labelTitulo.setForeground(new Color(240, 255, 255));
		this.labelTitulo.setBounds(10, 10, 145, 14);
		this.frmRecepcinDeEmergencias.getContentPane().add(labelTitulo);
		
		this.panelConfiguracion = new JTabbedPane(JTabbedPane.TOP);
		this.panelConfiguracion.setBounds(10, 289, 232, 131);
		this.frmRecepcinDeEmergencias.getContentPane().add(panelConfiguracion);
		
		this.panelTipos = new JPanel();
		this.panelConfiguracion.addTab("Tipos", null, panelTipos, null);
		this.panelTipos.setLayout(null);
		
		this.titlePanelTipos = new JLabel("Seleccione tipos de notificacion");
		this.titlePanelTipos.setBounds(0, 0, 227, 14);
		this.panelTipos.add(titlePanelTipos);
		
		this.checkIncendio = new JCheckBox("Incendios");
		this.checkIncendio.setBounds(20, 21, 97, 23);
		this.checkIncendio.setActionCommand("incendio");
		this.panelTipos.add(checkIncendio);
		
		this.checkMedica = new JCheckBox("Asistencias medica");
		this.checkMedica.setBounds(20, 47, 167, 23);
		this.checkMedica.setActionCommand("medico");
		this.panelTipos.add(checkMedica);
		
		this.checkSeguridad = new JCheckBox("Personal de seguridad");
		this.checkSeguridad.setBounds(20, 73, 185, 23);
		this.checkSeguridad.setActionCommand("seguridad");
		this.panelTipos.add(checkSeguridad);
		
		this.panelPuerto = new JPanel();
		this.panelConfiguracion.addTab("Puerto", null, panelPuerto, null);
		this.panelPuerto.setLayout(null);
		
		this.txtPuerto = new JLabel("Puerto asignado: ");
		this.txtPuerto.setBounds(10, 5, 126, 14);
		this.panelPuerto.add(txtPuerto);
		
		this.txtNumeroPuerto = new JLabel("-");
		this.txtNumeroPuerto.setBounds(119, 5, 46, 14);
		this.panelPuerto.add(txtNumeroPuerto);
		
		this.textFieldNuevoPuerto = new JTextField();
		this.textFieldNuevoPuerto.setBounds(10, 72, 86, 20);
		this.panelPuerto.add(textFieldNuevoPuerto);
		this.textFieldNuevoPuerto.setColumns(10);
		
		this.txtActualizarPuerto = new JLabel("Cambiar puerto :");
		this.txtActualizarPuerto.setBounds(10, 47, 112, 14);
		this.panelPuerto.add(txtActualizarPuerto);
		
		this.btnActualizarPuerto = new JButton("Actualizar");
		this.btnActualizarPuerto.setBounds(128, 71, 89, 23);
		this.btnActualizarPuerto.setActionCommand("actualizar puerto");
		this.panelPuerto.add(btnActualizarPuerto);
		
		this.tabbedPaneAlertas = new JTabbedPane(JTabbedPane.TOP);
		this.tabbedPaneAlertas.setBounds(10, 34, 232, 219);
		this.frmRecepcinDeEmergencias.getContentPane().add(this.tabbedPaneAlertas);
		
		this.panelIncendios = new JPanel();
		this.tabbedPaneAlertas.addTab("Incendio", null, this.panelIncendios, null);
		this.tabbedPaneAlertas.setEnabledAt(0, false);
		this.panelIncendios.setLayout(new BorderLayout(0, 0));
		
		this.listIncendios = new JList<Notificacion>(displayIncendio);
		this.listIncendios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.panelIncendios.add(this.listIncendios);
		
		this.panelSeguridad = new JPanel();
		this.tabbedPaneAlertas.addTab("Seguridad", null, this.panelSeguridad, null);
		this.tabbedPaneAlertas.setEnabledAt(1, false);
		this.panelSeguridad.setLayout(new BorderLayout(0, 0));
		
		this.listSeguridad = new JList<Notificacion>(displaySeguridad);;
		this.listSeguridad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.panelSeguridad.add(this.listSeguridad);
		
		this.panelAmbulancia = new JPanel();
		this.tabbedPaneAlertas.addTab("Ambulancia", null, this.panelAmbulancia, null);
		this.tabbedPaneAlertas.setEnabledAt(2, false);
		this.panelAmbulancia.setLayout(new BorderLayout(0, 0));
		
		this.listAmbulancia = new JList<Notificacion>(displayAmbulancia);
		this.listAmbulancia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);;
		this.panelAmbulancia.add(this.listAmbulancia);
		
		this.frmRecepcinDeEmergencias.setBackground(Color.DARK_GRAY);
		this.frmRecepcinDeEmergencias.setAlwaysOnTop(true);
		this.frmRecepcinDeEmergencias.setResizable(false);
		this.frmRecepcinDeEmergencias.setBounds(100, 100, 270, 460);
		this.frmRecepcinDeEmergencias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frmRecepcinDeEmergencias.setVisible(true);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnActualizarPuerto.addActionListener(actionListener);
		this.checkIncendio.addActionListener(actionListener);
		this.checkMedica.addActionListener(actionListener);
		this.checkSeguridad.addActionListener(actionListener);
		this.botonConfirmar.addActionListener(actionListener);
	}

	@Override
	public void mostrarError(String error) {
		JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
		
	}

	@Override
	public String getNuevoPuerto() {
		return this.textFieldNuevoPuerto.getText();
	}

	@Override
	public void limpiaCampoPuerto() {
		this.textFieldNuevoPuerto.setText("");
		
	}

	@Override
	public void muestraPuerto(String puerto) {
		this.txtNumeroPuerto.setText(puerto);
		
	}

	@Override
	public void agregarNotificacion(Notificacion nuevaNotificacion) { //esto me suena a q no esta bien, pero no se me ocurrio otra forma
		if(nuevaNotificacion.getTipo().equalsIgnoreCase("incendio")) {
//			System.out.println("Llego un incendio");
			this.displayIncendio.addElement(nuevaNotificacion);
		}else if(nuevaNotificacion.getTipo().equalsIgnoreCase("seguridad")) {
//			System.out.println("Llego un seguridad");
			this.displaySeguridad.addElement(nuevaNotificacion);
		}if(nuevaNotificacion.getTipo().equalsIgnoreCase("ambulancia")) {
//			System.out.println("Llego un ambulancia");
			this.displayAmbulancia.addElement(nuevaNotificacion);
		}
	}

	@Override
	public void toggleIncendio(boolean flag) {
		this.tabbedPaneAlertas.setEnabledAt(0, flag);
	}

	@Override
	public void toggleSeguridad(boolean flag) {
		this.tabbedPaneAlertas.setEnabledAt(1, flag);
	}

	@Override
	public void toggleAmbulancia(boolean flag) {
		this.tabbedPaneAlertas.setEnabledAt(2, flag);
	}

	@Override
	public Notificacion getSelectedValue() {
//		System.out.println(this.tabbedPaneAlertas.getSelectedIndex());
		int lista = this.tabbedPaneAlertas.getSelectedIndex();
		Notificacion respuesta = null;
		if(lista == 0) respuesta = this.listIncendios.getSelectedValue();
		else if(lista == 1) respuesta = this.listSeguridad.getSelectedValue();
		else if(lista == 2) respuesta = this.listAmbulancia.getSelectedValue();
		return respuesta;
	}
}
