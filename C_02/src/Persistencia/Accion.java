package Persistencia;
import java.util.ArrayList;

import org.w3c.dom.ls.LSInput;

/**
 * 
 * Una accion viene identificada por la posicion X e Y de la accion el coste de realizar la accion y una lista donde estan 
 * todas las posibles distribuciones causadas por la accion 
 * 
 * @author Jorge
 * 
 * @version 1.0
 *
 */

public class Accion {
	
	private int posX;
	private int posY;
	private int coste;//coste o tierra, depende de donde se usa 
	private ArrayList<Distribucion> listaDistribucion = new ArrayList<Distribucion>();
		
	public Accion(int posX, int posY, int coste, ArrayList<Distribucion> listaDistribucion) {
		this.posX = posX;
		this.posY = posY;
		this.coste = coste;
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
	public int getCoste() {
		return coste;
	}
	public void setCoste(int coste) {
		this.coste = coste;
	}
	public ArrayList<Distribucion> getListaDistribucion() {
		return listaDistribucion;
	}
	public void setListaDistribucion(ArrayList<Distribucion> listaDistribucion) {
		this.listaDistribucion = listaDistribucion;
	}
	public int getNumListDistrib() {
		return listaDistribucion.size();
	}
	public Distribucion getDist(int id) {
		return listaDistribucion.get(id);
	}
	@Override
	public String toString() {
		return "[posX=" + posX + ", posY=" + posY + ", coste=" + coste + ", listaDistribucion="
				+ listaDistribucion + "]";
	}
	
	
}
