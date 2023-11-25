package ua.cn.stu.remotelabs;

// Domain object "Faculty"
public class Faculty {
	
	private int id;
	private String facultyName;
	
	
	public Faculty(int id, String facultyName) {
		this.id = id;
		this.facultyName = facultyName;
	}

	public int getId() {
		return id;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

}
