package persistencia;

import logica.Produto;

public interface ProdutoDAO {

	boolean cadastrarProduto(Produto p);

	boolean atualizarDescricao(int codProduto, String descricao);

	Produto buscarProduto(int codProduto);

	boolean removerProduto(int codProduto);

}
