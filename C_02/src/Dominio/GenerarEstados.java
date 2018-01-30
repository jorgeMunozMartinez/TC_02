package Dominio;

import java.util.ArrayList;

import Persistencia.Accion;
import Persistencia.Ficheros;

public class GenerarEstados {
	
	private Accion [][]Terreno;
	private String [][]TerrenoString;
	GenerarTerreno generando = new GenerarTerreno();
	Ficheros fichero = new Ficheros();
	
	public GenerarEstados(ArrayList<Integer> datos) {
		Terreno=generando.GenerarElTerreno(datos);
		TerrenoString=generando.CopiarTerreno(Terreno, TerrenoString);
		generando.MostrarTerrenoTractor(TerrenoString, 0, 0);
	}
	
	public void CostoAccion(Accion acion) {
		
	}

}
