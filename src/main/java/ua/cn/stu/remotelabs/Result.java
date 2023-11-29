package ua.cn.stu.remotelabs;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

// Domain object "Result"
@Entity
public class Result extends DomainObject {
	
	private double value;
	private String mark;
	private String datetime;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	private Sensor sensor;
	
	public Result() {};
	
	public Result(int id, double value, String mark, 
			String datetime) {
		this.id = id;
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
	
}
