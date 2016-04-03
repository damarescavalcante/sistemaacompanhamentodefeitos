package aplicacao;

import java.util.Date;

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

			if (produtoDAO.cadastrarProduto(p)) {
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
			if (produtoDAO.atualizarDescricao(codProduto, descFuncao)) {
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
			if (produtoDAO.removerProduto(codProduto)) {
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

	public void cadastrarProblema(String descProblema, String dataIdentificacao, int codProduto, int matriculaFunc,
			HistoricoEntrada historico) {
		Problema p = new Problema();
		Funcionario f = buscarFuncionario(matriculaFunc);
		Produto produto = buscarProduto(codProduto);
		try {
			p.setDescricao(descProblema);
			p.setDataIdentificacao(dataIdentificacao);
			p.setProduto(produto);
			p.setFuncionario(f);
			historico.setProblema(p);

			if (problemaDAO.cadastrarProblema(p) && historicoDAO.adicionarHistoricoProblema(historico)) {
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

	public void adicionarHistoricoProblema(int codProblema) {

		try {

			if (problemaDAO.adicionarHistoricoProblema(codProblema)) {
				System.out.println("Histórico adicionado ao problema " + codProblema + " com sucesso!");
			}

			else {
				System.out.println("Não foi possível adicionar o histórico ao problema!");
			}

		}

		catch (Exception e) {

		}

	}

	public Problema buscarProblema(int codProblema) {

		try {

			if (problemaDAO.buscarProblema(codProblema) != null) {
				return problemaDAO.buscarProblema(codProblema);
			}

			else {
				System.out.println("Não foi possível buscar o problema " + codProblema);
				return null;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public void encerrarProblema(int codProblema) {

		try {

			if (problemaDAO.encerrarProblema(codProblema)) {
				System.out.println("Problema " + codProblema + " encerrado com sucesso!");
			} else {
				System.out.println("Não foi possível encerrar o problema!");
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void atualizarDescricaoProblema(int codProblema, String descricao) {

		try {

			if (problemaDAO.atualizarDescricao(codProblema, descricao)) {
				System.out.println("Descrição do problema " + codProblema + " atualizada com sucesso!");
			}

			else {
				System.out.println("Não foi possível atualizar a descrição do problema " + codProblema);
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public ArrayList<Entrada> consultarHistoricoEntrada(int codProblema) {
		
		try {
			
			if (problemaDAO.consultarHistorico(codProblema) != null) {
				return problemaDAO.consultarHistorico(codProblema);
			}
			
			else {
				System.out.println("Não foi possível consultar o histórico do problema " + codProblema);
				return null;
			}
			
		} 
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

	public void registrarEntrada(Date dataPostada, String descricao, String statusProblema, int codProblema,
			int matriculaFunc) {
		Problema p = buscarProblema(codProblema);
		HistoricoEntrada h = new HistoricoEntrada();
		Funcionario f = buscarFuncionario(matriculaFunc);
		Entrada e = new Entrada();
		h.setProblema(p);
		try {
			e.setDataPostada(dataPostada);
			e.setDescricao(descricao);
			e.setStatusProblema(statusProblema);
			e.setHistorico(h);
			e.setFuncionario(f);

			if (entradaDAO.registrarEntrada(e)) {
				System.out.println("Entrada: " + descricao + " registrada com sucesso!");
			}

			else {
				System.out.println("Não foi possível registrar a entrada: " + descricao);
			}
		}

		catch (Exception e2) {
			System.out.println(e2.getMessage());
		}

	}

	public void removerEntrada(int codEntrada) {

		try {

			if (entradaDAO.removerEntrada(codEntrada)) {
				System.out.println("Entrada " + codEntrada + " removida com sucesso!");
			}

			else {
				System.out.println("Não foi possível remover a entrada " + codEntrada);
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void cadastrarFuncionario(int matricula, String nome, String funcao, String rua, String bairro, String cep,
			String cidade, ArrayList<Telefone> telefones) {
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
