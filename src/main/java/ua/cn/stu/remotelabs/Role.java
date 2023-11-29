package ua.cn.stu.remotelabs;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

// Domain object "Role"
@Entity
public class Role extends DomainObject {
	
	private String roleName;
	
	@OneToOne(mappedBy="role")
	private User user;
	
	public Role() {};
	
	public Role(int id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
