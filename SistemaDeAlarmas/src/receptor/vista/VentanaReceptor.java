package receptor.vista;

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
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Font;

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
