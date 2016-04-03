//MÉTODOS CONTRUIDOS
//FALTA TESTAR
package persistencia;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
			sql = "SELECT cod_historico FROM historico_entrada WHERE cod_problema='" + codProblema + "'";
			rs = banco.query(sql);

			if (rs.next()) {
				codHistorico = rs.getInt("cod_historico");

				sql = "SELECT * FROM entrada WHERE cod_historico='" + codHistorico + "'";
				rs = banco.query(sql);

				while (rs.next()) {
					Entrada e = new Entrada();
					e.setCodEntrada(rs.getInt("cod_entrada"));
					//Convertendo o retorno string de data para o formato DATE
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					Date data = (java.util.Date)df.parse(rs.getString("data_postada"));
					e.setDataPostada(data);
					e.setDescricao(rs.getString("desc_entrada"));
					e.setStatusProblema(rs.getString("status_problema"));
					he.setCodHistorico(rs.getInt("cod_historico"));
					e.setHistorico(he);
					f.setMatricula(rs.getInt("matricula_func"));
					e.setFuncionario(f);
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
	
	public boolean adicionarHistoricoProblema(HistoricoEntrada historico) {
		
		try {
			banco.abreConexao();

			sql = "SELECT cod_problema FROM problema WHERE desc_problema='"+historico.getProblema().getDescricao()+"' and data_identificacao='"+historico.getProblema().getDataIdentificacao()+"'";
			ResultSet rs = banco.query(sql);
			int codProblema = 0;
			if (rs.next()) {
				codProblema = rs.getInt("cod_problema");
				System.out.println("codigo do problema:" + codProblema);
				
				sql = "INSERT INTO historico_entrada (cod_problema) values ('"
						+ codProblema + "')";
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
