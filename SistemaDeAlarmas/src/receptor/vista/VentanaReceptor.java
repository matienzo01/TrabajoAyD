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
		
		JButton btnConfiguracion = new JButton("Configuracion");
		btnConfiguracion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnConfiguracion.setBounds(10, 297, 104, 23);
		frmRecepcinDeEmergencias.getContentPane().add(btnConfiguracion);
		frmRecepcinDeEmergencias.setBackground(Color.DARK_GRAY);
		frmRecepcinDeEmergencias.setAlwaysOnTop(true);
		frmRecepcinDeEmergencias.setResizable(false);
		frmRecepcinDeEmergencias.setBounds(100, 100, 270, 360);
		frmRecepcinDeEmergencias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
