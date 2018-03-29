package Persistencia;

public class Problema {
	
	private Estado estadoInicial;
	private EspacioDeEstados espacioEstados;

	public Problema(EspacioDeEstados espacioEstados, Estado estadoInicial) {
		this.estadoInicial = estadoInicial;
		this.espacioEstados = espacioEstados;
	}

	public Estado getEstadoInicial() {
		return estadoInicial;
	}

	public void setEstadoInicial(Estado estadoInicial) {
		this.estadoInicial = estadoInicial;
	}

	public EspacioDeEstados getEspacioEstados() {
		return espacioEstados;
	}

	public void setEspacioEstados(EspacioDeEstados espacioEstados) {
		this.espacioEstados = espacioEstados;
	}
}
