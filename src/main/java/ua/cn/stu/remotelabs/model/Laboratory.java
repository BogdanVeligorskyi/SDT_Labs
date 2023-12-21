package ua.cn.stu.remotelabs.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

// Domain object "Laboratory"
@Entity
public class Laboratory extends DomainObject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String labName;
	
	@ManyToOne
	private Faculty faculty;
	
	@OneToMany(mappedBy="laboratory",cascade={CascadeType.ALL})
	private List<Sensor> sensors;
	
	public Laboratory() {};
	
	public Laboratory(String labName) {
		this.labName = labName;
	}

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}
	
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
	public Faculty getFaculty() {
		return faculty;
	}
	
	public List<Sensor> getSensors() {
		return this.sensors;
	}
	
	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}
	
	public int getId() {
		return id;
	}
	
}
