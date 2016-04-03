//MÉTODOS CONTRUIDOS
//FALTA TESTAR
package persistencia;

import java.sql.ResultSet;
import logica.Funcionario;

public class FuncionarioDAO_JDBC implements FuncionarioDAO {

	private BancoSingleton banco = BancoSingleton.getInstance();
	private TelefoneDAO_JDBC telefoneDAO = new TelefoneDAO_JDBC();
	private String sql;

	public boolean cadastrarFuncionario(Funcionario f) {
		try {
			banco.abreConexao();

			sql = "SELECT * FROM funcionario WHERE nome='" + f.getNome() + "'";
			ResultSet rs = banco.query(sql);

			if (!rs.next()) {
				String sql2 = "INSERT INTO funcionario (matricula, nome, funcao, rua, bairro, cep, cidade) values('"
						+ f.getMatricula() + "','" + f.getNome() + "','" + f.getFuncao() + "','" + f.getRua() + "','"
						+ f.getBairro() + "','" + f.getCep() + "','" + f.getCidade() + "')";
				banco.update(sql2);

				return true;
			} else {
				return false;
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		finally {
			banco.fechaConexao();
		}
	}

	public boolean atualizarDados(int matricula, String tipoDado, String valor) {

		try {
			banco.abreConexao();
			sql = "SELECT * FROM funcionario WHERE matricula='" + matricula + "'";
			ResultSet rs = banco.query(sql);
			
			if (rs.next()) {

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

		finally {
			banco.fechaConexao();
		}
	}

	public boolean removerFuncionario(int matricula) {

		try {
			banco.abreConexao();
			sql = "SELECT * FROM funcionario WHERE matricula='"+matricula+"'";
			ResultSet rs = banco.query(sql);
			
			if (rs.next()) {
				sql = "DELETE FROM funcionario WHERE matricula='" + matricula + "'";
				banco.update(sql);
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
			banco.fechaConexao();
		}
	}

	public Funcionario buscarFuncionario(int matricula) {
		Funcionario func = new Funcionario();
		try {

			sql = "SELECT * FROM funcionario WHERE matricula='" + matricula + "'";
			banco.abreConexao();
			ResultSet rs = banco.query(sql);

			if (rs.next()) {
				func.setMatricula(rs.getInt("matricula"));
				func.setNome(rs.getString("nome"));
				func.setFuncao(rs.getString("funcao"));
				func.setRua(rs.getString("rua"));
				func.setBairro(rs.getString("bairro"));
				func.setCep(rs.getString("cep"));
				func.setCidade(rs.getString("cidade"));

				func.setTelefones(telefoneDAO.buscarTelefone(matricula));
				
				return func;
			}

			else {
				return null;
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

		finally {
			banco.fechaConexao();
		}
	}

	private boolean atualizarRua(int matricula, String rua) {

		try {
			banco.abreConexao();
			sql = "UPDATE funcionario SET rua='" + rua + "' WHERE matricula='" + matricula + "'";
			banco.update(sql);
			return true;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		finally {
			banco.fechaConexao();
		}

	}

	private boolean atualizarBairro(int matricula, String bairro) {

		try {
			banco.abreConexao();
			sql = "UPDATE funcionario SET bairro='" + bairro + "' WHERE matricula='" + matricula + "'";
			banco.update(sql);
			return true;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		finally {
			banco.fechaConexao();
		}

	}

	private boolean atualizarCep(int matricula, String cep) {

		try {
			banco.abreConexao();
			sql = "UPDATE funcionario SET cep='" + cep + "' WHERE matricula='" + matricula + "'";
			banco.update(sql);
			return true;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		finally {
			banco.fechaConexao();
		}

	}

	private boolean atualizarCidade(int matricula, String cidade) {

		try {
			banco.abreConexao();
			sql = "UPDATE funcionario SET cidade='" + cidade + "' WHERE matricula='" + matricula + "'";
			banco.update(sql);
			return true;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		finally {
			banco.fechaConexao();
		}

	}

	private boolean atualizarFuncao(int matricula, String funcao) {

		try {
			banco.abreConexao();
			sql = "UPDATE funcionario SET funcao='" + funcao + "' WHERE matricula='" + matricula + "'";
			banco.update(sql);
			return true;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		finally {
			banco.fechaConexao();
		}

	}

}