package persistencia;

import logica.Produto;

public class ProdutoDAO_Hibernate implements ProdutoDAO {
	
	private BancoSingleton banco = BancoSingleton.getInstance();
	private String sql;

	@Override
	public boolean cadastrarProduto(Produto p) {
		
		try {
			
			Produto produto = buscarProduto(p.getNome());
			banco.criarSessao();
			if (produto == null) {
				banco.comitarObjetoSalvo(p);
				return true;
			}
			
			else{
				return false;
			}
				
		} 
		
		catch (Exception e) {
			return false;
		}
		
		finally {
			banco.fecharSessao();
		}
		
	}

	@Override
	public boolean atualizarDescricao(int codProduto, String descricao) {

		try {
			
			if (this.buscarProduto(codProduto) != null) {
				Produto produto = buscarProduto(codProduto);
				produto.setDescFuncao(descricao);
				banco.criarSessao();
				banco.updateHibernate(produto);
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
	public Produto buscarProduto(int codProduto) {
		
		try {
			banco.criarSessao();
			sql = "SELECT p FROM Produto p WHERE p.codProduto='"+codProduto+"'";
			Produto produto = (Produto) banco.recuperarObjeto(sql);
			
			if (produto != null) {
				return produto;
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
	public Produto buscarProduto(String nome) {
		
		try {
			banco.criarSessao();
			sql = "SELECT p FROM Produto p WHERE p.nome='"+nome+"'";
			Produto produto = (Produto) banco.recuperarObjeto(sql);
			
			if (produto != null) {
				return produto;
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
	public boolean removerProduto(int codProduto) {
		
		try {
			
			if (buscarProduto(codProduto) != null) {
				banco.criarSessao();
				sql = "SELECT p FROM Produto p WHERE p.codProduto='"+codProduto+"'";
				
				Produto produto = (Produto) banco.recuperarObjeto(sql);
				banco.removeHibernate(produto);
				return true;
			}
			
			else {
				return false;
			}
			
		} 
		
		catch (Exception e) {
			return false;
		}
		
		finally {
			banco.fecharSessao();
		}
		

	}

}