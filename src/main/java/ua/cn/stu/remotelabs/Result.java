package ua.cn.stu.remotelabs;

// Domain object "Result"
public class Result extends DomainObject {
	
	private double value;
	private String mark;
	private String datetime;
	private int sensorId;
	
	public Result(int id, double value, String mark, 
			String datetime, int sensorId) {
		this.id = id;
		this.value = value;
		this.mark = mark;
		this.datetime = datetime;
		this.sensorId = sensorId;
	}
	
	public double getValue() {
		return value;
	}
	
	public String getMark() {
		return mark;
	}
	
	public String getDatetime() {
		return datetime;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public int getSensorId() {
		return sensorId;
	}

	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}
	
}
