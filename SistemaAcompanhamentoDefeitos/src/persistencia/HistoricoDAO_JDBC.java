//MÉTODOS CONTRUIDOS
//FALTA TESTAR
package persistencia;

import java.sql.ResultSet;
import java.util.ArrayList;
import logica.Entrada;
import logica.Funcionario;
import logica.HistoricoEntrada;

public class HistoricoDAO_JDBC implements HistoricoDAO {

	private BancoSingleton banco = BancoSingleton.getInstance();
	private String sql;

	public ArrayList<Entrada> consultarHistoricoEntradas(int codProblema) {
		ArrayList<Entrada> historico = new ArrayList<Entrada>();
		HistoricoEntrada he = new HistoricoEntrada();
		Funcionario f = new Funcionario();
		int codHistorico = 0;
		ResultSet rs;
		try {
			banco.abreConexao();
			sql = "SELECT cod_historico FROM historico_status WHERE cod_problema='" + codProblema + "'";
			rs = banco.query(sql);

			if (rs.next()) {
				codHistorico = rs.getInt("cod_historico");

				sql = "SELECT * FROM entrada WHERE cod_historico='" + codHistorico + "'";
				rs = banco.query(sql);

				while (rs.next()) {
					Entrada e = new Entrada();
					e.setCodEntrada(rs.getInt("cod_entrada"));
					e.setDataPostada(rs.getDate("data_postada"));
					e.setDescricao(rs.getString("desc_entrada"));
					e.setStatusProblema(rs.getString("status_problema"));
					he.setCodHistorico(rs.getInt("cod_historico"));
					e.setCodHistorico(he);
					f.setMatricula(rs.getInt("matricula_func"));
					e.setMatriculaFunc(f);
					historico.add(e);
				}

				return historico;

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

	public boolean removerHistorico(int codProblema) {

		try {
			banco.abreConexao();
			int codHistorico = 0;
			sql = "SELECT cod_historico FROM historico_entrada WHERE cod_problema='" + codProblema + "'";
			ResultSet rs = banco.query(sql);

			if (rs.next()) {
				codHistorico = rs.getInt("cod_historico");
				sql = "DELETE FROM historico_entrada WHERE cod_problema='" + codProblema + "'";
				banco.update(sql);

				banco.abreConexao();
				sql = "SELECT * FROM entrada WHERE cod_historico='" + codHistorico + "'";
				rs = banco.query(sql);

				while (rs.next()) {

					sql = "DELETE FROM entrada WHERE cod_historico='" + codHistorico + "'";
					banco.update(sql);

				}

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
