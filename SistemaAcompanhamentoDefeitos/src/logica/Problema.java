//MÉTODOS CONTRUIDOS
//FALTA TESTAR
package logica;

import javax.persistence.CascadeType;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "problema")
public class Problema {

	private int codProblema;
	private String descricao;
	private String dataIdentificacao;
	private String dataResolucao;
	private Produto produto;
	private Funcionario funcionario;
	private HistoricoEntrada historico;

	public Problema() {
	}

	public void setCodProblema(int codProblema) {
		this.codProblema = codProblema;
	}

	@Id
	@GeneratedValue
	@Column(name = "cod_problema")
	public int getCodProblema() {
		return codProblema;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "desc_problema")
	public String getDescricao() {
		return descricao;
	}

	public void setDataIdentificacao(String date) {
		this.dataIdentificacao = date;
	}

	@Column(name = "data_identificacao")
	public String getDataIdentificacao() {
		return dataIdentificacao;
	}

	@Column(name = "data_resolucao")
	public String getDataResolucao() {
		return dataResolucao;
	}

	public void setDataResolucao(String dataResolucao) {
		this.dataResolucao = dataResolucao;
	}

	public void setProduto(Produto p) {
		this.produto = p;
	}

	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name = "cod_produto")
	public Produto getProduto() {
		return produto;
	}

	public void setFuncionario(Funcionario f) {
		this.funcionario = f;
	}

	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name = "matricula_func")
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setHistorico(HistoricoEntrada hs) {
		this.historico = hs;
	}

	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name = "cod_historico", nullable = true)
	public HistoricoEntrada getHistorico() {
		return historico;
	}

	@Override
	public String toString() {
		return "Problema \nCódigo: " + codProblema + "\nDescrição: " + descricao + "\nData de Identificação: "
				+ dataIdentificacao + "\nData de Resolução: " + dataResolucao + "\nCódigo do Produto: " + produto
				+ "\nMatrícula do Funcionário: " + funcionario.getMatricula() + "\nCódigo do Histórico: "
				+ historico.getCodHistorico();
	}
}
