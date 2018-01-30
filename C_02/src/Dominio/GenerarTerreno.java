package Dominio;

import java.util.ArrayList;

import Persistencia.Accion;
import Persistencia.DistribucionTerreno;

public class GenerarTerreno {

	private int filas;
	private int columnas;
	private int maximo;
	private int k;
	private int v;

	public Accion[][] GenerarElTerreno(ArrayList<Integer> datosParaTerreno) {
		filas = datosParaTerreno.get(0);
		columnas = datosParaTerreno.get(1);
		maximo = datosParaTerreno.get(2);
		k = datosParaTerreno.get(3);
		v = filas * columnas * k;
		Accion[][] Terreno = new Accion[filas][columnas];
		GenerarVecinos(filas, columnas, Terreno);
		return Terreno;
	}

	public void GenerarVecinos(int filas, int columnas, Accion[][] Terreno) {
		int aux = this.v;
		int cantidad_metida = 0;
		for (int i = 0; i < Terreno.length; i++) {
			for (int j = 0; j < Terreno[i].length; j++) {
				ArrayList<DistribucionTerreno> vecinos = GenerarTerrenosVecinos(i, j, filas, columnas);
				cantidad_metida = (int) (Math.random() * this.maximo + 1);
				if (aux - cantidad_metida > 0) {
					aux -= cantidad_metida;
					Accion n = new Accion(i, j, cantidad_metida, vecinos);
					Terreno[i][j] = n;
				} else if (aux - cantidad_metida < 0) {
					Accion n = new Accion(i, j, aux, vecinos);
					Terreno[i][j] = n;
					aux = 0;
				} else {
					Accion n = new Accion(i, j, 0, vecinos);
					Terreno[i][j] = n;
				}
			}
		}
	}

	public ArrayList<DistribucionTerreno> GenerarTerrenosVecinos(int X, int Y, int filas, int columnas) {
		ArrayList<DistribucionTerreno> vecinos = new ArrayList<DistribucionTerreno>();
		if (X < filas - 1) {
			DistribucionTerreno Inferior = new DistribucionTerreno(X + 1, Y, 0);
			vecinos.add(vecinos.size(), Inferior);
		}
		if (Y > 0) {
			DistribucionTerreno Izquierda = new DistribucionTerreno(X, Y - 1, 0);
			vecinos.add(vecinos.size(), Izquierda);
		}
		if (X > 0) {
			DistribucionTerreno Arriba = new DistribucionTerreno(X - 1, Y, 0);
			vecinos.add(vecinos.size(), Arriba);
		}
		if (Y < columnas - 1) {
			DistribucionTerreno Derecha = new DistribucionTerreno(X, Y + 1, 0);
			vecinos.add(vecinos.size(), Derecha);
		}
		return vecinos;
	}

	public String[][] CopiarTerreno(Accion Terreno[][], String TerrenoString[][]) {
		TerrenoString= new String[filas][columnas];
		for (int i = 0; i < Terreno.length; i++) {
			for (int j = 0; j < Terreno[i].length; j++) {
				TerrenoString[i][j] = "" + Terreno[i][j].getCoste();
			}
		}
		return TerrenoString;
	}

	public void MostrarTerreno(Accion[][] TerrenoString) {
		System.out.println("--Terreno--");
		for (int i = 0; i < TerrenoString.length; i++) {
			System.out.print("|");
			for (int j = 0; j < TerrenoString[i].length; j++) {		
					System.out.print(" " + TerrenoString[i][j].getCoste() + " ");
			}
			System.out.println("|");
		}
	}

	public void MostrarTerrenoTractor(String[][] TerrenoString, int X, int Y) {
		System.out.println("--Terreno--");
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
