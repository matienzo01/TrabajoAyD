package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaEmisor extends JFrame {

	private JPanel contentPane;
	private JPanel panelPrincipal;
	private JButton botonIncendio;
	private JButton botonPolicia;
	private JButton btnMedicos;
	private JLabel lblSistemaEmisor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEmisor frame = new VentanaEmisor();
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
	public VentanaEmisor() {
		setResizable(false);
		setTitle("Sistema Emisor");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panelPrincipal = new JPanel();
		this.contentPane.add(this.panelPrincipal);
		this.panelPrincipal.setLayout(null);
		
		this.botonIncendio = new JButton("Incendio");
		this.botonIncendio.setBounds(296, 109, 73, 23);
		this.panelPrincipal.add(this.botonIncendio);
		
		this.botonPolicia = new JButton("Policia");
		this.botonPolicia.setBounds(186, 108, 61, 23);
		this.panelPrincipal.add(this.botonPolicia);
		
		this.btnMedicos = new JButton("Medicos");
		this.btnMedicos.setBounds(54, 107, 71, 23);
		this.panelPrincipal.add(this.btnMedicos);
		
		this.lblSistemaEmisor = new JLabel("Sistema Emisor");
		this.lblSistemaEmisor.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblSistemaEmisor.setFont(new Font("Tahoma", Font.PLAIN, 29));
		this.lblSistemaEmisor.setBounds(0, 0, 424, 35);
		this.panelPrincipal.add(this.lblSistemaEmisor);
	}

}
