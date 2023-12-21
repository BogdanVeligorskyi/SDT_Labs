package ua.cn.stu.remotelabs.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

// Domain object "Result"
@Entity
public class Result extends DomainObject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private double value;
	private String mark;
	private String datetime;
	
	@ManyToOne
	private Sensor sensor;
	
	public Result() {};
	
	public Result(double value, String mark, 
			String datetime) {
		this.value = value;
		this.mark = mark;
		this.datetime = datetime;
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
	
	public int getId() {
		return id;
	}
	
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
	
	public Sensor getSensor() {
		return sensor;
	}
	
}
