package ua.cn.stu.remotelabs;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local
public class UserTableModule extends GenericService {

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
	public int add(User user) {
		return super.create(user);
	}

	// edit existing user
	public int edit(User user, int id) {
		return super.update(user, "ua.cn.stu.remotelabs.User", id);
	}

	// delete user by id
	public int remove(int id) {
		return super.delete("ua.cn.stu.remotelabs.User", id);
	}

	// find user by id
	public User find(int id) {
		return (User) super.read("ua.cn.stu.remotelabs.User", id);
	}

}
