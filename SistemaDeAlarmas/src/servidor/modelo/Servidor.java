package servidor.modelo;

import java.util.ArrayList;

import notificacion.Notificacion;
import servidor.modelo.estados.IState;
import servidor.modelo.estados.PrimarioState;
import servidor.vista.IVistaServidor;
import servidor.vista.VistaServidor;

public class Servidor {

	private static Servidor instance = null;
	private static int puertoSincronizacion = 2222;
	private static int puertoSyncNuevasNotificaciones = 6666;
	private static int puertoSyncNuevosReceptores = 7777;
	protected ArrayList<ReceptorServer> receptores = new ArrayList<ReceptorServer>();
	protected ArrayList<Notificacion> historial = new ArrayList<Notificacion>();
	private IState estado = new PrimarioState(this);

	private IVistaServidor vista = new VistaServidor();

	private Servidor() {
	}

	public void setEstado(IState estado) {
		this.estado = estado;
	}

	public IVistaServidor getVista() {
		return vista;
	}

	public ArrayList<ReceptorServer> getReceptores() {
		return receptores;
	}

	public void setReceptores(ArrayList<ReceptorServer> receptores) {
		this.receptores = receptores;
	}

	public ArrayList<Notificacion> getHistorial() {
		return historial;
	}

	public void setHistorial(ArrayList<Notificacion> historial) {
		this.historial = historial;
	}

	public static int getPuertoSincronizacion() {
		return puertoSincronizacion;
	}
	
	

	public static int getPuertoSyncNuevasNotificaciones() {
		return puertoSyncNuevasNotificaciones;
	}

	public static int getPuertoSyncNuevosReceptores() {
		return puertoSyncNuevosReceptores;
	}

	public static Servidor getInstance() {
		if (Servidor.instance == null) {
			Servidor.instance = new Servidor();
		}
		return Servidor.instance;
	}

	public void initialize() {
		this.estado.initialize();
	}

	public void logNuevoRegistroReceptor(String direccion, int puerto, boolean incendio, boolean seguridad,
			boolean ambulancia) {
		this.vista.agregaLogRegistro(direccion, puerto, incendio, seguridad, ambulancia);
	}

	public void logEnvio(Notificacion n) {
		this.vista.agregaLogNotificacion(n.toStringAdmin());

	}

	public void agregaAlHistorial(Notificacion n) {
		this.historial.add(n);

	}

	public void agregarReceptor(ReceptorServer rs) {
		this.receptores.add(rs);

	}

	public void cambiaEstado() {
		this.estado.cambiaEstado();
	}
}
