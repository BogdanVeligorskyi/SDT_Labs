package ua.cn.stu.remotelabs.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

// Domain object "Sensor"
@Entity
public class Sensor extends DomainObject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String sensorName;
	private String measurement;
	private boolean isActive;
	
	@ManyToOne
	private Laboratory laboratory;
	
	@OneToMany(mappedBy="sensor",cascade={CascadeType.ALL})
	private List<Result> results;
	
	public Sensor() {};
	
	public Sensor(String sensorName, 
			String measurement, boolean isActive) {
		this.sensorName = sensorName;
		this.measurement = measurement;
		this.isActive = isActive;
	}
	
	public String getSensorName() {
		return sensorName;
	}
	
	public String getMeasurement() {
		return measurement;
	}
	
	public boolean getIsActive() {
		return isActive;
	}
	
	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}
	
	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}
	
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public void setLaboratory(Laboratory laboratory) {
		this.laboratory = laboratory;
	}
	
	public Laboratory getLaboratory() {
		return laboratory;
	}
	
	public List<Result> getResults() {
		return this.results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}
	
	public int getId() {
		return id;
	}
	
}
