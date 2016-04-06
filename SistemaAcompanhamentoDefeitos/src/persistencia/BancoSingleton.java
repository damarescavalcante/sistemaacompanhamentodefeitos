package persistencia;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.List;

public class BancoSingleton {

	private Connection conexao;
	private Statement stm;
	private static BancoSingleton instance = null;
	private EntityManagerFactory factory;
	private EntityManager manager;

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
		factory = Persistence.createEntityManagerFactory("sistemadefeitos");
		manager = factory.createEntityManager();
		manager.getTransaction().begin();
	}

	// fechar sessão
	public void fecharSessao() {
		manager.close();
		factory.close();
	}

	// salvar objeto no banco e comitar
	public void comitarObjetoSalvo(Object obj) {
		manager.persist(obj);
		manager.getTransaction().commit();
	}

	// retornar objeto do banco

	public Object recuperarObjeto(String sql) {
		Query query = manager.createQuery(sql);
		Object lista = query.getSingleResult();
		return lista;
	}

	public List<Object> recuperarListaObjeto(String sql) {
		Query query = manager.createQuery(sql);
		List<Object> lista = query.getResultList();
		return lista;
	}

	public void updateHibernate(Object obj) {
		manager.merge(obj);
		manager.getTransaction().commit();
	}

	public void removeHibernate(Object obj) {
		manager.remove(obj);
		manager.getTransaction().commit();
	}

}
