package servidor.modelo.estados;

import servidor.modelo.Servidor;

public class PrimarioState extends State {

	public PrimarioState(Servidor s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize() {
		this.s.comienzaEscuchaEmisores();
		this.s.comienzaEscuchaNuevosReceptor();
		this.s.comienzoSincronizacion();
		this.s.getVista().setPuertoEmisores(Servidor.getPuertoEmisores());
		this.s.getVista().setPuertoReceptores(Servidor.getPuertoNuevosReceptores());
	}

	@Override
	public void cambiaEstado() {
		this.s.setEstado(new SecundarioState(this.s));
		this.initialize();
	}

	@Override
	public String informarEstado() {
		return "Primario";
	}

}
