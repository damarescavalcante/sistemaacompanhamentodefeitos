package persistencia;

import logica.Funcionario;

public interface FuncionarioDAO {

	boolean cadastrarFuncionario (Funcionario f);
	
	boolean atualizarDados (int matriculaFunc, String tipoDado, String valor);
	
	boolean removerFuncionario (int matriculaFunc);
	
	Funcionario buscarFuncionario (int matriculaFunc);
		
}
