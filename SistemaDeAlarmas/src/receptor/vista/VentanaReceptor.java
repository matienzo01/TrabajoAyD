package receptor.vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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

import notificacion.Notificacion;

public class VentanaReceptor extends JFrame implements IVistaReceptor {

	private JFrame frmRecepcinDeEmergencias;
	private JTextField textFieldNuevoPuerto;
	private JButton botonConfirmar;
	private JTabbedPane panelConfiguracion;
	private JPanel panelPuerto;
	private JLabel txtPuerto;
	private JLabel txtNumeroPuerto;
	private JButton btnRegistrar;
	private JList<Notificacion> listaNotificaciones;
	private DefaultListModel<Notificacion> modelo = new DefaultListModel<Notificacion>();
	//private JPanel panel;
	private JList<Notificacion> listaConfirmadas;
	private DefaultListModel<Notificacion> modeloConfirmadas = new DefaultListModel<Notificacion>();
	private JTabbedPane panelNotificaciones;
	private JLabel titlePanelTipos ;
	private JCheckBox checkIncendio;
	private JCheckBox checkMedica;
	private JCheckBox checkSeguridad;
	private JLabel lblInformacion;
	private JLabel lblIncendios;
	private JLabel lblMedica;
	private JLabel lblSeguridad;
	/**
	 * Create the application.
	 */
	public VentanaReceptor() {
		this.frmRecepcinDeEmergencias = new JFrame();
		this.frmRecepcinDeEmergencias.setForeground(Color.BLACK);
		this.frmRecepcinDeEmergencias.setTitle("Emergencias");
		this.frmRecepcinDeEmergencias.getContentPane().setBackground(Color.DARK_GRAY);

		this.frmRecepcinDeEmergencias.getContentPane().setLayout(null);

		this.panelConfiguracion = new JTabbedPane(JTabbedPane.TOP);
		this.panelConfiguracion.setBounds(10, 11, 244, 293);
		this.frmRecepcinDeEmergencias.getContentPane().add(panelConfiguracion);

		this.panelPuerto = new JPanel();
		this.panelConfiguracion.addTab("Configuracion", null, panelPuerto, null);
		this.panelPuerto.setLayout(null);
		
				this.textFieldNuevoPuerto = new JTextField();
				this.textFieldNuevoPuerto.setBounds(79, 44, 86, 20);
				this.panelPuerto.add(textFieldNuevoPuerto);
				this.textFieldNuevoPuerto.setColumns(10);

		this.txtPuerto = new JLabel("Puerto : ");
		this.txtPuerto.setBounds(10, 47, 126, 14);
		this.panelPuerto.add(txtPuerto);

		this.txtNumeroPuerto = new JLabel("-");
		this.txtNumeroPuerto.setBounds(114, 47, 46, 14);
		this.panelPuerto.add(txtNumeroPuerto);

		this.btnRegistrar = new JButton("Registrarse");
		this.btnRegistrar.setBounds(76, 208, 89, 23);
		this.btnRegistrar.setActionCommand("registro");
		this.panelPuerto.add(btnRegistrar);
		
		this.titlePanelTipos = new JLabel("Seleccione tipos de notificacion");
		this.titlePanelTipos.setBounds(10, 97, 227, 14);
		this.panelPuerto.add(titlePanelTipos);
		
		this.checkIncendio = new JCheckBox("Incendios");
		this.checkIncendio.setActionCommand("incendio");
		this.checkIncendio.setBounds(10, 118, 97, 23);
		this.panelPuerto.add(checkIncendio);
		
		this.checkMedica = new JCheckBox("Asistencias medica");
		this.checkMedica.setActionCommand("medico");
		this.checkMedica.setBounds(10, 144, 167, 23);
		this.panelPuerto.add(checkMedica);
		
		this.checkSeguridad = new JCheckBox("Personal de seguridad");
		this.checkSeguridad.setActionCommand("seguridad");
		this.checkSeguridad.setBounds(10, 170, 185, 23);
		this.panelPuerto.add(checkSeguridad);
		
		this.panelNotificaciones = new JTabbedPane(JTabbedPane.TOP);
		this.panelNotificaciones.setVisible(false);
		panelNotificaciones.setBounds(10, 11, 244, 246);
		frmRecepcinDeEmergencias.getContentPane().add(panelNotificaciones);
				
						this.listaNotificaciones = new JList<Notificacion>();
						panelNotificaciones.addTab("Nuevas", null, listaNotificaciones, null);
						this.listaNotificaciones.setModel(modelo);
						
						this.listaConfirmadas = new JList<Notificacion>();
						panelNotificaciones.addTab("Confirmadas", null, listaConfirmadas, null);
						this.listaConfirmadas.setModel(modeloConfirmadas);
						
								this.botonConfirmar = new JButton("Confirmar");
								this.botonConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								this.botonConfirmar.setBounds(88, 268, 96, 23);
								this.botonConfirmar.setBackground(new Color(144, 238, 144));
								this.botonConfirmar.setActionCommand("confirmar");
								this.frmRecepcinDeEmergencias.getContentPane().add(botonConfirmar);
								
								this.lblInformacion = new JLabel("");
								this.lblInformacion.setForeground(Color.WHITE);
								this.lblInformacion.setBounds(10, 315, 244, 30);
								this.frmRecepcinDeEmergencias.getContentPane().add(this.lblInformacion);
								
								this.lblIncendios = new JLabel("Incendios");
								this.lblIncendios.setForeground(new Color(240, 230, 140));
								this.lblIncendios.setBounds(10, 353, 174, 14);
								this.frmRecepcinDeEmergencias.getContentPane().add(this.lblIncendios);
								this.lblIncendios.setVisible(false);
								
								this.lblMedica = new JLabel("Asistencias medicas");
								this.lblMedica.setForeground(new Color(250, 128, 114));
								this.lblMedica.setBounds(10, 381, 190, 14);
								this.frmRecepcinDeEmergencias.getContentPane().add(this.lblMedica);
								this.lblMedica.setVisible(false);
								
								this.lblSeguridad = new JLabel("Personal de seguridad");
								this.lblSeguridad.setForeground(new Color(100, 149, 237));
								this.lblSeguridad.setBounds(10, 406, 190, 14);
								this.frmRecepcinDeEmergencias.getContentPane().add(this.lblSeguridad);
								this.lblSeguridad.setVisible(false);
				

		this.frmRecepcinDeEmergencias.setBackground(Color.DARK_GRAY);
		this.frmRecepcinDeEmergencias.setAlwaysOnTop(true);
		this.frmRecepcinDeEmergencias.setResizable(false);
		this.frmRecepcinDeEmergencias.setBounds(100, 100, 283, 466);
		this.frmRecepcinDeEmergencias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frmRecepcinDeEmergencias.setVisible(true);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnRegistrar.addActionListener(actionListener);
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

	@SuppressWarnings("deprecation")
	public void puertoDefinido() {
		this.textFieldNuevoPuerto.hide();
		this.btnRegistrar.hide();
	}
	
	@Override
	public void agregarNotificacion(Notificacion nuevaNotificacion) {
		modelo.addElement(nuevaNotificacion);
		this.alarma();
	}
	
    public void alarma(){
        try {
         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./src/img/alarma.wav").getAbsoluteFile());
         Clip clip = AudioSystem.getClip();
         clip.open(audioInputStream);
         clip.start();
        } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
          System.out.println("Error al reproducir el sonido."+ex.getMessage());
        }
      }

	@Override
	public Notificacion getSelectedNotification() {
		return this.listaNotificaciones.getSelectedValue();
	}

	@Override
	public void eliminaNotificacion(Notificacion n) {
		this.modelo.removeElement(n);
	}

	@Override
	public void agregaConfirmada(Notificacion n) {
		this.modeloConfirmadas.addElement(n);
	}

	@Override
	public void cambioDePantalla(boolean incendio,boolean medica, boolean seguridad) {
		this.panelConfiguracion.setVisible(false);
		this.panelNotificaciones.setVisible(true);
		String info = "Receptor en puerto = "+ this.txtNumeroPuerto.getText();
		this.lblInformacion.setText(info);
		if(incendio)
			this.lblIncendios.setVisible(true);
		if(medica)
			this.lblMedica.setVisible(true);
		if(seguridad)
			this.lblSeguridad.setVisible(true);
	}
}
	

