package ua.cn.stu.remotelabs.model;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

// Domain object "Role"
@Entity
public class Role extends DomainObject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String roleName;
	
	@OneToOne(mappedBy="userRole", cascade = CascadeType.ALL)
	private User user;
	
	public Role() {};
	
	public Role(String roleName) {
		this.roleName = roleName;
	}
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public int getId() {
		return id;
	}
	
}
