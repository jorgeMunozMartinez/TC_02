package Persistencia;

import java.util.ArrayList;

public class Accion {

	private int X;
	private int Y;
	private int coste;
	private ArrayList<PosicionTerreno> distribuciones = new ArrayList<PosicionTerreno>();

	public Accion(int x, int y, int coste, ArrayList<PosicionTerreno> distribuciones) {
		X = x;
		Y = y;
		this.coste = coste;
		this.distribuciones = distribuciones;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public int getCoste() {
		return coste;
	}

	public void setCoste(int coste) {
		this.coste = coste;
	}

	public ArrayList<PosicionTerreno> getDistribuciones() {
		return distribuciones;
	}

	public void setDistribuciones(ArrayList<PosicionTerreno> distribuciones) {
		this.distribuciones = distribuciones;
	}
	
	public PosicionTerreno getDistribucion(int i) {
		return distribuciones.get(i);
	}

}
