package ua.cn.stu.remotelabs;

// Domain object "Faculty"
public class Faculty extends DomainObject {
	
	private String facultyName;
	
	public Faculty(int id, String facultyName) {
		this.id = id;
		this.facultyName = facultyName;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

}
