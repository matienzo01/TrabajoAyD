package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Cursor;
import javax.swing.JCheckBox;

public class VentanaReceptor {

	private JFrame frmRecepcinDeEmergencias;

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
		
		JPanel panelTipos = new JPanel();
		panelTipos.setBounds(54, 297, 143, 83);
		frmRecepcinDeEmergencias.getContentPane().add(panelTipos);
		panelTipos.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Foco de incendios");
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBounds(6, 7, 137, 23);
		panelTipos.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Personal de seguridad");
		chckbxNewCheckBox_1.setBounds(6, 33, 137, 23);
		panelTipos.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Asistencia m\u00E9dica");
		chckbxNewCheckBox_2.setSelected(true);
		chckbxNewCheckBox_2.setBounds(6, 59, 131, 23);
		panelTipos.add(chckbxNewCheckBox_2);
		
		JPanel panelNotificaciones = new JPanel();
		panelNotificaciones.setBounds(20, 30, 220, 229);
		frmRecepcinDeEmergencias.getContentPane().add(panelNotificaciones);
		panelNotificaciones.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Incendio");
		lblNewLabel.setBackground(new Color(238, 232, 170));
		lblNewLabel.setBounds(2, 2, 216, 25);
		panelNotificaciones.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Asistencia m\u00E9dica");
		lblNewLabel_1.setBackground(new Color(250, 128, 114));
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setBounds(2, 27, 220, 25);
		panelNotificaciones.add(lblNewLabel_1);
		frmRecepcinDeEmergencias.setBackground(Color.DARK_GRAY);
		frmRecepcinDeEmergencias.setAlwaysOnTop(true);
		frmRecepcinDeEmergencias.setResizable(false);
		frmRecepcinDeEmergencias.setBounds(100, 100, 270, 420);
		frmRecepcinDeEmergencias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
