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

				sql = "SELECT * FROM produto WHERE cod_produto='" + p.getCodProduto().getCodProduto() + "'";
				rs = banco.query(sql);

				if (rs.next()) {

					sql = "SELECT * FROM funcionario WHERE matricula='" + p.getMatriculaFunc().getMatricula() + "'";
					rs = banco.query(sql);

					if (rs.next()) {
						sql = "INSERT INTO problema (desc_problema, data_identificacao, cod_produto, matricula_func) values ('"
								+ p.getDescricao() + "','" + p.getDataIdentificacao() + "','"
								+ p.getCodProduto().getCodProduto() + "','" + p.getMatriculaFunc().getMatricula()
								+ "')";
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

	public boolean adicionarHistoricoProblema(HistoricoEntrada historico) {

		try {
			banco.abreConexao();

			if (buscarProblema(historico.getCodProblema().getCodProblema()) != null) {

				sql = "INSERT INTO historico_entrada (cod_problema) values ('"
						+ historico.getCodProblema().getCodProblema() + "')";
				banco.update(sql);

				banco.abreConexao();
				sql = "INSERT INTO problema (cod_historico) values ('" + historico.getCodHistorico()
						+ "') WHERE cod_problema='" + historico.getCodProblema().getCodProblema() + "'";
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

	public boolean atualizarDescricao(int codProblema, String descricao) {

		try {
			banco.abreConexao();

			if (buscarProblema(codProblema) != null) {

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

			if (buscarProblema(codProblema) != null) {
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
		Problema problema = new Problema();
		try {
			banco.abreConexao();
			sql = "SELECT * FROM problema WHERE cod_problema='" + codProblema + "'";
			ResultSet rs = banco.query(sql);

			if (rs.next()) {
				problema.setCodProblema(rs.getInt("cod_problema"));
				problema.setDescricao(rs.getString("desc_problema"));
				problema.setDataIdentificacao(rs.getString("data_identificacao"));
				problema.setDataResolucao(rs.getString("data_resolucao"));
				problema.getCodProduto().setCodProduto(rs.getInt("cod_produto"));
				problema.getCodHistorico().setCodHistorico(rs.getInt("cod_historico"));
				problema.getMatriculaFunc().setMatricula(rs.getInt("matricula_func"));
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

}
