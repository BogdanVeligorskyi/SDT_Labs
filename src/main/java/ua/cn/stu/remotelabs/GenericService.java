package ua.cn.stu.remotelabs;

import javax.persistence.EntityManager;

public abstract class GenericService {
	
	private EntityManager em;
	
	public int create(DomainObject obj) {
		if (obj == null) {
			return 1;
		}
		em.persist(obj);
		// query to the DB
		return 0; 
	}

	public int update(DomainObject obj, String className, int id) {
		DomainObject domainObject = read(className, id);
		if (obj == null || domainObject == null) {
			return 1;
		}
		em.merge(obj);
		// query to the db
		return 0;
	}

	public int delete(String className, int id) {
		DomainObject domainObj = read(className, id);
		if (domainObj == null) {
			return 1;
		}
		// query to the db
		em.remove(domainObj);
		return 0;
	}

	public DomainObject read(String className, int id) {
		Class cls = null;
		try {
			cls = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (id < 0) {
			return null;
		}
		// query to the db
		
		return (DomainObject) em.find(cls, id);
		
	}
	
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
}
