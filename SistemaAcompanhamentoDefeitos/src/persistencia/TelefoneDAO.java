package persistencia;

import java.util.ArrayList;

import logica.Funcionario;
import logica.Telefone;

public interface TelefoneDAO {

	Telefone buscarTelefone(int matriculaFunc, String numero);
	
	ArrayList<Telefone> buscarTelefone(int matriculaFunc);

	boolean atualizarTelefone(int matriculaFunc, String numeroAntigo, String numeroNovo);
	
	boolean adicionarTelefone (Funcionario f, ArrayList<Telefone> telefones);

}
