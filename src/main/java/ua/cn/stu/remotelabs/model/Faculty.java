package ua.cn.stu.remotelabs.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

// Domain object "Faculty"
@Entity
public class Faculty extends DomainObject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String facultyName;
	
	@OneToOne(mappedBy="userFaculty")
	private User user;
	
	@OneToMany(mappedBy="faculty", cascade = CascadeType.ALL)
	private List<Laboratory> laboratories;
	
	public Faculty() {};
	
	public Faculty(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	
	public List<Laboratory> getLaboratories() {
		return this.laboratories;
	}
	
	public void setLaboratories
	(List<Laboratory> laboratories) {
		this.laboratories = laboratories;
	}
	
	public int getId() {
		return id;
	}

}
