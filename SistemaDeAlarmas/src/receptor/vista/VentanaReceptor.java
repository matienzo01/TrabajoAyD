package receptor.vista;

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
import javax.swing.JTabbedPane;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class VentanaReceptor {

	private JFrame frmRecepcinDeEmergencias;
	private JTextField textFieldNuevo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaReceptor window = new VentanaReceptor();
					window.frmRecepcinDeEmergencias.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaReceptor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRecepcinDeEmergencias = new JFrame();
		frmRecepcinDeEmergencias.setForeground(Color.BLACK);
		frmRecepcinDeEmergencias.setTitle("Emergencias");
		frmRecepcinDeEmergencias.getContentPane().setBackground(Color.DARK_GRAY);
		
		JButton botonConfirmar = new JButton("Confirmar");
		botonConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonConfirmar.setBounds(77, 263, 96, 23);
		botonConfirmar.setBackground(new Color(144, 238, 144));
		botonConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmRecepcinDeEmergencias.getContentPane().setLayout(null);
		frmRecepcinDeEmergencias.getContentPane().add(botonConfirmar);
		
		JPanel panelNotificaciones = new JPanel();
		panelNotificaciones.setBounds(10, 35, 232, 217);
		frmRecepcinDeEmergencias.getContentPane().add(panelNotificaciones);
		
		JLabel labelTitulo = new JLabel("Ultimas notificaciones : ");
		labelTitulo.setForeground(new Color(240, 255, 255));
		labelTitulo.setBounds(10, 10, 145, 14);
		frmRecepcinDeEmergencias.getContentPane().add(labelTitulo);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(0, 0, 5, 5);
		frmRecepcinDeEmergencias.getContentPane().add(tabbedPane_2);
		
		JTabbedPane panelConfiguracion = new JTabbedPane(JTabbedPane.TOP);
		panelConfiguracion.setBounds(10, 289, 232, 131);
		frmRecepcinDeEmergencias.getContentPane().add(panelConfiguracion);
		
		JPanel panelTipos = new JPanel();
		panelConfiguracion.addTab("Tipos", null, panelTipos, null);
		panelTipos.setLayout(null);
		
		JLabel titlePanelTipos = new JLabel("Seleccione tipos de notificacion");
		titlePanelTipos.setBounds(0, 0, 227, 14);
		panelTipos.add(titlePanelTipos);
		
		JCheckBox checkIncendio = new JCheckBox("Incendios");
		checkIncendio.setBounds(20, 21, 97, 23);
		panelTipos.add(checkIncendio);
		
		JCheckBox checkMedica = new JCheckBox("Asistencias medica");
		checkMedica.setBounds(20, 47, 167, 23);
		panelTipos.add(checkMedica);
		
		JCheckBox checkSeguridad = new JCheckBox("Personal de seguridad");
		checkSeguridad.setBounds(20, 73, 185, 23);
		panelTipos.add(checkSeguridad);
		
		JPanel panelPuerto = new JPanel();
		panelConfiguracion.addTab("Puerto", null, panelPuerto, null);
		panelPuerto.setLayout(null);
		
		JLabel txtPuerto = new JLabel("Puerto asignado: ");
		txtPuerto.setBounds(10, 5, 126, 14);
		panelPuerto.add(txtPuerto);
		
		JLabel txtNumeroPuerto = new JLabel("-");
		txtNumeroPuerto.setBounds(119, 5, 46, 14);
		panelPuerto.add(txtNumeroPuerto);
		
		textFieldNuevo = new JTextField();
		textFieldNuevo.setBounds(10, 72, 86, 20);
		panelPuerto.add(textFieldNuevo);
		textFieldNuevo.setColumns(10);
		
		JLabel txtActualizarPuerto = new JLabel("Cambiar puerto :");
		txtActualizarPuerto.setBounds(10, 47, 112, 14);
		panelPuerto.add(txtActualizarPuerto);
		
		JButton btnActualizarPuerto = new JButton("Actualizar");
		btnActualizarPuerto.setBounds(128, 71, 89, 23);
		panelPuerto.add(btnActualizarPuerto);
		frmRecepcinDeEmergencias.setBackground(Color.DARK_GRAY);
		frmRecepcinDeEmergencias.setAlwaysOnTop(true);
		frmRecepcinDeEmergencias.setResizable(false);
		frmRecepcinDeEmergencias.setBounds(100, 100, 270, 460);
		frmRecepcinDeEmergencias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
