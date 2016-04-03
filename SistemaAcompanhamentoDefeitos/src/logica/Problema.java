//MÉTODOS CONTRUIDOS
//FALTA TESTAR
package logica;

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
	/*
	 * public Problema(int codProblema, String descricao, Date
	 * dataIdentificacao, Produto codProduto, Funcionario matriculaFunc,
	 * HistoricoEntrada codHistorico) { super(); this.codProblema = codProblema;
	 * this.descricao = descricao; this.dataIdentificacao = dataIdentificacao;
	 * this.codProduto = codProduto; this.matriculaFunc = matriculaFunc;
	 * this.codHistorico = codHistorico; }
	 */

	// métodos básicos
	public void setCodProblema(int codProblema) {
		this.codProblema = codProblema;
	}

	public int getCodProblema() {
		return codProblema;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDataIdentificacao(String date) {
		this.dataIdentificacao = date;
	}

	public String getDataIdentificacao() {
		return dataIdentificacao;
	}

	public String getDataResolucao() {
		return dataResolucao;
	}

	public void setDataResolucao(String dataResolucao) {
		this.dataResolucao = dataResolucao;
	}

	public void setProduto(Produto p) {
		this.produto = p;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setFuncionario(Funcionario f) {
		this.funcionario = f;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setHistorico(HistoricoEntrada hs) {
		this.historico = hs;
	}

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
