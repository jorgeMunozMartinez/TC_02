package Persistencia;

import java.util.ArrayList;

import Dominio.GenerarEstados;

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
	
	public ArrayList<Sucesor> obtenerSucesores(GenerarEstados estados,Nodo nodo){
		ArrayList<Sucesor> listaSucesores = new ArrayList<Sucesor>();
		ArrayList<Distribucion> posicionesValidas = nodo.getEstado().getTerreno()[estados.getEstado().getPosX()][estados.getEstado().getPosY()].getListaDistribucion();
		ArrayList<Accion> listaAcciones = new ArrayList<Accion>();
		ArrayList<Distribucion> listaDistribuciones = new ArrayList<Distribucion>();
		estados.BackPosiblesAcciones(0,posicionesValidas,listaDistribuciones,listaAcciones);
		estados.accionesPosibles(listaAcciones, posicionesValidas);
		for(int i=0;i<listaAcciones.size();i++) {
			Estado nuevo = nodo.getEstado().Clone();
			estados.realizarAccion(listaAcciones.get(i), nuevo);
			Sucesor sucee = new Sucesor(listaAcciones.get(i), nuevo, listaAcciones.get(i).getCoste()+nodo.getCosto());
			listaSucesores.add(sucee);
		}

		return listaSucesores;
	}
	
}
