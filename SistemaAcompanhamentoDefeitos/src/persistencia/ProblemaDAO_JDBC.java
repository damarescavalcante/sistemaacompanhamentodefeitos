package persistencia;

import java.sql.ResultSet;

import java.util.ArrayList;

import logica.Entrada;

import logica.HistoricoEntrada;
import logica.Problema;

public class ProblemaDAO_JDBC implements ProblemaDAO {

	private BancoSingleton banco = BancoSingleton.getInstance();
	private String sql;

	public boolean cadastrarProblema(Problema p) {

		try {
			banco.abreConexao();
			sql = "SELECT * FROM problema WHERE desc_problema='" + p.getDescricao() + "' and data_identificacao='"
					+ p.getDataIdentificacao() + "'";
			ResultSet rs = banco.query(sql);

			if (!rs.next()) {

				sql = "SELECT * FROM produto WHERE cod_produto='" + p.getProduto().getCodProduto() + "'";
				rs = banco.query(sql);

				if (rs.next()) {

					sql = "SELECT * FROM funcionario WHERE matricula='" + p.getFuncionario().getMatricula() + "'";
					rs = banco.query(sql);

					if (rs.next()) {
						sql = "INSERT INTO problema (desc_problema, data_identificacao, cod_produto, matricula_func) values ('"
								+ p.getDescricao() + "','" + p.getDataIdentificacao() + "','"
								+ p.getProduto().getCodProduto() + "','" + p.getFuncionario().getMatricula() + "')";
						banco.update(sql);

						return true;
					}

					else {
						return false;
					}
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

	public boolean atualizarDescricao(int codProblema, String descricao) {
		try {
			banco.abreConexao();
			sql = "SELECT * FROM problema WHERE cod_problema='" + codProblema + "'";
			ResultSet rs = banco.query(sql);
			if (rs.next()) {
				sql = "UPDATE problema SET desc_problema='" + descricao + "' WHERE cod_problema='" + codProblema + "'";
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

	public boolean encerrarProblema(int codProblema) {

		try {
			banco.abreConexao();
			sql = "SELECT * FROM problema WHERE cod_problema='" + codProblema + "'";
			ResultSet rs = banco.query(sql);

			if (rs.next()) {
				sql = "DELETE FROM problema WHERE cod_problema='" + codProblema + "'";
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

	public ArrayList<Entrada> consultarHistorico(int codProblema) {
		HistoricoDAO_JDBC historicoDAO = new HistoricoDAO_JDBC();
		try {
			banco.abreConexao();
			return historicoDAO.consultarHistoricoEntradas(codProblema);
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

		finally {
			banco.fechaConexao();
		}

	}

	public Problema buscarProblema(int codProblema) {
		FuncionarioDAO_JDBC fDAO = new FuncionarioDAO_JDBC();
		ProdutoDAO_JDBC pDAO = new ProdutoDAO_JDBC();

		Problema problema = new Problema();
		HistoricoEntrada h = new HistoricoEntrada();
		try {
			banco.abreConexao();
			sql = "SELECT * FROM problema WHERE cod_problema='" + codProblema + "'";
			ResultSet rs = banco.query(sql);

			if (rs.next()) {
				problema.setCodProblema(rs.getInt("cod_problema"));
				problema.setDescricao(rs.getString("desc_problema"));
				problema.setDataIdentificacao(rs.getString("data_identificacao"));
				problema.setDataResolucao(rs.getString("data_resolucao"));

				problema.setProduto(pDAO.buscarProduto(rs.getInt("cod_produto")));
				problema.setFuncionario(fDAO.buscarFuncionario(rs.getInt("matricula_func")));
				banco.abreConexao();
				sql = "SELECT cod_historico FROM historico_entrada WHERE cod_problema='" + codProblema + "'";
				rs = banco.query(sql);

				if (rs.next()) {
					h.setCodHistorico(rs.getInt("cod_historico"));
					h.setProblema(problema);
				}

				problema.setHistorico(h);
			}
			return problema;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

		finally {
			banco.fechaConexao();
		}

	}

	public boolean adicionarHistoricoProblema(int codProblema) {

		try {
			banco.abreConexao();

			sql = "SELECT cod_historico FROM historico_entrada WHERE cod_problema='" + codProblema + "'";
			ResultSet rs = banco.query(sql);
			int codHistorico = 0;

			if (rs.next()) {
				codHistorico = rs.getInt("cod_historico");

				sql = "UPDATE problema SET cod_historico='" + codHistorico + "' WHERE cod_problema='" + codProblema
						+ "'";
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

}
