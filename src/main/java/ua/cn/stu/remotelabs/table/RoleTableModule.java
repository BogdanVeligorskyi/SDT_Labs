package ua.cn.stu.remotelabs.table;

import javax.ejb.Local;
import javax.ejb.Stateless;
import ua.cn.stu.remotelabs.model.Role;

@Stateless
@Local
public class RoleTableModule extends GenericService {	

	// add new role
	public int add(Role role) {
		return super.create(role);
	}

	// edit existing role
	public int edit(Role role, int id) {
		return super.update(role, 
				"ua.cn.stu.remotelabs.model.Role", id);
	}

	// delete role by id
	public int remove(int id) {
		return super.delete(
				"ua.cn.stu.remotelabs.model.Role", id);
	}

	// find role by id
	public Role find(int id) {
		return (Role) super.read(
				"ua.cn.stu.remotelabs.model.Role", id);
	}
	
	// get some basic permissions
	public String getPermissions(String roleName) {
		if (roleName == null || roleName.length()==0) {
			return null;
		}
		if (roleName.startsWith("Admin")) {
			return "Admin permissions";
		}
		if (roleName.startsWith("Teacher")) {
			return "Teacher permissions";
		}
		if (roleName.startsWith("Student")) {
			return "Student permissions";
		}
		return "Unknown permissions";
	}

}
