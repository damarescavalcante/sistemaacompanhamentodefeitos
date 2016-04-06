package logica;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entrada")
public class Entrada {

	private int codEntrada;
	private Date dataPostada;
	private String statusProblema;
	private String descricao;
	private Funcionario funcionario;
	private HistoricoEntrada historico;

	public Entrada() {
	}

	// Métodos básicos
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

	@Id
	@GeneratedValue
	@Column(name = "cod_entrada")
	public int getCodEntrada() {
		return codEntrada;
	}

	@Column(name = "data_postada")
	public Date getDataPostada() {
		return dataPostada;
	}

	@Column(name = "status_problema")
	public String getStatusProblema() {
		return statusProblema;
	}

	@Column(name = "desc_entrada")
	public String getDescricao() {
		return descricao;
	}

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name = "matricula_func")
	public Funcionario getFuncionario() {
		return funcionario;
	}

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name = "cod_historico")
	public HistoricoEntrada getHistorico() {
		return historico;
	}

	@Override
	public String toString() {
		return "Entrada \nCódigo: " + codEntrada + "\nData Postada: " + formataData(dataPostada)
				+ "\nStatus do Problema: " + statusProblema + "\nDescrição: " + descricao
				+ "\nMatrícula do Funcionário: " + funcionario.getMatricula() + "\nCódigo do Histórico: "
				+ historico.getCodHistorico() + "\n\n";
	}

	private String formataData(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String data = format.format(date);
		return data;
	}

}
