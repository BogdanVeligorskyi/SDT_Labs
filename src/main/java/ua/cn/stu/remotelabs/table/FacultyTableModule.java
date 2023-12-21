package ua.cn.stu.remotelabs.table;

import javax.ejb.Local;
import javax.ejb.Stateless;
import ua.cn.stu.remotelabs.model.Faculty;

@Stateless
@Local
public class FacultyTableModule extends GenericService {

	// add new faculty
	public int add(Faculty faculty) {
		return super.create(faculty);
	}

	// edit existing faculty
	public int edit(Faculty faculty, int id) {
		return super.update(faculty, 
				"ua.cn.stu.remotelabs.model.Faculty", id);
	}

	// delete faculty by id
	public int remove(int id) {
		return super.delete(
				"ua.cn.stu.remotelabs.model.Faculty", id);
	}

	// find faculty by id
	public Faculty find(int id) {
		return (Faculty) super.read(
				"ua.cn.stu.remotelabs.model.Faculty", id);
	}
	
	// create abbreviation of faculty name
	public String createAbbreviation(String facultyName) {
		if (facultyName == null) {
			return null;
		}
		String abbreviation = "";
		char[] facultyNameChar = facultyName.toCharArray();
		for (int i = 0; i < facultyNameChar.length; i++) {
			if (Character.isUpperCase
					(facultyNameChar[i])) {
				abbreviation += facultyNameChar[i];
			}
		}
		return abbreviation;
	}
	

}