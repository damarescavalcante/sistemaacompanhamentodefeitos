//MÉTODOS CONTRUIDOS
//FALTA TESTAR
package persistencia;

import java.sql.ResultSet;

import logica.Produto;

public class ProdutoDAO_JDBC implements ProdutoDAO {

	private BancoSingleton banco = BancoSingleton.getInstance();
	private String sql;

	public boolean cadastrarProduto(Produto p) {

		try {
			banco.abreConexao();
			sql = "SELECT * FROM produto WHERE nome='"+p.getNome()+"'";
			ResultSet rs = banco.query(sql);

			if (!rs.next()) {
				
				String sql2 = "INSERT INTO produto (nome, desc_funcao) values ('" + p.getNome() + "','" + p.getDescFuncao() + "')";
				banco.update(sql2);
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

	public boolean atualizarDescricao(int codProduto, String descricao) {

		try {
			
			if (buscarProduto(codProduto) != null) {
				banco.abreConexao();
				sql = "UPDATE produto SET desc_funcao='" + descricao + "' WHERE cod_produto='" + codProduto + "'";
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

	public Produto buscarProduto(int codProduto) {
		Produto p = new Produto();
		try {
			banco.abreConexao();

			sql = "SELECT * FROM produto WHERE cod_produto='"+codProduto+"'";
			ResultSet rs = banco.query(sql);

			if (rs.next()) {
				p.setCodProduto(rs.getInt("cod_produto"));
				p.setNome(rs.getString("nome"));
				p.setDescFuncao(rs.getString("desc_funcao"));
				return p;
			}
			else{
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
	
	public Produto buscarProduto(String nome) {
		Produto p = new Produto();
		try {
			banco.abreConexao();

			sql = "SELECT * FROM produto WHERE nome='"+nome+"'";
			ResultSet rs = banco.query(sql);

			if (rs.next()) {
				p.setCodProduto(rs.getInt("cod_produto"));
				p.setNome(rs.getString("nome"));
				p.setDescFuncao(rs.getString("desc_funcao"));
				return p;
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

	public boolean removerProduto(int codProduto) {

		try {

			if (buscarProduto(codProduto) != null) {
				banco.abreConexao();
				sql = "DELETE FROM produto WHERE cod_produto='" + codProduto + "'";
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
