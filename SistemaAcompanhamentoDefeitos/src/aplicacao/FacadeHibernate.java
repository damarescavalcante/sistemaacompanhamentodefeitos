package aplicacao;

import java.util.ArrayList;

import logica.Funcionario;
import logica.Problema;
import logica.Produto;
import logica.Telefone;
import persistencia.EntradaDAO_Hibernate;
import persistencia.FuncionarioDAO_Hibernate;
import persistencia.HistoricoDAO_Hibernate;
import persistencia.ProblemaDAO_Hibernate;
import persistencia.ProdutoDAO_Hibernate;
import persistencia.TelefoneDAO_Hibernate;

public class FacadeHibernate {

	private ProdutoDAO_Hibernate produtoDAO = new ProdutoDAO_Hibernate();
	private FuncionarioDAO_Hibernate funcDAO = new FuncionarioDAO_Hibernate();
	private TelefoneDAO_Hibernate telefoneDAO = new TelefoneDAO_Hibernate();
	private EntradaDAO_Hibernate entradaDAO = new EntradaDAO_Hibernate();
	private HistoricoDAO_Hibernate historicoDAO = new HistoricoDAO_Hibernate();
	private ProblemaDAO_Hibernate problemaDAO = new ProblemaDAO_Hibernate();

	public void cadastrarProduto(String nome, String descricao) {
		Produto p = new Produto();
		try {
			p.setNome(nome);
			p.setDescFuncao(descricao);

			if (produtoDAO.cadastrarProduto(p)) {
				System.out.println("Produto " + nome + " cadastrado com sucesso!");
			}

			else {
				System.out.println("Não foi possível cadastrar o produto " + nome);
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public Produto buscarProduto(int codProduto) {

		try {

			if (produtoDAO.buscarProduto(codProduto) != null) {
				return produtoDAO.buscarProduto(codProduto);
			}

			else {
				System.out.println("Não foi possível buscar o produto " + codProduto);
				return null;
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public Produto buscarProduto(String nome) {

		try {

			if (produtoDAO.buscarProduto(nome) != null) {
				return produtoDAO.buscarProduto(nome);
			}

			else {
				System.out.println("Não foi possível buscar o produto " + nome);
				return null;
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public void atualizarDescricao(int codProduto, String descricao) {

		try {

			if (produtoDAO.atualizarDescricao(codProduto, descricao)) {
				System.out.println("Descrição do produto " + codProduto + " atualizada com sucesso!");
			}

			else {
				System.out.println("Não foi possível atualizar a descrição do produto " + codProduto);
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void removerProduto (int codProduto) {
		
		try {
			
			if (produtoDAO.buscarProduto(codProduto) != null) {
				produtoDAO.removerProduto(codProduto);
				System.out.println("Produto " + codProduto + " removido com sucesso!");
			}
			
			else {
				System.out.println("Não foi possível remover o produto " + codProduto);
			}
		} 
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	//Funcionario
	
	public void cadastrarFuncionario(String nome, String funcao, String rua, String bairro, String cep,
			String cidade, ArrayList<Telefone> telefones) {
		Funcionario f = new Funcionario();
		try {
			f.setNome(nome);
			f.setFuncao(funcao);
			f.setRua(rua);
			f.setBairro(bairro);
			f.setCep(cep);
			f.setCidade(cidade);
			f.setTelefones(telefones);
			if (funcDAO.cadastrarFuncionario(f) && telefoneDAO.adicionarTelefone(f, telefones)) {
				System.out.println("Funcionario " + f.getNome() + " cadastrado com sucesso!");
				System.out.println(telefones);
			}

			else {
				System.out.println("Não foi possível cadastrar o funcionário " + f.getNome());
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void atualizarDadosFuncionario(int matriculaFunc, String tipoDado, String valor) {

		try {
			if (funcDAO.atualizarDados(matriculaFunc, tipoDado, valor)) {
				System.out.println(tipoDado + " do funcionário " + matriculaFunc + " atualizado com sucesso!");
			}

			else {
				System.out.println("Não foi possível atualizar " + tipoDado);
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void atualizarTelefone(int matriculaFunc, String numeroAntigo, String numeroNovo) {

		try {

			if (telefoneDAO.atualizarTelefone(matriculaFunc, numeroAntigo, numeroNovo)) {
				System.out.println("Telefone " + numeroAntigo + " atualizado com sucesso para " + numeroNovo);
			}

			else {
				System.out.println("Não foi possível atualizar o telefone " + numeroAntigo);
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public Funcionario buscarFuncionario(int matriculaFunc) {
		try {

			if (funcDAO.buscarFuncionario(matriculaFunc) != null) {
				return funcDAO.buscarFuncionario(matriculaFunc);
			}

			else {
				System.out.println("Não foi possível buscar o funcionário " + matriculaFunc);
				return null;
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}
	
	public Funcionario buscarFuncionario(String nome, String cep) {
		try {

			if (funcDAO.buscarFuncionario(nome, cep) != null) {
				return funcDAO.buscarFuncionario(nome, cep);
			}

			else {
				System.out.println("Não foi possível buscar o funcionário " + nome);
				return null;
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public void removerFuncionario(int matriculaFunc) {

		try {
			if (funcDAO.removerFuncionario(matriculaFunc)) {
				System.out.println("Funcionário " + matriculaFunc + " removido com sucesso!");
			}

			else {
				System.out.println("Não foi possível remover o funcionário " + matriculaFunc);
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Telefone> buscarTelefones (int matriculaFunc) {
		
		try {
			
			if (telefoneDAO.buscarTelefone(matriculaFunc) != null) {
				return telefoneDAO.buscarTelefone(matriculaFunc);
			}
			
			else {
				System.out.println("Não foi possível buscar os telefones do funcionário " + matriculaFunc);
				return null;
			}
			
		} 
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	public Telefone buscarTelefone (String numero) {
		
		try {
			Telefone t = telefoneDAO.buscarTelefone(numero);
			if (t != null) {
				return buscarTelefone(numero);
			}
			
			else {
				return null;
			}
		} 
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	

}
