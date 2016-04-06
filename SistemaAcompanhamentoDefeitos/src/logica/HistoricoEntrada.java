package logica;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "historico_entrada")
public class HistoricoEntrada {

	private int codHistorico;
	private Problema problema = new Problema();
	private ArrayList<Entrada> entradas = new ArrayList<Entrada>();

	public HistoricoEntrada() {
	}

	// métodos básicos
	public void setCodHistorico(int codHistorico) {
		this.codHistorico = codHistorico;
	}

	@Id
	@GeneratedValue
	@Column(name = "cod_historico")
	public int getCodHistorico() {
		return codHistorico;
	}
	
	public void setProblema (Problema p) {
		this.problema = p;
	}

	@OneToOne
	@JoinColumn(name = "cod_problema")
	public Problema getProblema() {
		return problema;
	}

	@Transient
	public ArrayList<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(ArrayList<Entrada> entradas) {
		this.entradas = entradas;
	}

	@Override
	public String toString() {
		return "HistoricoStatus \nCódigo: " + codHistorico + "Código do Problema:" + problema + "\nEntradas:"
				+ entradas;
	}

}
