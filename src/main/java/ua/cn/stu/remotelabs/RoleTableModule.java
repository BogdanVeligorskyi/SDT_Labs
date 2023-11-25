package ua.cn.stu.remotelabs;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
@Local
public class RoleTableModule implements ITableModule {

	private EntityManager em;

	// add new role
	@Override
	public int add(Object obj) {
		
		Role role = (Role) obj;
		if (role == null) {
			return 1;
		}
		em.persist(role);
		// query to the DB
		return 0;
	}

	// edit existing role
	@Override
	public int edit(Object obj, int id) {
		Role role = findById(id);
		Role roleObj = (Role) obj;
		if (obj == null || role == null) {
			return 1;
		}
		role.setId(roleObj.getId());
		role.setRoleName(roleObj.getRoleName());
		em.merge(role);
		// query to the DB
		return 0;
	}

	// delete role by id
	@Override
	public int delete(int id) {
		Role role = findById(id);
		if (role == null) {
			return 1;
		}
		em.remove(role);
		// query to the DB
		return 0;
	}

	// find role by id
	@Override
	public Role findById(int id) {
		if (id < 0) {
			return null;
		} else {
		// query to the DB
		return em.find(Role.class, id);
		}
	}
	
	public EntityManager getEntityManager() {
		return em;
	}
	
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
}
