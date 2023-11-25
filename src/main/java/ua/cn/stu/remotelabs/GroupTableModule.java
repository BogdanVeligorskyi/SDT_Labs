package ua.cn.stu.remotelabs;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
@Local
public class GroupTableModule implements ITableModule {

	private EntityManager em;

	// add new group
	@Override
	public int add(Object obj) {
		Group group = (Group) obj;
		if (group == null) {
			return 1;
		}
		em.persist(group);
		// query to the DB
		return 0;
	}

	// edit existing group
	@Override
	public int edit(Object obj, int id) {
		Group group = findById(id);
		Group groupObj = (Group) obj;
		if (obj == null || group == null) {
			return 1;
		}
		group.setId(groupObj.getId());
		group.setGroup(groupObj.getGroup());
		em.merge(group);
		// query to the DB
		return 0;
	}

	// delete group by id
	@Override
	public int delete(int id) {
		Group group = findById(id);
		if (group == null) {
			return 1;
		}
		em.remove(group);
		// query to the DB
		return 0;
	}

	// find faculty by id
	@Override
	public Group findById(int id) {
		if (id < 0) {
			return null;
		} else {
			// query to the DB
			return em.find(Group.class, id);
		}
	}

	public EntityManager getEntityManager() {
		return em;
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

}
