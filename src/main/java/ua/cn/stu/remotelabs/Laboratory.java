package ua.cn.stu.remotelabs;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

// Domain object "Laboratory"
@Entity
public class Laboratory extends DomainObject {
	
	private String labName;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	private User user;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private Faculty faculty;
	
	@OneToMany(mappedBy="laboratory")
	private List<Sensor> sensors;
	
	public List<Sensor> getSensors() {
		return this.sensors;
	}
	
	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}
	
	public Laboratory() {};
	
	public Laboratory(int id, String labName) {
		this.id = id;
		this.labName = labName;
	}

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}
	
}
