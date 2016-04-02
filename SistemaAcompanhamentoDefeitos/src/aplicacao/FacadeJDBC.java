package aplicacao;

import java.sql.Date;
import java.util.ArrayList;

import logica.Entrada;
import logica.Funcionario;
import logica.HistoricoEntrada;
import logica.Problema;
import logica.Produto;
import logica.Telefone;
import persistencia.EntradaDAO_JDBC;
import persistencia.FuncionarioDAO_JDBC;
import persistencia.HistoricoDAO_JDBC;
import persistencia.ProblemaDAO_JDBC;
import persistencia.ProdutoDAO_JDBC;
import persistencia.TelefoneDAO_JDBC;

public class FacadeJDBC {

	private ProdutoDAO_JDBC produtoDAO = new ProdutoDAO_JDBC();
	private FuncionarioDAO_JDBC funcDAO = new FuncionarioDAO_JDBC();
	private TelefoneDAO_JDBC telefoneDAO = new TelefoneDAO_JDBC();
	private ProblemaDAO_JDBC problemaDAO = new ProblemaDAO_JDBC();
	private EntradaDAO_JDBC entradaDAO = new EntradaDAO_JDBC();
	private HistoricoDAO_JDBC historicoDAO = new HistoricoDAO_JDBC();

	public void cadastrarProduto(String nome, String descFuncao) {
		Produto p = new Produto();
		try {
			p.setNome(nome);
			p.setDescFuncao(descFuncao);

			if (produtoDAO.cadastrarProduto(p) == true) {
				System.out.println("Produto " + nome + " cadastrado com sucesso!");
			}

			else {
				System.out.println("Não foi possível realizar o cadastro do produto " + nome);
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Não foi possível realizar o cadastro do produto " + nome);
		}

	}

	public void atualizarDescricaoProduto(int codProduto, String descFuncao) {

		try {
			if (produtoDAO.atualizarDescricao(codProduto, descFuncao) == true) {
				System.out.println("Descrição do produto " + codProduto + " atualizada com sucesso!");
			}

			else {
				System.out.println("Produto " + codProduto + " não existe!");
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

	public void removerProduto(int codProduto) {

		try {
			if (produtoDAO.removerProduto(codProduto) == true) {
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

	public void cadastrarProblema(String descProblema, String dataIdentificacao, int codProduto,
			int matriculaFunc, HistoricoEntrada historico) {
		Problema p = new Problema();
		Funcionario f = new Funcionario();
		Produto produto = new Produto();
		try {
			p.setDescricao(descProblema);
			p.setDataIdentificacao(dataIdentificacao);
			produto.setCodProduto(codProduto);
			p.setProduto(produto);
			f.setMatricula(matriculaFunc);
			p.setMatriculaFunc(f);
			if (problemaDAO.cadastrarProblema(p)) {
				System.out.println("Problema: " + descProblema + " cadastrado com sucesso!");
			}
			
			else {
				System.out.println("Não foi possível cadastrar o problema: " + descProblema);
			}
		} 
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	public Problema buscarProblema(int codProblema) {
		return null;
	}

	public void encerrarProblema(int codProblema) {

	}

	public ArrayList<Entrada> consultarHistoricoEntrada(int codProblema) {
		return null;
	}

	public void registrarEntrada(int codEntrada, Date dataPostada, String descricao, String statusProblema,
			int codHistorico, int matriculaFunc) {

	}

	public void cadastrarFuncionario(int matricula, String nome, String funcao, String rua, String bairro, String cep, String cidade, ArrayList<Telefone> telefones) {
		Funcionario f = new Funcionario();
		try {
			f.setMatricula(matricula);
			f.setNome(nome);
			f.setFuncao(funcao);
			f.setRua(rua);
			f.setBairro(bairro);
			f.setCep(cep);
			f.setCidade(cidade);
			f.setTelefones(telefones);
			if (funcDAO.cadastrarFuncionario(f) == true && telefoneDAO.adicionarTelefone(f, telefones) == true) {
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
			if (funcDAO.atualizarDados(matriculaFunc, tipoDado, valor) == true) {
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
			
			if (telefoneDAO.atualizarTelefone(matriculaFunc, numeroAntigo, numeroNovo) == true) {
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
		Funcionario f = new Funcionario();
		try {

			if (funcDAO.buscarFuncionario(matriculaFunc) != null) {
				f.setMatricula(funcDAO.buscarFuncionario(matriculaFunc).getMatricula());
				f.setNome(funcDAO.buscarFuncionario(matriculaFunc).getNome());
				f.setFuncao(funcDAO.buscarFuncionario(matriculaFunc).getFuncao());
				f.setRua(funcDAO.buscarFuncionario(matriculaFunc).getRua());
				f.setBairro(funcDAO.buscarFuncionario(matriculaFunc).getBairro());
				f.setCep(funcDAO.buscarFuncionario(matriculaFunc).getCep());
				f.setCidade(funcDAO.buscarFuncionario(matriculaFunc).getCidade());
				f.setTelefones(funcDAO.buscarFuncionario(matriculaFunc).getTelefones());
				
				return f;
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

	public void removerFuncionario(int matriculaFunc) {

		try {
			if (funcDAO.removerFuncionario(matriculaFunc) == true) {
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

}
