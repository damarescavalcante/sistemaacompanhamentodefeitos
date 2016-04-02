package persistencia;

import java.util.ArrayList;

import logica.Entrada;

public interface HistoricoDAO {

	ArrayList<Entrada> consultarHistoricoEntradas (int codProblema);
	
	boolean removerHistorico (int codHistorico);
	
}
