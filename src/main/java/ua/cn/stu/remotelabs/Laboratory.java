package ua.cn.stu.remotelabs;

// Domain object "Laboratory"
public class Laboratory extends DomainObject {
	
	private String labName;
	private int facultyId;
	
	public Laboratory(int id, String labName, int facultyId) {
		this.id = id;
		this.labName = labName;
		this.facultyId = facultyId;
	}

	public String getLabName() {
		return labName;
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
