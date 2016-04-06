package aplicacao;

import java.util.ArrayList;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import logica.Funcionario;
import logica.Produto;
import logica.Telefone;
import persistencia.FuncionarioDAO_Hibernate;
import persistencia.ProdutoDAO_Hibernate;
import persistencia.TelefoneDAO_Hibernate;

public class Main {

	public static void main(String[] args) {

		FacadeJDBC facadeJDBC = new FacadeJDBC();

		/*
		 * Dado erro --------------------------------------
		 */

		/*
		 * Funcionando - Produto --------------------------------------
		 */
		// System.out.println(facadeJDBC.buscarProduto(2));
		// facadeJDBC.removerProduto(1);
		// facadeJDBC.cadastrarProduto("SisConcur", "Sistema de Gerenciamento de
		// Concursos Públicos");
		// facadeJDBC.atualizarDescricaoProduto(3, "Sistema de Cadastro de
		// Bolos");

		/*
		 * Funcionando - Funcionario --------------------------------------
		 */
		// facadeJDBC.removerFuncionario(7);
		/*
		 * Telefone t1 = new Telefone(); t1.setNumero("9999-9999");
		 * 
		 * Telefone t2 = new Telefone(); t2.setNumero("9999-0000");
		 * ArrayList<Telefone> telefones = new ArrayList<Telefone>();
		 * telefones.add(t1); telefones.add(t2);
		 * facadeJDBC.cadastrarFuncionario(5, "Zefa", "Desenvolvedor",
		 * "Rua do Carmo", "Vila dos Testes", "57607-890", "Cidade do Software",
		 * telefones);
		 */
		// System.out.println(facadeJDBC.buscarFuncionario(4));
		// facadeJDBC.atualizarDadosFuncionario(5, "funcao", "Engenheiro");
		// facadeJDBC.atualizarTelefone(5, "9999-9999", "0000-0000");

		/*
		 * Funcionando - Telefone --------------------------------------
		 */

		/*
		 * Funcionando - Problema --------------------------------------
		 */
		// HistoricoEntrada historico = new HistoricoEntrada();
		// facadeJDBC.cadastrarProblema("Teste 2", "12/10/2015", 2, 4,
		// historico);
		// System.out.println(facadeJDBC.buscarProblema(10));
		// facadeJDBC.encerrarProblema(1);
		// facadeJDBC.atualizarDescricaoProblema(12, "Teste 3");
		// facadeJDBC.adicionarHistoricoProblema(15);
		// System.out.println(facadeJDBC.consultarHistoricoEntrada(14));

		/*
		 * Funcionando - Entrada --------------------------------------
		 */

		// facadeJDBC.registrarEntrada(new Date(), "Finalização do problema",
		// "Finalizado", 14, 2);
		// facadeJDBC.removerEntrada(3);

		// HIBERNATE

		FacadeHibernate facadeHibernate = new FacadeHibernate();
		//facadeHibernate.cadastrarProduto("FevereiroShow", "Sistema de Controle Shows de Carnaval");
		//System.out.println(facadeHibernate.buscarProduto("SisCalc"));
		// System.out.println(facadeHibernate.buscarProduto(1));
		//facadeHibernate.atualizarDescricao(3, "Sistema de Cadastro de Bolos de Chocolate");
		//facadeHibernate.removerProduto(3);
		
		/*

		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemadefeitos");
		//factory.close();
		
		FuncionarioDAO_Hibernate fDAO = new FuncionarioDAO_Hibernate();
		
		Funcionario f = new Funcionario();
		f.setNome("danakfn");
		f.setCep("66666-000");
		f.setFuncao("kkkk");
		f.setBairro("kkkkk");
		f.setCidade("kkkkk");
		f.setRua("kkkkkk");
		f.setTelefones(telefones);
		*/
		//fDAO.cadastrarFuncionario(f);
		//facadeHibernate.removerFuncionario(5);
		//facadeHibernate.atualizarDadosFuncionario(6, "funcao", "Gerente de Projetos");
		//System.out.println(facadeHibernate.buscarFuncionario("Fábio Santos", "45555-000"));
		/*
		Telefone t1 = new Telefone();
		t1.setNumero("1177-7773");
		
		Telefone t2 = new Telefone();
		t2.setNumero("0110-0101");
		
		ArrayList<Telefone> telefones = new ArrayList<Telefone>();
		telefones.add(t1);
		telefones.add(t2);
		//facadeHibernate.cadastrarFuncionario("Carlos", "Engenheiro", "Rua das Dores", "Vila dos Idosos", "11009-000", "Palmeira das Almas", telefones);
		*/
		//TelefoneDAO_Hibernate tDAO = new TelefoneDAO_Hibernate();
		//Funcionario f1 = facadeHibernate.buscarFuncionario(9);
		
		//tDAO.adicionarTelefone(f1, telefones);
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemadefeitos");
		//factory.close();
		//System.out.println(facadeHibernate.buscarTelefone("0110-0101"));
		//System.out.println(facadeHibernate.buscarTelefones(1));
		facadeHibernate.atualizarTelefone(1, "2222-2222", "3333-3333");
	}

}
