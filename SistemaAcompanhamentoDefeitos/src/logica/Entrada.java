package logica;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Entrada {

	private int codEntrada;
	private Date dataPostada;
	private String statusProblema;
	private String descricao;
	private Funcionario funcionario;
	private HistoricoEntrada historico;
	
	public Entrada (){}

	//Métodos básicos
	public void setCodEntrada(int codEntrada) {
		this.codEntrada = codEntrada;
	}
	
	public void setDataPostada(Date dataPostada) {
		this.dataPostada = dataPostada;
	}
	
	public void setStatusProblema(String statusProblema) {
		this.statusProblema = statusProblema;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public void setHistorico(HistoricoEntrada historico) {
		this.historico = historico;
	}
	
	public int getCodEntrada() {
		return codEntrada;
	}

	public Date getDataPostada() {
		return dataPostada;
	}

	public String getStatusProblema() {
		return statusProblema;
	}

	public String getDescricao() {
		return descricao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public HistoricoEntrada getHistorico() {
		return historico;
	}

	@Override
	public String toString() {
		return "Entrada \nCódigo: " + codEntrada + "\nData Postada: " + formataData(dataPostada) + "\nStatus do Problema: "
				+ statusProblema + "\nDescrição: " + descricao + "\nMatrícula do Funcionário: " + funcionario.getMatricula() + "\nCódigo do Histórico: "
				+ historico.getCodHistorico() + "\n\n";
	}
	
	private String formataData(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String data = format.format(date);
		return data;
	}
	
}
