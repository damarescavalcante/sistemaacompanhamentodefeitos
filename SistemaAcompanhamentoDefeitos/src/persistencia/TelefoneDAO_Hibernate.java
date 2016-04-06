package persistencia;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import logica.Funcionario;
import logica.Telefone;

public class TelefoneDAO_Hibernate implements TelefoneDAO {
	
	private BancoSingleton banco = BancoSingleton.getInstance();
	private String sql;

	@Override
	public boolean atualizarTelefone(int matriculaFunc, String numeroAntigo, String numeroNovo) {
		try {
			banco.criarSessao();
			sql = "SELECT t FROM Telefone t WHERE t.numero='"+numeroAntigo+"' and t.funcionario='"+matriculaFunc+"'";
			Telefone t = (Telefone) banco.recuperarObjeto(sql);
			banco.criarSessao();
			if (t != null) {
				t.setNumero(numeroNovo);
				banco.updateHibernate(t);
				return true;	
			}
			else{
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


	public Telefone buscarTelefone(String numero) {
		try {
			
			banco.criarSessao();				
			sql = "SELECT t FROM Telefone t WHERE t.numero='"+numero+"'";
			Telefone t = (Telefone) banco.recuperarObjeto(sql);

			if (t != null) {
				return t;
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
			banco.fecharSessao();
		}
	}

	@Override
	public ArrayList<Telefone> buscarTelefone(int matriculaFunc) {
		ArrayList<Telefone> tels = new ArrayList<Telefone>();
		try {
			banco.criarSessao();
			sql = "SELECT t FROM Telefone t WHERE t.funcionario='"+matriculaFunc+"'";
			List<Telefone> telefones = (List) banco.recuperarListaObjeto(sql);
			
			for (Telefone t : telefones) {
				tels.add(t);
			}
			
			return tels;
		} 
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		finally {
			banco.fecharSessao();
		}
		
	}

	@Override
	public boolean adicionarTelefone(Funcionario f, ArrayList<Telefone> telefones) {

		try {
					
			for (Telefone t : telefones) {
				t.setFuncionario(f);
				banco.criarSessao();
				banco.comitarObjetoSalvo(t);
			}
			
			return true;
		} 
		
		catch (Exception e) {
			return false;
		}
		
		finally {
			banco.fecharSessao();
		}
	}


	@Override
	public Telefone buscarTelefone(int matriculaFunc, String numero) {
		// TODO Auto-generated method stub
		return null;
	}

}
