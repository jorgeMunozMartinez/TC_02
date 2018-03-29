package Persistencia;

import java.util.ArrayList;

/**
 * 
 * Se indica la poscion X e Y actual asi como la tierra que hay en esa posicion
 * 
 * @author Jorge
 *
 * @version 1.0
 *
 */

public class Posicion {

	private int posX;
	private int posY;
	private int tierra;
	private ArrayList<Distribucion> listaDistribucion = new ArrayList<Distribucion>();
	private boolean visitado;

	public Posicion(int posX, int posY, int tierra, ArrayList<Distribucion> listaDistribucion) {
		this.posX = posX;
		this.posY = posY;
		this.tierra = tierra;
		this.listaDistribucion = listaDistribucion;
	}

	public ArrayList<Distribucion> getListaDistribucion() {
		return listaDistribucion;
	}

	public void setListaDistribucion(ArrayList<Distribucion> listaDistribucion) {
		this.listaDistribucion = listaDistribucion;
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

	public int getTierra() {
		return tierra;
	}

	public void setTierra(int tierra) {
		this.tierra = tierra;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	@Override
	public String toString() {
		return "[posX=" + posX + ", posY=" + posY + ", tierra=" + tierra + ", listaDistribucion="
				+ listaDistribucion + ", visitado=" + visitado + "]";
	}

	public boolean equals(Posicion pos) {
		Posicion p = pos;
		if (tierra == p.getTierra()) {
			return true;
		}
		return false;
	}
}
