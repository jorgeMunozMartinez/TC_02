package Persistencia;

import java.util.ArrayList;

public class Estado {

	private int posX;
	private int posY;
	private int V;
	private int k;
	private int max;
	private Posicion Terreno[][];
	
	public Estado (ArrayList<Integer> datos,Posicion Terreno[][]) {
		this.posX=datos.get(0);
		this.posY=datos.get(1);
		this.V=datos.get(4);
		this.k=datos.get(3);
		this.max=datos.get(2);
		this.Terreno=Terreno;
	}
	
	

	public Posicion[][] getTerreno() {
		return Terreno;
	}
	public void setTerreno(Posicion[][] terreno) {
		Terreno = terreno;
	}
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
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
	
}
