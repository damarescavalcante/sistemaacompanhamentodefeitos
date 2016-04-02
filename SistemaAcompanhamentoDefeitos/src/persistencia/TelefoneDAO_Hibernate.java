package persistencia;

import java.util.ArrayList;

import logica.Funcionario;
import logica.Telefone;

public class TelefoneDAO_Hibernate implements TelefoneDAO {

	@Override
	public boolean atualizarTelefone(int matriculaFunc, String numeroAntigo, String numeroNovo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Telefone buscarTelefone(int matriculaFunc, String numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Telefone> buscarTelefone(int matriculaFunc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean adicionarTelefone(Funcionario f, ArrayList<Telefone> telefones) {
		// TODO Auto-generated method stub
		return false;
	}

}
