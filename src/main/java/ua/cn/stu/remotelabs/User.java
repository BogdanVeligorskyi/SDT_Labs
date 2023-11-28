package ua.cn.stu.remotelabs;

// Domain Object "User"
public class User extends DomainObject {
	
	private String lastName;
	private String firstName;
	private String addName;
	private String email;
	private String password;
	
	private int groupId;
	private int facultyId;
	private int roleId;
	private int laboratoryId;
	
	public User(int id, String lastName, String firstName, 
			String addName, String email, String password,
			int groupId, int facultyId, int roleId,
			int laboratoryId) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.addName = addName;
		this.email = email;
		this.password = password;
		this.groupId = groupId;
		this.facultyId = facultyId;
		this.roleId = roleId;
		this.laboratoryId = laboratoryId;
	}

	public int getGroupId() {
		return groupId;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public int getRoleId() {
		return roleId;
	}

	public int getLaboratoryId() {
		return laboratoryId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public void setLaboratoryId(int laboratoryId) {
		this.laboratoryId = laboratoryId;
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
