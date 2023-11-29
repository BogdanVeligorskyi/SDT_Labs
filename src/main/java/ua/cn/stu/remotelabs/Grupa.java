package ua.cn.stu.remotelabs;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

// Domain object "Grupa"
@Entity
public class Grupa extends DomainObject {
	
	private String grupa;
	
	@OneToOne(mappedBy="grupa")
	private User user;
	
	public Grupa() {};
	
	public Grupa(int id, String grupa) {
		this.id = id;
		this.grupa = grupa;
	}
	
	public String getGrupa() {
		return grupa;
	}
	
	public void setGrupa(String grupa) {
		this.grupa = grupa;
	}

}
