package ua.cn.stu.remotelabs;

// Domain object "Laboratory"
public class Laboratory {
	
	private int id;
	private String labName;
	private int facultyId;
	
	public Laboratory(int id, String labName, int facultyId) {
		this.id = id;
		this.labName = labName;
		this.facultyId = facultyId;
	}

	public int getId() {
		return id;
	}

	public String getLabName() {
		return labName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}
	
	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	
}
