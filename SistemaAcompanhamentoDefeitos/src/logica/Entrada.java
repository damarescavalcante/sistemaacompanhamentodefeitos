package logica;

import java.sql.Date;

public class Entrada {

	private int codEntrada;
	private Date dataPostada;
	private String statusProblema;
	private String descricao;
	private Funcionario matriculaFunc;
	private HistoricoEntrada codHistorico;
	
	public Entrada (){}
	/*
	public Entrada(int codEntrada, Date dataPostada, String statusProblema, String descricao,
			Funcionario matriculaFunc, HistoricoEntrada codHistorico) {
		this.codEntrada = codEntrada;
		this.dataPostada = dataPostada;
		this.statusProblema = statusProblema;
		this.descricao = descricao;
		this.matriculaFunc = matriculaFunc;
		this.codHistorico = codHistorico;
	}
	*/
	
	
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
	
	public void setMatriculaFunc(Funcionario matriculaFunc) {
		this.matriculaFunc = matriculaFunc;
	}
	
	public void setCodHistorico(HistoricoEntrada codHistorico) {
		this.codHistorico = codHistorico;
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

	public Funcionario getMatriculaFunc() {
		return matriculaFunc;
	}

	public HistoricoEntrada getCodHistorico() {
		return codHistorico;
	}

	@Override
	public String toString() {
		return "Entrada \nCódigo:" + codEntrada + "\nData Postada:" + dataPostada + "\nStatus do Problema:"
				+ statusProblema + "\nDescrição:" + descricao + "\nmMatrícula do Funcionário:" + matriculaFunc + "\nCódigo do Histórico:"
				+ codHistorico;
	}
	
	
	
}
