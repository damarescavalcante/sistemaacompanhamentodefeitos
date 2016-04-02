//MÉTODOS CONTRUIDOS
//FALTA TESTAR
package persistencia;

import java.sql.ResultSet;
import logica.Entrada;

public class EntradaDAO_JDBC implements EntradaDAO {

	private BancoSingleton banco = BancoSingleton.getInstance();
	private String sql;

	public boolean registrarEntrada(Entrada entrada) {

		try {
			banco.abreConexao();
			sql = "INSERT INTO entrada (cod_entrada, data_postada, desc_entrada, status_problema, cod_historico) values ('"
					+ entrada.getCodEntrada() + "','" + entrada.getDataPostada() + "','" + entrada.getDescricao()
					+ "','" + entrada.getStatusProblema() + "','" + entrada.getCodHistorico().getCodHistorico() + "')";
			banco.update(sql);

			sql = "INSERT INTO entrada_funcionario (cod_entrada, matricula_func) values ('" + entrada.getCodEntrada()
					+ "','" + entrada.getMatriculaFunc().getMatricula() + "')";
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

	public boolean removerEntrada(int codEntrada) {

		try {
			banco.abreConexao();
			sql = "DELETE FROM entrada WHERE cod_entrada='" + codEntrada + "'";
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

	public Entrada buscarEntrada(int codEntrada) {
		Entrada entrada = new Entrada();
		try {
			banco.abreConexao();
			sql = "SELECT * FROM entrada WHERE cod_entrada='" + codEntrada + "'";
			ResultSet rs = banco.query(sql);

			if (rs.next()) {
				entrada.setCodEntrada(rs.getInt("cod_entrada"));
				entrada.setDataPostada(rs.getDate("data_postada"));
				entrada.setDescricao(rs.getString("desc_entrada"));
				entrada.setStatusProblema(rs.getString("status_problema"));
				entrada.getCodHistorico().setCodHistorico(rs.getInt("cod_historico"));

				String sql2 = "SELECT matricula_func FROM entrada_funcionario WHERE cod_entrada='" + codEntrada + "'";
				ResultSet rs2 = banco.query(sql2);

				if (rs2.next()) {
					entrada.getMatriculaFunc().setMatricula(rs.getInt("matricula_func"));
				}
			}

			return entrada;

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
