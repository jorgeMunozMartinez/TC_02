package Persistencia;
/**
 * 
 * Clase se encraga de decir cual posicion y cuanta tierra se movera
 *  
 * @author Jorge
 * 
 * @version 1.0
 *
 */

public class Distribucion {
	
	private int posX;
	private int posY;
	private int arena;
	
	public Distribucion(int posX, int posY, int arena) {
		this.posX = posX;
		this.posY = posY;
		this.arena = arena;
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

	public int getArena() {
		return arena;
	}

	public void setArena(int arena) {
		this.arena = arena;
	}

	@Override
	public String toString() {
		return "[posX=" + posX + ", posY=" + posY + ", arena=" + arena + "]";
	}
	
	

}
