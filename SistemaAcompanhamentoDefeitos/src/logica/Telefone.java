package logica;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefone")
public class Telefone {

	private String numero;
	private Funcionario funcionario;
	
	public Telefone () {}
	
	public void setNumero (String numero) {
		this.numero = numero;
	}
	
	@Id
	public String getNumero () {
		return this.numero;
	}
	
	public void setFuncionario (Funcionario f) {
		this.funcionario = f;
	}
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name = "matricula_func")
	public Funcionario getFuncionario () {
		return this.funcionario;
	}
	@Override
	public String toString() {
		return "\nNúmero: " + numero;
	}
	
	
}
