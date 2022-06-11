package servidor.vista;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class VistaServidor extends JFrame implements IVistaServidor{

	private JPanel contentPane;
	private JLabel lblServidor;
	private JTextArea logTextArea;
	private JLabel lblReceptores;
	private JLabel lblPuertos;
	private JLabel lblNumeroPuertoReceptores;
	private JLabel lblEmisores;
	private JLabel lblPuertoEmisores;


	public VistaServidor() {
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 463);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Servidor");
		getContentPane().setLayout(new BorderLayout(0, 0));
		this.contentPane.setLayout(null);
		
		this.lblServidor = new JLabel("Servidor");
		this.lblServidor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.lblServidor.setBounds(343, 11, 200, 38);
		this.contentPane.add(this.lblServidor);
		
		this.logTextArea = new JTextArea();
		this.logTextArea.setLineWrap(true);
		this.logTextArea.setWrapStyleWord(true);
		this.logTextArea.setBounds(103, 60, 633, 353);
		this.contentPane.add(this.logTextArea);
		
		this.lblReceptores = new JLabel("Receptores:");
		this.lblReceptores.setBounds(10, 75, 83, 14);
		this.contentPane.add(this.lblReceptores);
		
		this.lblPuertos = new JLabel("Puertos");
		this.lblPuertos.setBounds(20, 53, 46, 14);
		this.contentPane.add(this.lblPuertos);
		
		this.lblNumeroPuertoReceptores = new JLabel("-");
		this.lblNumeroPuertoReceptores.setBounds(20, 100, 46, 14);
		this.contentPane.add(this.lblNumeroPuertoReceptores);
		
		this.lblEmisores = new JLabel("Emisores:");
		this.lblEmisores.setBounds(10, 123, 83, 14);
		this.contentPane.add(this.lblEmisores);
		
		this.lblPuertoEmisores = new JLabel("-");
		this.lblPuertoEmisores.setBounds(20, 148, 46, 14);
		this.contentPane.add(this.lblPuertoEmisores);
		setContentPane(this.contentPane);
		this.setVisible(true);
	}


	@Override
	public void setPuertoReceptores(int puerto) {
		this.lblNumeroPuertoReceptores.setText(""+puerto);
		
	}


	@Override
	public void setPuertoEmisores(int puerto) {
		this.lblPuertoEmisores.setText(""+puerto);
	}


	@Override
	public void agregaLogRegistro(String direccion, int puerto, boolean incendio, boolean seguridad,
			boolean ambulancia) {
		String log = "Se ha registrado un nuevo receptor. Su direccion es " + direccion + " y espera notificaciones en el puerto " + puerto;
		if(incendio)
			log += ". Atiende incendios";
		if(seguridad)
			log += ". Atiende personal de seguridad";
		if(ambulancia)
			log += ". Atiende asistencias medicas";
		log+=".\n";
		
		this.logTextArea.append(log);
		
	}


	@Override
	public void agregaLogNotificacion(String cadena) {
		this.logTextArea.append(cadena+"\n");
		
	}


	@Override
	public void setState(String state) {
		this.lblServidor.setText("Servidor " + state);
		
	}

}
