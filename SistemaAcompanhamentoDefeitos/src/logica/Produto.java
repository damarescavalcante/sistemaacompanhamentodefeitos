//MÉTODOS CONTRUIDOS
//FALTA TESTAR
package logica;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	private int codProduto;
	private String nome;
	private String descFuncao;

	public Produto() {
	}
	
	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescFuncao(String descricao) {
		this.descFuncao = descricao;
	}

	@Id
	@GeneratedValue
	@Column(name = "cod_produto")
	public int getCodProduto() {
		return codProduto;
	}

	public String getNome() {
		return nome;
	}
	
	@Column(name = "desc_funcao")
	public String getDescFuncao() {
		return descFuncao;
	}

	@Override
	public String toString() {
		return "Produto \nCódigo: " + codProduto + "\nNome: " + nome + "\nDescrição: " + descFuncao;
	}

}
