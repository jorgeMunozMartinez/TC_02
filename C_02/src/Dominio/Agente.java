package Dominio;

import java.util.ArrayList;
import java.util.Scanner;
import Persistencia.EspacioDeEstados;
import Persistencia.Estado;
import Persistencia.Ficheros;
import Persistencia.Nodo;
import Persistencia.Posicion;

/**
 * 
 * En este metodo se llama para la creacion del terreno mediante fichero o
 * aleatoriamente, tambien se define que estrategia se quiere usar para resolver
 * el problema
 * 
 * @author Jorge
 *
 * @version 1.0
 *
 */

public class Agente {

	private EspacioDeEstados espacioEstados = new EspacioDeEstados();
	private GenerarProblema problema = null;
	
	public Agente() {
		try {
		Operaciones();
		}catch (Exception e) {
			System.out.println(e.toString());
			Operaciones();
		}
	}
	
	public void Operaciones() {
		/**
		 * En este metodo dependiendo de la forma de lectura del fichero se crea un
		 * terreno con los parámetros leidos en un metedo GenerarEstados o generarlos de
		 * manera aleatoria
		 */
		ArrayList<Integer> contenido = new ArrayList<Integer>();
		Ficheros lecturaEscritura = new Ficheros();
		lecturaEscritura.BorrarFicheroSolucion();	
		Posicion[][] terreno = null;
		Estado estado = null;
		GenerarTerreno generado = null;
		switch (PeticionFormatoEntradaDatos()) {
		case 1:
			System.out.println("--> Datos leidos por fichero");
			contenido = lecturaEscritura.LecturaFicheroTerrenoPrefijado();
			generado = new GenerarTerreno(contenido);
			terreno = generado.GenerarElTerreno();
			generado.MostrarTerreno(terreno);
			estado = new Estado(contenido, terreno, 0, 0);
			problema = new GenerarProblema(espacioEstados, estado, contenido);
			MenusEstrategias(problema, contenido);
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
			generado = new GenerarTerreno(contenido);
			terreno = generado.GenerarElTerreno();
			generado.MostrarTerreno(terreno);
			estado = new Estado(contenido, terreno, 0, 0);
			problema = new GenerarProblema(espacioEstados, estado, contenido);
			MenusEstrategias(problema, contenido);
			break;
		}
	}

	public int PeticionFormatoEntradaDatos() {
		/**
		 * En este metodo se selecciona la forma en la que se leeran los datos del
		 * terreno
		 */
		int formato = 0;
		Scanner TECLADO = new Scanner(System.in);
		try {
			System.out.println("--------------------");
			System.out.println(
					"Seleccione la foma de ejecutar el programa: \n Opcion 1: Datos leidos por fichero \n Opcion 2: Datos generados de manera aleatoria");
			formato = TECLADO.nextInt();
			if (formato < 1 || formato > 2) {
				System.out.println("**Error con los valores de entrada, parámetos permitidos 1, 2**\n");
				Operaciones();
			}
		} catch (Exception e) {
			System.out.println("**Error con los valores de entrada, parámetos permitidos 1, 2**\n");
			Operaciones();
		}
		return formato;
	}

	public void MenusEstrategias(GenerarProblema problema, ArrayList<Integer> contenido) {
		/**
		 * En este metodo se selecciona cual tipo de estrategia se usará. Para cada caso
		 * se retorna un Nodo "nodoSolucion", dependiendo de su valor o no tiene
		 * solución o se llamara a la clase generarProblema para que devuelvan un
		 * conjunto de nodos que seran la solucion para la estrategia seleccionada.
		 */
		Scanner TECLADO = new Scanner(System.in);
		int profundidadMaxima = 99999999;
		Nodo nodoSolucion = null;
		boolean solucion = false;
		ArrayList<Nodo> nodoCaminos = null;
		int opcion = 0;
		while (!solucion) {
			try {
				System.out.println("----Estrategias disponibles----");
				System.out.println(
						" 1-Prondidad Simple \n 2-Profundidad Acotada \n 3-Anchura \n 4-Costo Uniforme \n 5-Asterisco");
				opcion = TECLADO.nextInt();
				switch (opcion) {
				case 1:
					System.out.println("---Profundidad Simple---");
					System.out.println("Posicion del tractor: ("+problema.getEstado().getPosX()+", "+problema.getEstado().getPosY()+")");
					solucion = true;
					nodoSolucion = problema.RealizarBusqueda(1, profundidadMaxima);
					break;
				case 2:
					System.out.println("---Profundidad acotada---");
					solucion = true;
					nodoSolucion = problema.RealizarBusqueda(2, profundidadMaxima);
					break;
				case 3:
					System.out.println("---Anchura---");
					solucion = true;
					nodoSolucion = problema.RealizarBusqueda(3, profundidadMaxima);
					break;
				case 4:
					System.out.println("---Costo Uniforme---");
					solucion = true;
					nodoSolucion = problema.RealizarBusqueda(4, profundidadMaxima);
					break;
				case 5:
					System.out.println("---Asterisco---");
					solucion = true;
					nodoSolucion = problema.RealizarBusqueda(5, profundidadMaxima);
					break;
				default:
					System.out.println(opcion);
					System.out.println("**Error con los valores de entrada, parámetos permitidos 1, 2, 3, 4, 5**\n");
					MenusEstrategias(problema, contenido);
					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("**Error con los valores de entrada, parámetos permitidos 1, 2, 3, 4, 5**\n");
				MenusEstrategias(problema, contenido);
			}
		}
		if (nodoSolucion == null) {
			System.out.println("***---Cota limite superado o sin solucion ---***");
		} else {
			nodoCaminos = problema.resultado(nodoSolucion);
			problema.mostarSolucion(nodoCaminos);
		}

	}
}
