package Persistencia;

import Dominio.GenerarEstados;

/**
 * 
 * Crea los nodos y los asocia a un padre si hay asignado una coste y una
 * profundidad
 * 
 * @author Jorge
 *
 * @version 1.0
 *
 */
public class Nodo {

	private int profundidad;
	private int costo;
	private Estado estado;
	private Nodo padre;
	private Accion accion;
	private int valor;

	public Nodo(int profundidad, int costo, Estado estado, Nodo padre, Accion accion, int valor) {
		this.profundidad = profundidad;
		this.costo = costo;
		this.estado = estado;
		this.padre = padre;
		this.accion = accion;
		this.valor = valor;
	}

	public int getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(int profundidad) {
		this.profundidad = profundidad;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Nodo getPadre() {
		return padre;
	}

	public void setPadre(Nodo padre) {
		this.padre = padre;
	}

	public Accion getAccion() {
		return accion;
	}

	public void setAccion(Accion accion) {
		this.accion = accion;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "[profundidad=" + profundidad + ", costo=" + costo + ", estado=" + estado + ", padre=" + padre
				+ ", accion=" + accion + ", valor=" + valor + "]";
	}
	
}
