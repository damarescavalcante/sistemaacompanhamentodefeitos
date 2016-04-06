//MÉTODOS CONTRUIDOS
//FALTA TESTAR
package logica;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "funcionario")
public class Funcionario {

	private int matricula;
	private String nome;
	private String funcao;
	private String rua;
	private String bairro;
	private String cep;
	private String cidade;
	private ArrayList<Telefone> telefones = new ArrayList<Telefone>();

	public Funcionario() {
	}

	// métodos básicos
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	@Id
	@GeneratedValue
	public int getMatricula() {
		return matricula;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Transient
	public ArrayList<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(ArrayList<Telefone> telefones) {
		this.telefones = telefones;
	}

	@Override
	public String toString() {
		return "Funcionario \nMatrícula: " + matricula + "\nNome: " + nome + "\nFunção: " + funcao + "\nRua: " + rua
				+ "\nBairro: " + bairro + "\nCEP: " + cep + "\nCidade: " + cidade + "\nTelefones: " + telefones;
	}

}
