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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 244, 241);
		frmRecepcinDeEmergencias.getContentPane().add(tabbedPane);
		
		JScrollPane panelNotificaciones = new JScrollPane();
		panelNotificaciones.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		tabbedPane.addTab("Notificaciones", null, panelNotificaciones, null);
		
		JPanel panelConfiguracion = new JPanel();
		panelConfiguracion.setBackground(Color.DARK_GRAY);
		panelConfiguracion.setForeground(Color.DARK_GRAY);
		tabbedPane.addTab("Configuraci\u00F3n", null, panelConfiguracion, null);
		tabbedPane.setForegroundAt(1, Color.WHITE);
		tabbedPane.setBackgroundAt(1, Color.DARK_GRAY);
		panelConfiguracion.setLayout(new CardLayout(0, 0));
		frmRecepcinDeEmergencias.setBackground(Color.DARK_GRAY);
		frmRecepcinDeEmergencias.setAlwaysOnTop(true);
		frmRecepcinDeEmergencias.setResizable(false);
		frmRecepcinDeEmergencias.setBounds(100, 100, 270, 360);
		frmRecepcinDeEmergencias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
