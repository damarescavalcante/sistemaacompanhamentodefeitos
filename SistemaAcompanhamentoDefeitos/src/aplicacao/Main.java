package aplicacao;

import org.hibernate.dialect.identity.HSQLIdentityColumnSupport;

import logica.HistoricoEntrada;

public class Main {

	public static void main(String[] args) {
		
		FacadeJDBC facadeJDBC = new FacadeJDBC();
		
		/* Dado erro 
		 * -------------------------------------- */
	
		
		/* Funcionando - Produto
		 * -------------------------------------- */
		//System.out.println(facadeJDBC.buscarProduto(2));
		//facadeJDBC.removerProduto(1);
		//facadeJDBC.cadastrarProduto("SisConcur", "Sistema de Gerenciamento de Concursos Públicos");
		//facadeJDBC.atualizarDescricaoProduto(3, "Sistema de Cadastro de Bolos");		

		/* Funcionando - Funcionario
		 * -------------------------------------- */
		//facadeJDBC.removerFuncionario(5);
		/*
		Telefone t1 = new Telefone();
		t1.setNumero("9999-9999");
		
		Telefone t2 = new Telefone();
		t2.setNumero("9999-0000");
		ArrayList<Telefone> telefones = new ArrayList<Telefone>();
		telefones.add(t1);
		telefones.add(t2);
		facadeJDBC.cadastrarFuncionario(5, "Zefa", "Desenvolvedor", "Rua do Carmo", "Vila dos Testes", "57607-890", "Cidade do Software", telefones);
		*/
		//System.out.println(facadeJDBC.buscarFuncionario(5));
		//facadeJDBC.atualizarDadosFuncionario(6, "funcao", "Engenheiro");
		//facadeJDBC.atualizarTelefone(5, "9999-9999", "0000-0000");
		
		/* Funcionando - Telefone
		 * -------------------------------------- */
		
		/* Funcionando - Problema
		 * -------------------------------------- */
		HistoricoEntrada historico = new HistoricoEntrada();
		facadeJDBC.cadastrarProblema("Sistema não cadastra", "29/09/1111", 2, 9, historico);
	}
	
}
