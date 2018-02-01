package Dominio;
/**
 *
 *Contiene los menus que se usan en la relizacion de la practica 
 * 
 * @author Jorge
 * 
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.Scanner;

import Persistencia.Ficheros;
import Persistencia.Problema;

public class Menus {

	public int PeticionFormatoEntradaDatos() {
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

	public Menus() {
		ArrayList<Integer> contenido = new ArrayList<Integer>();
		Ficheros lecturaEscritura = new Ficheros();
		lecturaEscritura.BorrarFicheroSolucion();
		GenerarEstados estado = null;
		switch (PeticionFormatoEntradaDatos()) {
		case 1:
			System.out.println("--> Datos leidos por fichero");
			contenido = lecturaEscritura.LecturaFicheroTerrenoPrefijado();
			estado = new GenerarEstados(contenido);
			break;
		case 2:
			System.out.println("--> Datos generados aleatoriamente");
			int X = (int) (Math.random() * 2) + 4;
			contenido.add(X);
			System.out.println("	Número de filas del terreno: " + X);
			int Y = (int) (Math.random() * 2) + 4;
			contenido.add(Y);
			System.out.println("	Número de columnas del terreno: " + Y);
			int maximo = (int) (Math.random() * 9) + 1;
			contenido.add(maximo);
			System.out.println("	Valor de tierra máximo en el terreno: " + maximo);
			int k = (int) (Math.random() * (maximo - 1)) + 1;
			contenido.add(k);
			System.out.println("	Valor de tierra mínimo en el terreno: " + k);
			int v = X * Y * k;
			contenido.add(v);
			System.out.println("	Tierra total del terreno: " + v);
			estado = new GenerarEstados(contenido);
			break;
		}
	}

	public void MenusEstrategias(Problema problema) {
		Scanner TECLADO = new Scanner(System.in);
		int opcion = 1;
		try {
			System.out.println("----Estrategias disponibles----");
			System.out.println(
					" 1-Prondidad Simple \n 2-Profundidad Acotada \n 3-Anchura \n 4-Costo Uniforme \n 5-Asterisco");
			opcion = TECLADO.nextInt();
			switch (opcion) {
			case 1:	
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default:
				System.out.println("**Error con los valores de entrada, parámetos permitidos 1, 2, 3, 4, 5**\n");
				MenusEstrategias(problema);
				break;
			}
		} catch (Exception e) {
			System.out.println("**Error con los valores de entrada, parámetos permitidos 1, 2, 3, 4, 5**\n");
			MenusEstrategias(problema);
		}
		
	}
}
