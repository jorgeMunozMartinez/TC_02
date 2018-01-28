package Dominio;

import java.util.ArrayList;

import Persistencia.PosicionContiguaTerreno;
import Persistencia.PosicionTerreno;

public class GenerarTerreno {

	private int filas;
	private int columnas;
	private int maximo;
	private int k;
	private int v;

	public PosicionTerreno[][] GenerarElTerreno(ArrayList<Integer> datosParaTerreno) {
		filas = datosParaTerreno.get(0);
		columnas = datosParaTerreno.get(1);
		maximo = datosParaTerreno.get(2);
		k = datosParaTerreno.get(3);
		v = filas * columnas * k;
		PosicionTerreno[][] Terreno = new PosicionTerreno[filas][columnas];
		String[][] TerrenoString = new String[filas][columnas];
		GenerarVecinos(filas, columnas, Terreno);
		CopiarTerreno(Terreno, TerrenoString);
		MostrarTerreno(TerrenoString);
		return Terreno;
	}

	public void GenerarVecinos(int filas, int columnas, PosicionTerreno[][] Terreno) {
		int aux = this.v;
		int cantidad_metida = 0;
		for (int i = 0; i < Terreno.length; i++) {
			for (int j = 0; j < Terreno[i].length; j++) {
				ArrayList<PosicionContiguaTerreno> vecinos = GenerarTerrenosVecinos(i, j, filas, columnas);
				cantidad_metida = (int) (Math.random() * this.maximo + 1);
				if (aux - cantidad_metida > 0) {
					aux -= cantidad_metida;
					PosicionTerreno n = new PosicionTerreno(i, j, cantidad_metida, vecinos);
					Terreno[i][j] = n;
				} else if (aux - cantidad_metida < 0) {
					PosicionTerreno n = new PosicionTerreno(i, j, aux, vecinos);
					Terreno[i][j] = n;
					aux = 0;
				} else {
					PosicionTerreno n = new PosicionTerreno(i, j, 0, vecinos);
					Terreno[i][j] = n;
				}
			}
		}
	}

	public ArrayList<PosicionContiguaTerreno> GenerarTerrenosVecinos(int X, int Y, int filas, int columnas) {
		ArrayList<PosicionContiguaTerreno> vecinos = new ArrayList<PosicionContiguaTerreno>();
		if (X < filas - 1) {
			PosicionContiguaTerreno Inferior = new PosicionContiguaTerreno(X + 1, Y);
			vecinos.add(vecinos.size(), Inferior);
		}
		if (Y > 0) {
			PosicionContiguaTerreno Izquierda = new PosicionContiguaTerreno(X, Y - 1);
			vecinos.add(vecinos.size(), Izquierda);
		}
		if (X > 0) {
			PosicionContiguaTerreno Arriba = new PosicionContiguaTerreno(X - 1, Y);
			vecinos.add(vecinos.size(), Arriba);
		}
		if (Y < columnas - 1) {
			PosicionContiguaTerreno Derecha = new PosicionContiguaTerreno(X, Y + 1);
			vecinos.add(vecinos.size(), Derecha);
		}
		return vecinos;
	}

	public void CopiarTerreno(PosicionTerreno Terreno[][], String TerrenoString[][]) {
		for (int i = 0; i < Terreno.length; i++) {
			for (int j = 0; j < Terreno[i].length; j++) {
				TerrenoString[i][j] = "" + Terreno[i][j].getTierra();
			}
		}
	}

	public void MostrarTerreno(String[][] TerrenoString) {
		System.out.println("Terreno");
		for (int i = 0; i < TerrenoString.length; i++) {
			System.out.print("|");
			for (int j = 0; j < TerrenoString[i].length; j++) {

				if (TerrenoString[i][j].length() == 1) {
					System.out.print(" |" + TerrenoString[i][j] + "| ");
				} else {
					System.out.print("|" + TerrenoString[i][j] + " |");
				}
			}

			System.out.println("|");
		}
	}

}
