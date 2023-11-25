package ua.cn.stu.remotelabs;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
@Local
public class UserTableModule implements ITableModule {
	
	private EntityManager em;
	
	// try to log into the system
	public boolean login(User user, String username, String password) {
		if (checkIfNotEmpty(username, password)) {
			if (user.getPassword().startsWith(password) 
					&& user.getEmail().startsWith(username)) {
				return true;
			} else {
				return false;
			}
			// do query to the DB
		} else {
			return false;
		}
	}
	
	// check if user has entered username and password
	public boolean checkIfNotEmpty(String username, String password) {
		if (username != null && password != null && 
				username.length() > 0 && password.length() > 0) {
			return true;
		} else { 
			return false;
		}
	}

	// add new user
	@Override
	public int add(Object obj) {
		User user = (User) obj;
		if (user == null) {
			return 1;
		}
		em.persist(user);
		// query to the DB
		return 0;
	}

	// edit existing user
	@Override
	public int edit(Object obj, int id) {
		User user = findById(id);
		User userObj = (User) obj;
		if (obj == null || user == null) {
			return 1;
		}
		user.setId(userObj.getId());
		user.setAddName(userObj.getAddName());
		user.setFirstName(userObj.getFirstName());
		user.setLastName(userObj.getLastName());
		user.setEmail(userObj.getEmail());
		user.setPassword(userObj.getPassword());
		user.setGroupId(userObj.getGroupId());
		user.setLaboratoryId(userObj.getLaboratoryId());
		user.setFacultyId(userObj.getFacultyId());
		user.setRoleId(userObj.getRoleId());
		em.merge(user);
		// query to the DB
		return 0;
	}
	
	// delete user by id
	@Override
	public int delete(int id) {
		User user = findById(id);
		if (user == null) {
			return 1;
		}
		em.remove(user);
		// query to the DB
		return 0;
	}

	// find user by id
	@Override
	public User findById(int id) {
		if (id < 0) {
			return null;
		} else {
		// query to the DB
		return em.find(User.class, id);
		}
	}

	@Override
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}	
	
}
