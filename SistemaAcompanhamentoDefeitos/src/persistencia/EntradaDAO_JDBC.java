//MÉTODOS CONTRUIDOS
//FALTA TESTAR
package persistencia;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import logica.Entrada;

public class EntradaDAO_JDBC implements EntradaDAO {

	private BancoSingleton banco = BancoSingleton.getInstance();
	private String sql;

	public boolean registrarEntrada(Entrada entrada) {

		try {
			banco.abreConexao();

			sql = "SELECT * FROM entrada WHERE desc_entrada='" + entrada.getDescricao() + "' and data_postada='"
					+ formataData(entrada.getDataPostada()) + "'";
			ResultSet rs = banco.query(sql);

			if (!rs.next()) {
				int codHistorico = 0;
				sql = "SELECT * FROM historico_entrada WHERE cod_problema='"
						+ entrada.getHistorico().getProblema().getCodProblema() + "'";
				rs = banco.query(sql);

				if (rs.next()) {
					codHistorico = rs.getInt("cod_historico");

					sql = "SELECT * FROM funcionario WHERE matricula='" + entrada.getFuncionario().getMatricula() + "'";
					rs = banco.query(sql);

					if (rs.next()) {
						sql = "INSERT INTO entrada (data_postada, desc_entrada, status_problema, cod_historico, matricula_func) values ('"
								+ formataData(entrada.getDataPostada()) + "','" + entrada.getDescricao() + "','"
								+ entrada.getStatusProblema() + "','" + codHistorico + "','"
								+ entrada.getFuncionario().getMatricula() + "')";
						banco.update(sql);

						if (entrada.getStatusProblema().equalsIgnoreCase("encerrado") || entrada.getStatusProblema().equalsIgnoreCase("finalizado") || entrada.getStatusProblema().equalsIgnoreCase("concluído")) {
							
							sql = "UPDATE problema SET data_resolucao='"+formataData(entrada.getDataPostada())+"' WHERE cod_problema='"+entrada.getHistorico().getProblema().getCodProblema()+"'";
							banco.update(sql);
							
						}
											
						return true;

					} else {
						return false;
					}
				} else {
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

	public boolean removerEntrada(int codEntrada) {

		try {
			banco.abreConexao();
			sql = "SELECT * FROM entrada WHERE cod_entrada='" + codEntrada + "'";
			ResultSet rs = banco.query(sql);

			if (rs.next()) {
				sql = "DELETE FROM entrada WHERE cod_entrada='" + codEntrada + "'";
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

	public Entrada buscarEntrada(int codEntrada) {
		FuncionarioDAO_JDBC fDAO = new FuncionarioDAO_JDBC();

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
				entrada.setFuncionario(fDAO.buscarFuncionario(rs.getInt("matricula_func")));

				sql = "SELECT";
				entrada.getHistorico().setCodHistorico(rs.getInt("cod_historico"));

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

	private String formataData(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String data = format.format(date);
		return data;
	}

}
