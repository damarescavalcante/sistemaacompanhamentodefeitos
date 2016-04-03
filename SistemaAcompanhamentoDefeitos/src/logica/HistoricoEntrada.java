package logica;

import java.util.ArrayList;

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

	public int getCodHistorico() {
		return codHistorico;
	}
	
	public void setProblema (Problema p) {
		this.problema = p;
	}

	public Problema getProblema() {
		return problema;
	}

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
