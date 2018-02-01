package Dominio;

import java.util.ArrayList;

import Persistencia.Accion;
import Persistencia.DistribucionTerreno;
import Persistencia.Ficheros;
import Persistencia.Posicion;

public class GenerarEstados {

	private Accion[][] Terreno;
	private String[][] TerrenoString;
	GenerarTerreno generando = new GenerarTerreno();
	Ficheros fichero = new Ficheros();

	public GenerarEstados(ArrayList<Integer> datos) {
		Terreno = generando.GenerarElTerreno(datos);
		TerrenoString = generando.CopiarTerreno(Terreno, TerrenoString);
		generando.MostrarTerrenoTractor(TerrenoString, 0, 0);
	}

	public void CostoAccion(Accion accion) {
		int coste = 1;
		for (int i = 0; i < accion.getNumListDistrib(); i++) {
			coste = coste + accion.getDist(i).getArena();
		}
		accion.setCoste(coste);
	}
	
	public boolean ComprobarPosibleAccion(int valor, ArrayList<DistribucionTerreno> listaDistribucionTerreno) {
		int sumatorio=0;
		boolean salida =false;
		for(int i=0;i<listaDistribucionTerreno.size();i++) {
			sumatorio=sumatorio+listaDistribucionTerreno.get(i).getArena();
		}
		return salida;
	}
	
	public int CalcularTierraSobrante() {
		
	}

	public void backPosiblesAcciones(int etapa, ArrayList<Posicion> posValidas,
			ArrayList<DistribucionTerreno> distribuciones, ArrayList<Accion> acciones) {
		if(etapa==posValidas.size()) {
			Accion nuevaAccion = new Accion(posValidas.get(etapa-1).getPosX(),posValidas.get(etapa-1).getPosY(),1, distribuciones);
			//una clase accion viene determinada por la posicion X, Y, el coste y la distribucion 
			CostoAccion(nuevaAccion);
			if(ComprobarPosibleAccion(valor, listaDistribucionTerreno))
		}

	}

}
