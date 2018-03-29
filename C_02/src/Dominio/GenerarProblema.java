package Dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import Persistencia.EspacioDeEstados;
import Persistencia.Estado;
import Persistencia.Frontera;
import Persistencia.Nodo;
import Persistencia.Sucesor;

public class GenerarProblema {

	private Estado estadoInicial;
	private EspacioDeEstados espacioEstados;
	private GenerarEstados estados = null;

	public GenerarProblema(EspacioDeEstados espacioEstados, Estado estadoInicial, ArrayList<Integer> contenido) {
		this.estadoInicial = estadoInicial;
		this.espacioEstados = espacioEstados;
		estados = new GenerarEstados(contenido, estadoInicial.getPosX(), estadoInicial.getPosY(), estadoInicial);
		mostarEstados(estadoInicial,estados);
	}

	public void mostarEstados(Estado e,GenerarEstados estados) {
		String [][]TerrenoString=null;
		TerrenoString=estados.CopiarTerreno2(e);
		estados.MostrarTerrenoTractor(e.getPosX(), e.getPosY(), TerrenoString);
	}

	public Estado getEstado() {
		return estadoInicial;
	}

	public Nodo RealizarBusqueda(int estrategia, int profundidadMaxima) {
		/**
		 * Metodo que realiza las busquedas dependiendo de la estrategia
		 */
		Nodo padre = null;
		try {
			Map<String, Integer> codigos = new HashMap<>();
			Frontera frontera = new Frontera();
			padre = new Nodo(0, 0, estadoInicial, null, null, 0);
			Nodo nodoComparar = null;
			Serializar serial = new Serializar();
			ArrayList<Sucesor> listaSucesores = new ArrayList<Sucesor>();
			boolean solucion = false;
			int valor = 0;
			int cota = 30;
			int profundidadAcotada = cota;
			String id = serial.encriptarMD5(estadoInicial.convertirCadena());
			codigos.put(id, padre.getValor());
			frontera.insertarNodo(padre);
			if (estrategia == 5) {
				padre.setValor(estadoInicial.CalculoHeuristica());
			}
			while (!solucion && !frontera.esVacia()) {
				nodoComparar = frontera.eliminarNodo();
				if (nodoComparar.getEstado().isRepartido()) {
					solucion = true;
				} else if (nodoComparar.getProfundidad() <= profundidadMaxima) {
					listaSucesores = espacioEstados.obtenerSucesores(estados, nodoComparar);
					for (int i = 0; i < listaSucesores.size(); i++) {
						switch (estrategia) {
						case 1:
							// profuncidad simple
							valor = (profundidadMaxima - (nodoComparar.getProfundidad() + 1) * (-1));
							break;
						case 2:
							// profuncidad acotada
							if (profundidadAcotada <= profundidadMaxima) {
								valor = (profundidadMaxima - (nodoComparar.getProfundidad() + 1) * (-1));
							} else {
								frontera.limpiar();
								frontera.insertarNodo(padre);
								cota = cota + cota;
							}
							break;
						case 3:
							// anchura
							valor = nodoComparar.getProfundidad() + 1;
							break;
						case 4:
							// costo uniforme
							valor = listaSucesores.get(i).getCoste();
							break;
						case 5:
							// asterisco
							valor = listaSucesores.get(i).getCoste()
									+ listaSucesores.get(i).getEstado().CalculoHeuristica();
							break;
						}
						Nodo nodo = new Nodo(nodoComparar.getProfundidad() + 1, listaSucesores.get(i).getCoste(),
								listaSucesores.get(i).getEstado(), nodoComparar, listaSucesores.get(i).getAccion(),
								valor);
						id=serial.encriptarMD5(nodo.getEstado().convertirCadena());
						//comprueba si el id creado esta en la lista, si esta se prueba que tenga un valor menor el nodo, si es asi se mete
						//si el id no esta en la lista se mete
						if(codigos.containsKey(id)) {
							if(nodo.getValor()<codigos.get(id)){
								codigos.replace(id, nodo.getValor());
								frontera.insertarNodo(nodo);
							}
						}else {
							codigos.put(id, nodo.getValor());
							frontera.insertarNodo(nodo);
						}
					}

				}
			}
			if(solucion) {
				System.out.println("***Existe solución***");
				return nodoComparar;
			}else {
				System.out.println("***No existe solución***");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Realizando busqueda error");
			System.out.println(e.getMessage());
		}
		return padre;
	}

	public ArrayList<Nodo> resultado(Nodo nodo) {
		/**
		 * En este metodo mentras que el nodo leido no tenga padre se introduce en la
		 * lista de nodos y se comprueba con el pade del nodo actual
		 */
		ArrayList<Nodo> caminoNodos = new ArrayList<Nodo>();
		caminoNodos.add(nodo);
		while (nodo.getPadre() != null) {
			caminoNodos.add(nodo.getPadre());
			nodo = nodo.getPadre();
		}
		return caminoNodos;
	}

	public void mostarSolucion(ArrayList<Nodo> nodoCamino) {

	}
}
