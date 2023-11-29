package ua.cn.stu.remotelabs;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

// Domain object "Sensor"
@Entity
public class Sensor extends DomainObject {
	
	private String sensorName;
	private String measurement;
	private boolean isActive;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	private Laboratory laboratory;
	
	@OneToMany(mappedBy="sensor")
	private List<Result> results;
	
	public List<Result> getResults() {
		return this.results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}
	
	public Sensor() {};
	
	public Sensor(int id, String sensorName, 
			String measurement, boolean isActive) {
		this.id = id;
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
	
}
