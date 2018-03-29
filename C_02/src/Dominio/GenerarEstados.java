package Dominio;

import java.util.ArrayList;
import Persistencia.Accion;
import Persistencia.Distribucion;
import Persistencia.Estado;
import Persistencia.Posicion;

/**
 * 
 * Genera todas las posibles combinaciones de los estados
 * 
 * @author Jorge
 *
 * @version 1.0
 * 
 */

public class GenerarEstados {

	private Posicion[][] Terreno;
	private Estado estado;

	public GenerarEstados(ArrayList<Integer> datos,int posX,int posY,Estado estado) {
		this.estado=estado;
		Terreno=estado.getTerreno();
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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

	public boolean ProbarLimiteDeTierra(int cantidadTierra, Distribucion posicion) {
		/**
		 * Comprueba si es posible es reparticion de tierra sin superar el maximo
		 */
		if ((cantidadTierra + posicion.getArena()) > estado.getMax()) {
			return false;
		} else {
			return true;
		}
	}

	public void BackPosiblesAcciones(int etapa, ArrayList<Distribucion> posValidas, ArrayList<Distribucion> distribuciones,
			ArrayList<Accion> acciones) {
		/**
		 * Genera las acciones posibles asociadoas a un estado
		 */
		if (etapa == posValidas.size()) {	
			if (ComprobarPosibleAccion(CalcularTierraSobrante(), distribuciones)) {
				ArrayList<Distribucion> nuevaDistribucion = new ArrayList<Distribucion>(distribuciones);
				Accion nuevaAccion = new Accion(posValidas.get(etapa - 1).getPosX(), posValidas.get(etapa - 1).getPosY(), 1,
						nuevaDistribucion);
				CostoAccion(nuevaAccion);
				acciones.add(nuevaAccion);		
			}
		} else {
			for (int i = 0; i <= CalcularTierraSobrante(); i++) {
				if (ProbarLimiteDeTierra(i, posValidas.get(etapa))) {
					Distribucion distribucion = new Distribucion(posValidas.get(etapa).getPosX(),
							posValidas.get(etapa).getPosY(), i);
					distribuciones.add(etapa,distribucion);
					BackPosiblesAcciones(etapa + 1, posValidas, distribuciones, acciones);
					distribuciones.remove(etapa);
				}
			}
		}
	}
	
	public void accionesPosibles(ArrayList<Accion> listaAcciones, ArrayList<Distribucion> posicionesValidas) {
		/**
		 * genera las acciones posibles, para cada posible posicion copia los generado en el backtracking
		 */
		int fila;
		int columna;
		int sizeInicial=listaAcciones.size()-1;
		for(int i=0;i<posicionesValidas.size();i++) {
			fila=posicionesValidas.get(i).getPosX();
			columna=posicionesValidas.get(i).getPosY();
			for(int h=0;h<sizeInicial;h++) {
				Accion a = new Accion(listaAcciones.get(h).getPosX(),listaAcciones.get(h).getPosY(),listaAcciones.get(h).getCoste(),listaAcciones.get(h).getListaDistribucion());
				a.setPosX(fila);
				a.setPosY(columna);
				listaAcciones.add(a);
			}
		}
	}

	public boolean RepartoUniforme() {
		/**
		 * Comprueba si la totalidad de la tierra es "k"
		 */
		boolean uniforme=false;
		for (int i = 0; i < Terreno.length; i++) {
			for (int j = 0; j < Terreno[i].length; j++) {
				if (Terreno[i][j].getTierra() != estado.getK()) {
					uniforme=false;				
				}else {
					estado.setRepartido(true);
					uniforme=true;
				}
			}
		}
		return uniforme;
	}
	
	public void realizarAccion(Accion a,Estado e) {
		/**
		 * realiza una accion, mueve el tractor y reparte la tierra
		 */
		int fila;
		int columna;
		int arena;
		for(int i=0;i<a.getListaDistribucion().size();i++) {
			fila=a.getListaDistribucion().get(i).getPosX();
			columna=a.getListaDistribucion().get(i).getPosY();
			arena=a.getListaDistribucion().get(i).getArena();
			System.out.println(arena);
			e.getTerreno()[fila][columna].setTierra(e.getTerreno()[fila][columna].getTierra()+arena);
		}
		Posicion [][]terreno = e.getTerreno();
		terreno[e.getPosX()][e.getPosY()].setTierra(e.getK());
		//e.getTerreno()[e.getPosX()][e.getPosY()].setTierra(e.getTerreno()[e.getPosX()][e.getPosY()].getTierra()-arenaRestante);
		e.setTerreno(terreno);
		e.setPosX(a.getPosX());
		e.setPosY(a.getPosY());
		String[][] TerrenoString=CopiarTerreno2(e);
		MostrarTerrenoTractor(e.getPosX(), e.getPosY(),TerrenoString);
		System.out.println(e.toString());
	}
	
	public String[][] CopiarTerreno(Posicion Terreno[][], String TerrenoString[][],ArrayList<Integer>datos) {
		/**
		 * Copia los datos de los objetos del terreno a un String
		 */
		TerrenoString= new String[datos.get(0)][datos.get(1)];
		for (int i = 0; i < Terreno.length; i++) {
			for (int j = 0; j < Terreno[i].length; j++) {
				TerrenoString[i][j] = "" + Terreno[i][j].getTierra();
			}
		}
		return TerrenoString;
	}
	
	public String[][] CopiarTerreno2(Estado e) {
		/**
		 * Otro metodo de copiar el terreno
		 */
		String [][] terrenoString=new String[e.getX()][e.getY()];
		for (int i = 0; i < e.getTerreno().length; i++) {
			for (int j = 0; j < e.getTerreno()[i].length; j++) {
				terrenoString[i][j] = "" + e.getTerreno()[i][j].getTierra();
			}
		}
		return terrenoString;
	}
	
	public void MostrarTerrenoTractor( int X, int Y,String[][] TerrenoString) {
		System.out.println("--Terreno con posicion del tractor--");
		for (int i = 0; i < TerrenoString.length; i++) {
			System.out.print("|");
			for (int j = 0; j < TerrenoString[i].length; j++) {
				if (i == X && j == Y) {
					if (TerrenoString[i][j].length() == 1) {
						System.out.print(" |" + TerrenoString[i][j] + "| ");
					} else {
						System.out.print("|" + TerrenoString[i][j] + " |");
					}
				} else {
					if (TerrenoString[i][j].length() == 1) {
						System.out.print("  " + TerrenoString[i][j] + "  ");
					} else {
						System.out.print(" " + TerrenoString[i][j] + "  ");
					}
				}
			}
			System.out.println("|");
		}
	}

}
