package ua.cn.stu.remotelabs;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

// Domain Object "User"
@Entity
public class User extends DomainObject {
	
	private String lastName;
	private String firstName;
	private String addName;
	private String email;
	private String password;
	
	@OneToOne(mappedBy="user")
	private Faculty faculty;
	
	@OneToOne(mappedBy="user")
	private Role role;
	
	@OneToOne(mappedBy="user")
	private Grupa grupa;
	
	@OneToMany(mappedBy="user")
	private List<Laboratory> laboratories;
	
	public List<Laboratory> getLaboratories() {
		return this.laboratories;
	}
	
	public void setLaboratories(List<Laboratory> laboratories) {
		this.laboratories = laboratories;
	}
	
	public User() {};
	
	public User(int id, String lastName, String firstName, 
			String addName, String email, String password) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.addName = addName;
		this.email = email;
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getAddName() {
		return addName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setAddName(String addName) {
		this.addName = addName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
