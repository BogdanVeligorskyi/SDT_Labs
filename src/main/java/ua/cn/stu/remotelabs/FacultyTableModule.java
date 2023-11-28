package ua.cn.stu.remotelabs;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local
public class FacultyTableModule extends GenericService {

	// add new faculty
	public int add(Faculty faculty) {
		return super.create(faculty);
	}

	// edit existing faculty
	public int edit(Faculty faculty, int id) {
		return super.update(faculty, "ua.cn.stu.remotelabs.Faculty", id);
	}

	// delete faculty by id
	public int remove(int id) {
		return super.delete("ua.cn.stu.remotelabs.Faculty", id);
	}

	// find faculty by id
	public Faculty find(int id) {
		return (Faculty) super.read("ua.cn.stu.remotelabs.Faculty", id);
	}

}