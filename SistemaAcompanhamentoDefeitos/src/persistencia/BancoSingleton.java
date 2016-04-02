package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BancoSingleton {

	private Connection conexao;
	private Statement stm;
	private static BancoSingleton instance = null;
	private Session session;

	private BancoSingleton() {
	}

	public static BancoSingleton getInstance() {
		if (instance == null) {
			instance = new BancoSingleton();
		}
		return instance;
	}

	// específico do JDBC

	public void abreConexao() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sad_jdbc", "root", "root");
			stm = conexao.createStatement();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void fechaConexao() {
		try {
			stm.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void update(String sql) {
		try {
			stm.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public ResultSet query(String sql) {
		try {
			return stm.executeQuery(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// específico do Hibernate/JPA

	public void criarSessao() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		session.beginTransaction();
	}

	// fechar sessão
	public void fecharSessao() {

		session.close();

	}

	// salvar objeto no banco e comitar
	public void comitarObjetoSalvo(Object obj) {

		session.save(obj);
		session.getTransaction().commit();

	}

	// retornar objeto do banco

}
