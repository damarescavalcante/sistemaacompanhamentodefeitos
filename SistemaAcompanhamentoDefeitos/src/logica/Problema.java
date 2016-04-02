//MÉTODOS CONTRUIDOS
//FALTA TESTAR
package logica;

public class Problema {

	private int codProblema;
	private String descricao;
	private String dataIdentificacao;
	private String dataResolucao;
	private Produto codProduto;
	private Funcionario matriculaFunc;
	private HistoricoEntrada codHistorico;

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
		this.codProduto = p;
	}

	public Produto getCodProduto() {
		return codProduto;
	}

	public void setMatriculaFunc(Funcionario f) {
		this.matriculaFunc = f;
	}

	public Funcionario getMatriculaFunc() {
		return matriculaFunc;
	}

	public void setCodHistorico(HistoricoEntrada hs) {
		this.codHistorico = hs;
	}

	public HistoricoEntrada getCodHistorico() {
		return codHistorico;
	}

	@Override
	public String toString() {
		return "Problema \nCódigo:" + codProblema + "\nDescrição:" + descricao + "Data de Identificação:"
				+ dataIdentificacao + "\nData de Resolução:" + dataResolucao + "\nCódigo do Produto:" + codProduto
				+ "\nMatrícula do Funcionário:" + matriculaFunc + "\nCódigo do Histórico:" + codHistorico;
	}
}
