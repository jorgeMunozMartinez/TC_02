package Persistencia;

public class Estado {

	private Posicion [][] terreno;
	private int posX;
	private int posY;
	private int V;
	private int k;
	private int max;
	
	public Estado(Posicion[][] terreno, int posX,int posY,int V, int k, int max) {
		this.terreno=terreno;
		this.posX=posX;
		this.posY=posY;
		this.V=V;
		this.k=k;
		this.max=max;
	}

	public Posicion[][] getTerreno() {
		return terreno;
	}

	public void setTerreno(Posicion[][] terreno) {
		this.terreno = terreno;
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
	
	
	
}
