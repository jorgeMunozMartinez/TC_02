package Persistencia;
/**
 * 
 * Guardo en una lista todos los nodos ordenados por valor
 * 
 * @author Jorge
 *
 *@version 1.0
 *
 */

import java.util.PriorityQueue;

public class Frontera {

	private PriorityQueue<Nodo> fronteraCola;

	public Frontera(PriorityQueue<Nodo> fronteraCola) {
		this.fronteraCola = fronteraCola;
	}

	public PriorityQueue<Nodo> getFronteraCola() {
		return fronteraCola;
	}

	public void setFronteraCola(PriorityQueue<Nodo> fronteraCola) {
		this.fronteraCola = fronteraCola;
	}
	
	public void insertarNodo(Nodo n) {
		this.fronteraCola.add(n);
	}
	public Nodo eliminarNodo() {
		Nodo n = this.fronteraCola.poll();
		return n;
	}
	
	public boolean esVacia() {
		if (this.fronteraCola.size() > 0)
			return false;
		else
			return true;
	}
	
	public void limpiar() {
		fronteraCola.clear();
	}
}
