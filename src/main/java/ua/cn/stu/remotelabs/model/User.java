package ua.cn.stu.remotelabs.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

// Domain Object "User"
@Entity
@NamedQuery(name="User.findLoginData", 
query="SELECT u FROM User u WHERE u.email "
		+ "LIKE :emailText "
		+ "AND u.password LIKE :passwordText")
public class User extends DomainObject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String lastName;
	private String firstName;
	private String addName;
	private String email;
	private String password;
	
	@OneToOne
	private Role userRole;
	
	@OneToOne
	private Grupa userGrupa;
	
	@OneToOne
	private Faculty userFaculty;
	
	public User() {};
	
	public User(String lastName, String firstName, 
			String addName, String email, String password) {
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

	public int getId() {
		return id;
	}
	
	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	
	public void setUserGrupa(Grupa userGrupa) {
		this.userGrupa = userGrupa;
	}
	
	public void setUserFaculty(Faculty userFaculty) {
		this.userFaculty = userFaculty;
	}
	
	public Faculty getUserFaculty() {
		return userFaculty;
	}
	
	public Grupa getUserGrupa() {
		return userGrupa;
	}
	
	public Role getUserRole() {
		return userRole;
	}
	
}
