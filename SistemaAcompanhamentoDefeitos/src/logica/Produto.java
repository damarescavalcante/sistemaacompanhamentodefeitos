//MÉTODOS CONTRUIDOS
//FALTA TESTAR
package logica;

public class Produto {

	private int codProduto;
	private String nome;
	private String descFuncao;

	public Produto() {
	}
	/*
	 * public Produto(int codProduto, String nome, String descFuncao) {
	 * this.codProduto = codProduto; this.nome = nome; this.descFuncao =
	 * descFuncao; }
	 */

	// métodos básicos
	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescFuncao(String descricao) {
		this.descFuncao = descricao;
	}

	public int getCodProduto() {
		return codProduto;
	}

	public String getNome() {
		return nome;
	}

	public String getDescFuncao() {
		return descFuncao;
	}

	@Override
	public String toString() {
		return "Produto \nCódigo: " + codProduto + "\nNome: " + nome + "\nDescrição: " + descFuncao;
	}

}
