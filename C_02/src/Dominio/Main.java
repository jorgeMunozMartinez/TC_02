package Dominio;

import java.util.ArrayList;
import java.util.Scanner;

import Persistencia.Ficheros;

public class Main {
	public static void main(String[] args) {
		Menu();
	}

	public static int PeticionFormatoEntradaDatos() {
		int formato = 0;
		Scanner TECLADO = new Scanner(System.in);
		try {
			System.out.println("--------------------");
			System.out.println(
					"Seleccione la foma de ejecutar el programa: \n Opcion 1: Datos leidos por fichero \n Opcion 2: Datos generados de manera aleatoria");
			formato = TECLADO.nextInt();
			if (formato < 1 || formato > 2) {
				System.out.println("**Error con los valores de entrada, parámetos permitidos 1, 2**\n");
				PeticionFormatoEntradaDatos();
			}
		} catch (Exception e) {
			System.out.println("**Error con los valores de entrada, parámetos permitidos 1, 2**\n");
			PeticionFormatoEntradaDatos();
		}
		return formato;
	}

	
	public static void Menu() {
		ArrayList<Integer> contenido = new ArrayList<Integer>();
		Ficheros lecturaEscritura= new Ficheros();
		GenerarTerreno generando = new GenerarTerreno();
		lecturaEscritura.BorrarFicheroSolucion();
		switch(PeticionFormatoEntradaDatos()) {
		case 1:
			System.out.println("--> Datos leidos por fichero");
			contenido=lecturaEscritura.LecturaFicheroTerrenoPrefijado();
			generando.GenerarElTerreno(contenido);
			break;
		case 2:
			System.out.println("--> Datos generados aleatoriamente");
			int X = (int) (Math.random() * 2) + 4;
			contenido.add(X);
			System.out.println("	Número de filas del terreno: "+X);
			int Y =(int) (Math.random() * 2) + 4;
			contenido.add(Y);
			System.out.println("	Número de columnas del terreno: "+Y);
			int maximo =(int) (Math.random() * 9) + 1;
			contenido.add(maximo);
			System.out.println("	Valor de tierra máximo en el terreno: "+maximo);
			int k =(int) (Math.random() * (maximo-1)) + 1;
			contenido.add(k);
			System.out.println("	Valor de tierra mínimo en el terreno: "+k);
			int v = X * Y * k;
			contenido.add(v);
			System.out.println("	Tierra total del terreno: "+v);
			generando.GenerarElTerreno(contenido);
			break;
		}
	}
}