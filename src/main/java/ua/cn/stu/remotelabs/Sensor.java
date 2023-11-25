package ua.cn.stu.remotelabs;

// Domain object "Sensor"
public class Sensor {
	
	private int id;
	private String sensorName;
	private String measurement;
	private boolean isActive;
	private int laboratoryId;

	public Sensor(int id, String sensorName, 
			String measurement, boolean isActive,
			int laboratoryId) {
		this.id = id;
		this.sensorName = sensorName;
		this.measurement = measurement;
		this.isActive = isActive;
		this.laboratoryId = laboratoryId;
	}
	
	public int getId() {
		return id;
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
	
	public void setId(int id) {
		this.id = id;
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
	
	public int getLaboratoryId() {
		return laboratoryId;
	}

	public void setLaboratoryId(int laboratoryId) {
		this.laboratoryId = laboratoryId;
	}
	
}
