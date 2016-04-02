package persistencia;

import java.util.ArrayList;

import logica.Entrada;
import logica.Problema;

public class ProblemaDAO_Hibernate implements ProblemaDAO {

	@Override
	public boolean cadastrarProblema(Problema p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizarDescricao(int codProduto, String descricao) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean encerrarProblema(int codProblema) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Entrada> consultarHistorico(int codProblema) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Problema buscarProblema(int codProblema) {
		// TODO Auto-generated method stub
		return null;
	}

}
