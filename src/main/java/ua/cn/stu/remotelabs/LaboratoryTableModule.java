package ua.cn.stu.remotelabs;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
@Local
public class LaboratoryTableModule implements ITableModule {

	private EntityManager em;

	// add new laboratory
	@Override
	public int add(Object obj) {

		Laboratory lab = (Laboratory) obj;
		if (lab == null) {
			return 1;
		}
		em.persist(lab);
		// query to the DB
		return 0;
	}

	// edit existing laboratory
	@Override
	public int edit(Object obj, int id) {
		Laboratory lab = findById(id);
		Laboratory labObj = (Laboratory) obj;
		if (obj == null || lab == null) {
			return 1;
		}
		lab.setId(labObj.getId());
		lab.setLabName(labObj.getLabName());
		lab.setFacultyId(lab.getFacultyId());
		em.merge(lab);
		// query to the DB
		return 0;
	}

	// delete laboratory by id
	@Override
	public int delete(int id) {
		Laboratory lab = findById(id);
		if (lab == null) {
			return 1;
		}
		em.remove(lab);
		// query to the DB
		return 0;
	}

	// find laboratory by id
	@Override
	public Laboratory findById(int id) {
		if (id < 0) {
			return null;
		} else {
			// query to the DB
			return em.find(Laboratory.class, id);
		}
	}

	public EntityManager getEntityManager() {
		return em;
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

}
