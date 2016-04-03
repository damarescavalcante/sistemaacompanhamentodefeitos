package aplicacao;

import java.text.SimpleDateFormat;
import java.util.Date;

import logica.HistoricoEntrada;

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
		//facadeJDBC.removerFuncionario(7);
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
		//System.out.println(facadeJDBC.buscarFuncionario(4));
		//facadeJDBC.atualizarDadosFuncionario(5, "funcao", "Engenheiro");
		// facadeJDBC.atualizarTelefone(5, "9999-9999", "0000-0000");

		/*
		 * Funcionando - Telefone --------------------------------------
		 */

		/*
		 * Funcionando - Problema --------------------------------------
		 */
		//HistoricoEntrada historico = new HistoricoEntrada();
		//facadeJDBC.cadastrarProblema("Teste 2", "12/10/2015", 2, 4, historico);
		//System.out.println(facadeJDBC.buscarProblema(10));
		//facadeJDBC.encerrarProblema(1);
		//facadeJDBC.atualizarDescricaoProblema(12, "Teste 3");
		//facadeJDBC.adicionarHistoricoProblema(15);
		//System.out.println(facadeJDBC.consultarHistoricoEntrada(14));
		
		/*
		 * Funcionando - Entrada --------------------------------------
		 */
		
		//facadeJDBC.registrarEntrada(new Date(), "Finalização do problema", "Finalizado", 14, 2);
		//facadeJDBC.removerEntrada(3);
	}

}
