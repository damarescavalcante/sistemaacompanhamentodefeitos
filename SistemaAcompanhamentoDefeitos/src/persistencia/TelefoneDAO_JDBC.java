//MÉTODOS CONTRUIDOS
//FALTA TESTAR
package persistencia;

import java.sql.ResultSet;
import java.util.ArrayList;

import logica.Funcionario;
import logica.Telefone;

public class TelefoneDAO_JDBC implements TelefoneDAO {

	private BancoSingleton banco = BancoSingleton.getInstance();
	private String sql;

	public Telefone buscarTelefone(int matriculaFunc, String numero) {
		Telefone telefone = new Telefone();
		Funcionario f = new Funcionario();
		try {
			banco.abreConexao();
			
			sql = "SELECT * FROM funcionario WHERE matricula='"+matriculaFunc+"'";
			ResultSet rs = banco.query(sql);
			
			if (rs.next()) {
				
				f.setMatricula(rs.getInt("matricula"));
				f.setNome(rs.getString("nome"));
				f.setFuncao(rs.getString("funcao"));
				f.setRua(rs.getString("rua"));
				f.setBairro(rs.getString("bairro"));
				f.setCep(rs.getString("cep"));
				f.setCidade(rs.getString("cidade"));
				
				banco.abreConexao();
				String sql2 = "SELECT * FROM telefone WHERE numero='" + numero + "'";
				ResultSet rs2 = banco.query(sql2);
				
				if (rs2.next()) {
					telefone.setFuncionario(f);
					telefone.setNumero(rs.getString("numero"));
				}

				return telefone;
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

	public ArrayList<Telefone> buscarTelefone(int matriculaFunc) {
		ArrayList<Telefone> telefones = new ArrayList<Telefone>();
		Funcionario f = new Funcionario();
		try {
			banco.abreConexao();
			
			sql = "SELECT * FROM funcionario WHERE matricula='"+matriculaFunc+"'";
			ResultSet rs = banco.query(sql);
			
			if (rs.next()) {
				
				f.setMatricula(rs.getInt("matricula"));
				f.setNome(rs.getString("nome"));
				f.setFuncao(rs.getString("funcao"));
				f.setRua(rs.getString("rua"));
				f.setBairro(rs.getString("bairro"));
				f.setCep(rs.getString("cep"));
				f.setCidade(rs.getString("cidade"));
				
				banco.abreConexao();
				String sql2 = "SELECT numero FROM telefone WHERE matricula_func='" + matriculaFunc + "'";
				ResultSet rs2 = banco.query(sql2);
				while (rs2.next()) {
					Telefone t = new Telefone();
					
					t.setFuncionario(f);
					t.setNumero(rs2.getString("numero"));
					
					telefones.add(t);

				}

				return telefones;

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
	
	
	public boolean atualizarTelefone(int matriculaFunc, String numeroAntigo, String novoNumero) {

		try {
			banco.abreConexao();
			
			sql = "SELECT * FROM funcionario WHERE matricula='"+matriculaFunc+"'";
			ResultSet rs = banco.query(sql);
			
			if (rs.next()) {
				sql = "UPDATE telefone SET numero='" + novoNumero + "' WHERE numero='" + numeroAntigo + "' and matricula_func='"+matriculaFunc+"'";
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
	
	public boolean adicionarTelefone (Funcionario funcionario, ArrayList<Telefone> telefones) {
		
		try {
			banco.abreConexao();
			
			for (Telefone t : telefones) {
				t.setFuncionario(funcionario);
				sql = "INSERT INTO telefone (numero, matricula_func) values ('"+t.getNumero()+"','"+t.getFuncionario().getMatricula()+"')";
				banco.update(sql);
			}
			
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
