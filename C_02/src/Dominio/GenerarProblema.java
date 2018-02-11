package Dominio;

import Persistencia.EspacioDeEstados;
import Persistencia.Estado;
import Persistencia.Nodo;
import Persistencia.Problema;

public class GenerarProblema {

	private Problema p;
	
	public GenerarProblema(EspacioDeEstados espacioEstados, Estado estadoInicial) {
		p = new Problema(espacioEstados, estadoInicial);
	}
	
	public Nodo RealizarBusqueda(int estrategia, int profundidadMaxima) {
		Nodo nodoActual= null;
		int valor=0;
		int cota=30;
		int profundidadAcotada=cota;
		switch(estrategia) {
		case 1:
			valor=(profundidadMaxima-(nodoActual.getProfundidad()+1))*(-1);
			break;
		case 2:
			if(profundidadAcotada<=profundidadMaxima) {
				valor=(profundidadAcotada-(nodoActual.getProfundidad()+1))*(-1);
			}else {
				
			}
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		}
		return nodoActual;
	}
}
