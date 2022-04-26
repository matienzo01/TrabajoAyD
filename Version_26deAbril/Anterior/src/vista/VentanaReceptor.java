package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class VentanaReceptor extends JFrame {

	private JPanel contentPane;
	private JList listaSolicitudes;
	private JPanel panelInteraccion;
	private JPanel panelSolicitudes;
	private JPanel panelConfiguracion;
	private JButton btnAceptar;
	private JButton btnRechazar;
	private JCheckBox chckbxIncendios;
	private JCheckBox chckbxSeguridad;
	private JCheckBox chckbxMedicos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaReceptor frame = new VentanaReceptor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaReceptor() {
		setTitle("Sistema Receptor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 349);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		
		this.listaSolicitudes = new JList();
		this.contentPane.add(this.listaSolicitudes, BorderLayout.CENTER);
		
		this.panelInteraccion = new JPanel();
		this.contentPane.add(this.panelInteraccion, BorderLayout.SOUTH);
		
		this.panelSolicitudes = new JPanel();
		this.panelInteraccion.add(this.panelSolicitudes);
		
		this.btnAceptar = new JButton("Aceptar");
		this.panelSolicitudes.add(this.btnAceptar);
		
		this.btnRechazar = new JButton("Rechazar");
		this.panelSolicitudes.add(this.btnRechazar);
		
		this.panelConfiguracion = new JPanel();
		this.panelInteraccion.add(this.panelConfiguracion);
		
		this.chckbxIncendios = new JCheckBox("Incendios");
		this.chckbxIncendios.setSelected(true);
		this.panelConfiguracion.add(this.chckbxIncendios);
		
		this.chckbxSeguridad = new JCheckBox("Seguridad");
		this.chckbxSeguridad.setSelected(true);
		this.panelConfiguracion.add(this.chckbxSeguridad);
		
		this.chckbxMedicos = new JCheckBox("Medicos");
		this.chckbxMedicos.setSelected(true);
		this.panelConfiguracion.add(this.chckbxMedicos);
	}

}
