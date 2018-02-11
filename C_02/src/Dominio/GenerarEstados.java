package Dominio;

import java.util.ArrayList;

import Persistencia.Accion;
import Persistencia.Distribucion;
import Persistencia.Estado;
import Persistencia.Ficheros;
import Persistencia.Posicion;

public class GenerarEstados {

	private Posicion[][] Terreno;
	private String[][] TerrenoString;
	private Estado estado;
	GenerarTerreno generando = new GenerarTerreno();
	Ficheros fichero = new Ficheros();

	public GenerarEstados(ArrayList<Integer> datos) {
		Terreno = generando.GenerarElTerreno(datos);
		estado = new Estado(datos,Terreno);	
		TerrenoString = generando.CopiarTerreno(Terreno, TerrenoString);
		generando.MostrarTerrenoTractor(TerrenoString, 0, 0);
	}

	public void CostoAccion(Accion accion) {
		/**
		 * coste asociado a una accion
		 */
		int coste = 1;
		for (int i = 0; i < accion.getNumListDistrib(); i++) {
			coste = coste + accion.getDist(i).getArena();
		}
		accion.setCoste(coste);
	}

	public boolean ComprobarPosibleAccion(int valor, ArrayList<Distribucion> listaDistribucionTerreno) {
		/**
		 * Solo si se reparte toda la tierra es una accion posible
		 */
		int sumatorio = 0;
		boolean salida = false;
		for (int i = 0; i < listaDistribucionTerreno.size(); i++) {
			sumatorio = sumatorio + listaDistribucionTerreno.get(i).getArena();
		}
		if (sumatorio == valor) {
			salida = true;
		}
		return salida;
	}

	public int CalcularTierraSobrante() {
		/**
		 * retorna la tierra sobrante en una posicion determinada
		 */
		int terreno = Terreno[estado.getPosX()][estado.getPosY()].getTierra() - estado.getK();
		if (terreno < 0) {
			return 0;
		} else {
			return terreno;
		}
	}

	public boolean ProbarLimiteDeTierra(int cantidadTierra, Posicion posicion) {
		/**
		 * Comprueba si es posible es reparticion de tierra sin superar el maximo
		 */
		if ((cantidadTierra + posicion.getTierra()) > estado.getMax()) {
			return false;
		} else {
			return true;
		}
	}

	public void BackPosiblesAcciones(int etapa, ArrayList<Posicion> posValidas, ArrayList<Distribucion> distribuciones,
			ArrayList<Accion> acciones) {
		/**
		 * Genera las acciones posibles asociadoas a un estado
		 */
		if (etapa == posValidas.size()) {
			Accion nuevaAccion = new Accion(posValidas.get(etapa - 1).getPosX(), posValidas.get(etapa - 1).getPosY(), 1,
					distribuciones);
			// una clase accion viene determinada por la posicion X, Y, el coste y la
			// distribucion
			CostoAccion(nuevaAccion);
			if (ComprobarPosibleAccion(CalcularTierraSobrante(), distribuciones)) {
				acciones.add(nuevaAccion);
			}
		} else {
			for (int i = 0; i <= CalcularTierraSobrante(); i++) {
				if (ProbarLimiteDeTierra(i, posValidas.get(etapa))) {
					Distribucion distribucion = new Distribucion(posValidas.get(etapa).getPosX(),
							posValidas.get(etapa).getPosY(), i);
					distribuciones.add(distribucion);
					BackPosiblesAcciones(etapa + 1, posValidas, distribuciones, acciones);
					distribuciones.remove(etapa);
				}
			}
		}
	}

	public int CalculoHeuristica() {
		/**
		 * calculo de heuristica: las casillas que no tiene la "K" deseada
		 */
		int heuristica = 0;
		for (int i = 0; i < Terreno.length; i++) {
			for (int j = 0; j < Terreno[i].length; j++) {
				if (Terreno[i][j].getTierra() != estado.getK()) {
					heuristica = heuristica + 1;
				}
			}
		}
		return heuristica;
	}
	public boolean RepartoUniforme() {
		/**
		 * Comprueba si la totalidad de la tierra es "k"
		 */
		boolean uniforme=false;
		for (int i = 0; i < Terreno.length; i++) {
			for (int j = 0; j < Terreno[i].length; j++) {
				if (Terreno[i][j].getTierra() == estado.getK()) {
					uniforme=true;
				}
			}
		}
		return uniforme;
	}

}
