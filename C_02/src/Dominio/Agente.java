package Dominio;

import Persistencia.EspacioDeEstados;
import Persistencia.Estado;
import Persistencia.Problema;

public class Agente {

	Estado estado = new Estado(null,0,0,0,0,0);
	EspacioDeEstados espacioEstados = new EspacioDeEstados();
	
	public Agente() {
		Menus m = new Menus();
		Problema problema = new Problema(espacioEstados,estado);
		m.MenusEstrategias(problema);
		
	}
}
