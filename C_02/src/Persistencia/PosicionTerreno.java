package Persistencia;

import java.util.ArrayList;

public class PosicionTerreno {
	private int X;
	private int Y;
	private int tierra;
	ArrayList<PosicionContiguaTerreno> NodosVecinos;
	
	public PosicionTerreno(int x, int y, int tierra,ArrayList<PosicionContiguaTerreno> nodosVecinos) {
		X = x;
		Y = y;
		this.tierra = tierra;
		NodosVecinos = nodosVecinos;
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

	public int getTierra() {
		return tierra;
	}

	public void setTierra(int tierra) {
		this.tierra = tierra;
	}

	public ArrayList<PosicionContiguaTerreno> getNodosVecinos() {
		return NodosVecinos;
	}

	public void setNodosVecinos(ArrayList<PosicionContiguaTerreno> nodosVecinos) {
		NodosVecinos = nodosVecinos;
	}

	@Override
	public String toString() {
		return "[Eje X=" + X + ", eje Y=" + Y + ", tierra=" + tierra + "]";
	}
	 
	

}
