package Persistencia;
/**
 * 
 * Genera un sicesor con una accion, estado y el coste 
 * 
 * @author Jorge
 *
 *@version 1.0
 *
 */
public class Sucesor {
	
	private Accion accion;
	private Estado estado;
	private int coste;
	
	public Sucesor(Accion accion, Estado estado, int coste) {
		this.accion = accion;
		this.estado = estado;
		this.coste = coste;
	}

	public Accion getAccion() {
		return accion;
	}

	public void setAccion(Accion accion) {
		this.accion = accion;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public int getCoste() {
		return coste;
	}

	public void setCoste(int coste) {
		this.coste = coste;
	}

	@Override
	public String toString() {
		return "[accion=" + accion + ", estado=" + estado + ", coste=" + coste + "]";
	}
	
	
}
