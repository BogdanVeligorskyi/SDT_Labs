package ua.cn.stu.remotelabs;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

// Domain object "Faculty"
@Entity
public class Faculty extends DomainObject {
	
	private String facultyName;
	
	@OneToOne (mappedBy="faculty")
	private User user;
	
	@OneToMany(mappedBy="laboratory")
	private List<Laboratory> laboratories;
	
	public List<Laboratory> getLaboratories() {
		return this.laboratories;
	}
	
	public void setLaboratories(List<Laboratory> laboratories) {
		this.laboratories = laboratories;
	}
	
	public Faculty() {};
	
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
