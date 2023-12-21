package ua.cn.stu.remotelabs.model;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

// Domain object "Grupa"
@Entity
public class Grupa extends DomainObject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String grupa;
	
	@OneToOne(mappedBy="userGrupa", cascade = CascadeType.ALL)
	private User user;
	
	public Grupa() {};
	
	public Grupa(String grupa) {
		this.grupa = grupa;
	}
	
	public String getGrupa() {
		return grupa;
	}
	
	public void setGrupa(String grupa) {
		this.grupa = grupa;
	}
	
	public int getId() {
		return id;
	}

}
