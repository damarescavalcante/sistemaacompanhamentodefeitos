package logica;

public class Telefone {

	private String numero;
	private Funcionario funcionario;
	
	public Telefone () {}
	/*
	public Telefone (Funcionario funcionario, String numero) {
		this.numero = numero;
		this.funcionario = funcionario;
	}
	*/
	public void setNumero (String numero) {
		this.numero = numero;
	}
	
	public String getNumero () {
		return this.numero;
	}
	
	public void setFuncionario (Funcionario f) {
		this.funcionario = f;
	}
	
	public Funcionario getFuncionario () {
		return this.funcionario;
	}
	@Override
	public String toString() {
		return "\nNúmero: " + numero;
	}
	
	
}
