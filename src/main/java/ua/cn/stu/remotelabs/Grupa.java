package ua.cn.stu.remotelabs;

// Domain object "Grupa"
public class Grupa extends DomainObject {
	
	private String grupa;
	
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
