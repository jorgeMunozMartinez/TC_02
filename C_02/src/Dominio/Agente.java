package Dominio;

import Persistencia.EspacioDeEstados;
import Persistencia.Estado;
import Persistencia.Problema;

public class Agente {

	Estado estado = new Estado(null,null);
	EspacioDeEstados espacioEstados = new EspacioDeEstados();
	
	public Agente() {
		Menus m = new Menus();
		GenerarProblema problema = new GenerarProblema(espacioEstados,estado);
		m.MenusEstrategias(problema);
		
	}
}
