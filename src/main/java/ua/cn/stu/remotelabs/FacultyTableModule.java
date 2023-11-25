package ua.cn.stu.remotelabs;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
@Local
public class FacultyTableModule implements ITableModule {
	
	private EntityManager em;

	// add new faculty
	@Override
	public int add(Object obj) {
		
		Faculty faculty = (Faculty) obj;
		if (faculty == null) {
			return 1;
		}
		em.persist(faculty);
		// query to the DB
		return 0;
	}

	// edit existing faculty
	@Override
	public int edit(Object obj, int id) {
		Faculty faculty = findById(id);
		Faculty facultyObj = (Faculty) obj;
		if (obj == null || faculty == null) {
			return 1;
		}
		faculty.setId(facultyObj.getId());
		faculty.setFacultyName(facultyObj.getFacultyName());
		em.merge(faculty);
		// query to the DB
		return 0;
	}

	// delete faculty by id
	@Override
	public int delete(int id) {
		Faculty faculty = findById(id);
		if (faculty == null) {
			return 1;
		}
		em.remove(faculty);
		// query to the DB
		return 0;
	}

	// find faculty by id
	@Override
	public Faculty findById(int id) {
		if (id < 0) {
			return null;
		} else {
		// query to the DB
		return em.find(Faculty.class, id);
		}
	}
	
	public EntityManager getEntityManager() {
		return em;
	}
	
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	
}
