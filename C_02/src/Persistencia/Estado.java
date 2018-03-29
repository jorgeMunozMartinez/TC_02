package Persistencia;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * 
 * En esta clase se crean los objetos estado que tienen posicion X, Y, k (minimo de tierra por posicion), 
 * max (el maximo de tierra por posicion) y una matriz posicion (el terreno)
 * 
 * @author Jorge
 * 
 * @version 1.0
 *
 */
public class Estado implements Cloneable {

	private int x;
	private int y;
	private int V;
	private int k;
	private int max;
	private int PosX;
	private int PosY;
	private boolean repartido;
	private Posicion Terreno[][];
	
	public Estado (ArrayList<Integer> datos,Posicion Terreno[][],int PosX, int PosY) {
		this.x=datos.get(0);
		this.y=datos.get(1);
		this.V=datos.get(4);
		this.k=datos.get(3);
		this.max=datos.get(2);
		this.Terreno=Terreno;
		this.PosX=PosX;
		this.PosY=PosY;
		repartido=false;
	}

	public Posicion[][] getTerreno() {
		return Terreno;
	}
	public void setTerreno(Posicion[][] terreno) {
		Terreno = terreno;
	}
	public int getX() {
		return x;
	}

	public void setX(int posX) {
		this.x = posX;
	}

	public int getY() {
		return y;
	}

	public void setY(int posY) {
		this.y = posY;
	}

	public int getV() {
		return V;
	}

	public void setV(int v) {
		V = v;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
		
	public int getPosX() {
		return PosX;
	}

	public void setPosX(int posX) {
		PosX = posX;
	}

	public int getPosY() {
		return PosY;
	}

	public void setPosY(int posY) {
		PosY = posY;
	}

	public boolean isRepartido() {
		return repartido;
	}

	public void setRepartido(boolean repartido) {
		this.repartido = repartido;
	}
	
	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + ", V=" + V + ", k=" + k + ", max=" + max + ", TractorX=" + PosX + ", TractorY="
				+ PosY + ", repartido=" + repartido + "]";
	}

	public boolean sonIguales(Estado e) {
		boolean iguales = true;
		if ((e.getPosX()!= getPosX()) || (e.getPosY() != getPosY()))
			iguales = false;
		for (int i = 0; i < getTerreno().length || !iguales; i++) {
			for (int j = 0; j < getTerreno().length || !iguales; j++) {
				iguales = getTerreno()[i][j].equals(e.getTerreno()[i][j]);
			}
		}
		return iguales;
	}
	
	public String convertirCadena() {
		String cadena="";
		for (int i = 0; i < Terreno.length; i++) {
			for (int j = 0; j < Terreno.length; j++) {
				cadena=cadena+ (char)Terreno[i][j].getTierra();
			}
		}
		cadena=cadena+ PosX;
		cadena=cadena+ PosY;
		return cadena;
	}
	
	public ArrayList<Distribucion> getMovimientos(){
		return Terreno[x][y].getListaDistribucion();
	}
	public int CalculoHeuristica() {
		/**
		 * calculo de heuristica: las casillas que no tiene la "K" deseada
		 */
		int heuristica = 0;
		for (int i = 0; i < Terreno.length; i++) {
			for (int j = 0; j < Terreno[i].length; j++) {
				if (Terreno[i][j].getTierra() != k) {
					heuristica = heuristica + 1;
				}
			}
		}
		return heuristica;
	}
	
	public Estado Clone() {
		try {
		  Estado clonmalefico = (Estado) super.clone();
	         return clonmalefico;
		}catch(Exception e) {
			System.out.println("Error clonado Estado");
			return null;
		}
	}
}
