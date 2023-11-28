package ua.cn.stu.remotelabs;

// Domain object "Role"
public class Role extends DomainObject {
	
	private String roleName;
	
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
