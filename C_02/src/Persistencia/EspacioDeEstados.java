package Persistencia;

import java.util.ArrayList;

public class EspacioDeEstados {

	private ArrayList<Nodo> listaNodos;
	public Estado estado;
	
	public ArrayList<Nodo> getListaNodos() {
		return listaNodos;
	}
	public void setListaNodos(ArrayList<Nodo> listaNodos) {
		this.listaNodos = listaNodos;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
