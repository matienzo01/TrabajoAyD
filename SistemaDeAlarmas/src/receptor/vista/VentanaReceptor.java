package receptor.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

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

import notificacion.Notificacion;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;

public class VentanaReceptor extends JFrame implements IVistaReceptor {

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
	private JButton btnActualizarPuerto;
	private JList<Notificacion> listaNotificaciones;
	private DefaultListModel<Notificacion> modelo = new DefaultListModel<Notificacion>();

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

		this.btnActualizarPuerto = new JButton("Asignar");
		this.btnActualizarPuerto.setBounds(128, 71, 89, 23);
		this.btnActualizarPuerto.setActionCommand("actualizar puerto");
		this.panelPuerto.add(btnActualizarPuerto);

		this.listaNotificaciones = new JList<Notificacion>();
		this.listaNotificaciones.setBounds(10, 35, 244, 217);
		this.frmRecepcinDeEmergencias.getContentPane().add(listaNotificaciones);
		this.listaNotificaciones.setModel(modelo);

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

	@SuppressWarnings("deprecation")
	public void puertoDefinido() {
		this.textFieldNuevoPuerto.hide();
		this.btnActualizarPuerto.hide();
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
}
	

