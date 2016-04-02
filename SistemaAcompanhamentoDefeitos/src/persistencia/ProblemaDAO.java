package persistencia;

import java.util.ArrayList;

import logica.Entrada;
import logica.Problema;

public interface ProblemaDAO {

	boolean cadastrarProblema(Problema p);

	boolean atualizarDescricao(int codProduto, String descricao);

	boolean encerrarProblema(int codProblema);

	ArrayList<Entrada> consultarHistorico(int codProblema);

	Problema buscarProblema(int codProblema);

}
