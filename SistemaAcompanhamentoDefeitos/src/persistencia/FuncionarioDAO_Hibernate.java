package persistencia;

import logica.Funcionario;

public class FuncionarioDAO_Hibernate implements FuncionarioDAO{

	@Override
	public boolean cadastrarFuncionario(Funcionario f) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizarDados(int matriculaFunc, String tipoDado, String valor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerFuncionario(int matriculaFunc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Funcionario buscarFuncionario(int matriculaFunc) {
		// TODO Auto-generated method stub
		return null;
	}

}
