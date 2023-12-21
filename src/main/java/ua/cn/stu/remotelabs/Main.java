package ua.cn.stu.remotelabs;

import java.sql.Connection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.cn.stu.remotelabs.model.Faculty;

// simple test of CREATE operation
public class Main {

	public static void main(String[] args) {
		Connection conn = DbConnector.getConnection();
		System.out.println(conn);
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory
				("RemoteLabs");
		EntityManager em = emf.createEntityManager();
		Faculty fac = new Faculty("EIT");
		//FacultyTableModule ftm = new FacultyTableModule();
		//ftm.setEntityManager(em);
		em.getTransaction().begin();
		em.persist(fac);
		em.getTransaction().commit();
		//ftm.add(fac, em);
	}

}
