package Dominio;

import java.util.ArrayList;

import Persistencia.Distribucion;
import Persistencia.Posicion;

public class GenerarTerreno {

	private int filas;
	private int columnas;
	private int maximo;
	private int k;
	private int v;

	public Posicion[][] GenerarElTerreno(ArrayList<Integer> datosParaTerreno) {
		filas = datosParaTerreno.get(0);
		columnas = datosParaTerreno.get(1);
		maximo = datosParaTerreno.get(2);
		k = datosParaTerreno.get(3);
		v = filas * columnas * k;
		Posicion[][] Terreno = new Posicion[filas][columnas];
		GenerarVecinos(filas, columnas, Terreno);
		return Terreno;
	}

	public void GenerarVecinos(int filas, int columnas, Posicion[][] Terreno) {
		int aux = this.v;
		int cantidad_metida = 0;
		for (int i = 0; i < Terreno.length; i++) {
			for (int j = 0; j < Terreno[i].length; j++) {
				ArrayList<Distribucion> vecinos = GenerarTerrenosVecinos(i, j, filas, columnas);
				cantidad_metida = (int) (Math.random() * this.maximo + 1);
				if (aux - cantidad_metida > 0) {
					aux -= cantidad_metida;
					Posicion n = new Posicion(i, j, cantidad_metida, vecinos);
					Terreno[i][j] = n;
				} else if (aux - cantidad_metida < 0) {
					Posicion n = new Posicion(i, j, aux, vecinos);
					Terreno[i][j] = n;
					aux = 0;
				} else {
					Posicion n = new Posicion(i, j, 0, vecinos);
					Terreno[i][j] = n;
				}
			}
		}
	}

	public ArrayList<Distribucion> GenerarTerrenosVecinos(int X, int Y, int filas, int columnas) {
		ArrayList<Distribucion> vecinos = new ArrayList<Distribucion>();
		if (X < filas - 1) {
			Distribucion Inferior = new Distribucion(X + 1, Y, 0);
			vecinos.add(vecinos.size(), Inferior);
		}
		if (Y > 0) {
			Distribucion Izquierda = new Distribucion(X, Y - 1, 0);
			vecinos.add(vecinos.size(), Izquierda);
		}
		if (X > 0) {
			Distribucion Arriba = new Distribucion(X - 1, Y, 0);
			vecinos.add(vecinos.size(), Arriba);
		}
		if (Y < columnas - 1) {
			Distribucion Derecha = new Distribucion(X, Y + 1, 0);
			vecinos.add(vecinos.size(), Derecha);
		}
		return vecinos;
	}

	public String[][] CopiarTerreno(Posicion Terreno[][], String TerrenoString[][]) {
		TerrenoString= new String[filas][columnas];
		for (int i = 0; i < Terreno.length; i++) {
			for (int j = 0; j < Terreno[i].length; j++) {
				TerrenoString[i][j] = "" + Terreno[i][j].getTierra();
			}
		}
		return TerrenoString;
	}

	public void MostrarTerreno(Posicion[][] TerrenoString) {
		System.out.println("--Terreno--");
		for (int i = 0; i < TerrenoString.length; i++) {
			System.out.print("|");
			for (int j = 0; j < TerrenoString[i].length; j++) {		
					System.out.print(" " + TerrenoString[i][j].getTierra() + " ");
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
