package persistencia;

import logica.Funcionario;

public class FuncionarioDAO_Hibernate implements FuncionarioDAO {

	private BancoSingleton banco = BancoSingleton.getInstance();
	private String sql;

	@Override
	public boolean cadastrarFuncionario(Funcionario f) {

		try {
			
			Funcionario func = buscarFuncionario(f.getNome(), f.getCep());
			banco.criarSessao();
			if (func == null) {
				banco.comitarObjetoSalvo(f);
				return true;
			}

			else {
				return false;
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		finally {
			banco.fecharSessao();
		}
	}

	@Override
	public boolean atualizarDados(int matricula, String tipoDado, String valor) {

		try {

			if (buscarFuncionario(matricula) != null) {

				System.out.println(buscarFuncionario(matricula));
				if (tipoDado.equalsIgnoreCase("funcao")) {
					return atualizarFuncao(matricula, valor);
				}

				else if (tipoDado.equalsIgnoreCase("rua")) {
					return atualizarRua(matricula, valor);
				}

				else if (tipoDado.equalsIgnoreCase("bairro")) {
					return atualizarBairro(matricula, valor);
				}

				else if (tipoDado.equalsIgnoreCase("cep")) {
					return atualizarCep(matricula, valor);
				}

				else if (tipoDado.equalsIgnoreCase("cidade")) {
					return atualizarCidade(matricula, valor);
				}

				else {
					return false;
				}

			}

			else {
				return false;
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	@Override
	public boolean removerFuncionario(int matriculaFunc) {

		try {

			if (buscarFuncionario(matriculaFunc) != null) {
				banco.criarSessao();
				sql = "SELECT f FROM Funcionario f WHERE f.matricula='" + matriculaFunc + "'";
				Funcionario f = (Funcionario) banco.recuperarObjeto(sql);

				banco.removeHibernate(f);
				return true;

			}

			else {
				return false;
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		finally {
			banco.fecharSessao();
		}

	}

	@Override
	public Funcionario buscarFuncionario(int matriculaFunc) {

		try {
			banco.criarSessao();
			sql = "SELECT f FROM Funcionario f WHERE f.matricula='" + matriculaFunc + "'";
			Funcionario func = (Funcionario) banco.recuperarObjeto(sql);

			if (func != null) {
				return func;
			}

			else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

		finally {
			banco.fecharSessao();
		}

	}

	public Funcionario buscarFuncionario(String nome, String cep) {

		try {
			banco.criarSessao();
			sql = "SELECT f FROM Funcionario f WHERE f.nome='" + nome + "' and f.cep='" + cep + "'";
			Funcionario func = (Funcionario) banco.recuperarObjeto(sql);

			if (func != null) {
				return func;
			}

			else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

		finally {
			banco.fecharSessao();
		}

	}

	private boolean atualizarRua(int matricula, String rua) {

		try {
			Funcionario f = buscarFuncionario(matricula);

			banco.criarSessao();
			f.setRua(rua);
			banco.updateHibernate(f);
			return true;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		finally {
			banco.fecharSessao();
		}

	}

	private boolean atualizarBairro(int matricula, String bairro) {

		try {
			Funcionario f = buscarFuncionario(matricula);

			banco.criarSessao();
			f.setBairro(bairro);
			banco.updateHibernate(f);
			return true;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		finally {
			banco.fecharSessao();
		}

	}

	private boolean atualizarCep(int matricula, String cep) {

		try {
			Funcionario f = buscarFuncionario(matricula);
			banco.criarSessao();
			f.setCep(cep);
			banco.updateHibernate(f);
			return true;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		finally {
			banco.fecharSessao();
		}

	}

	private boolean atualizarCidade(int matricula, String cidade) {

		try {
			Funcionario f = buscarFuncionario(matricula);

			banco.criarSessao();
			f.setCidade(cidade);
			banco.updateHibernate(f);
			return true;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		finally {
			banco.fecharSessao();
		}

	}

	private boolean atualizarFuncao(int matricula, String funcao) {

		try {
			Funcionario f = buscarFuncionario(matricula);

			banco.criarSessao();
			f.setFuncao(funcao);
			banco.updateHibernate(f);
			return true;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		finally {
			banco.fecharSessao();
		}

	}
}
