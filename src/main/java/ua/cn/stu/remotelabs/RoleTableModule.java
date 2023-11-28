package ua.cn.stu.remotelabs;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local
public class RoleTableModule extends GenericService {	

	// add new role
	public int add(Role role) {
		return super.create(role);
	}

	// edit existing role
	public int edit(Role role, int id) {
		return super.update(role, "ua.cn.stu.remotelabs.Role", id);
	}

	// delete role by id
	public int remove(int id) {
		return super.delete("ua.cn.stu.remotelabs.Role", id);
	}

	// find role by id
	public Role find(int id) {
		return (Role) super.read("ua.cn.stu.remotelabs.Role", id);
	}


}
