package ua.cn.stu.remotelabs;

// Domain object "Group"
public class Group {
	
	private int id;
	private String group;
	
	public Group(int id, String group) {
		this.id = id;
		this.group = group;
	}
	
	public int getId() {
		return id;
	}
	
	public String getGroup() {
		return group;
	}
	
	public void setId(int id) {
		 this.id = id;
	}
	
	public void setGroup(String group) {
		this.group = group;
	}

}
