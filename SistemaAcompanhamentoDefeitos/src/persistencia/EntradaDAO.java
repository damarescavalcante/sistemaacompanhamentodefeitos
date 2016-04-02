package persistencia;

import logica.Entrada;

public interface EntradaDAO {

	boolean registrarEntrada (Entrada e);
	
	Entrada buscarEntrada (int codEntrada);
	
	boolean removerEntrada (int codEntrada);
	
}
