package ua.cn.stu.remotelabs.table;

import javax.ejb.Local;
import javax.ejb.Stateless;
import ua.cn.stu.remotelabs.model.Laboratory;

@Stateless
@Local
public class LaboratoryTableModule extends GenericService {

	// add new laboratory
	public int add(Laboratory laboratory) {
		return super.create(laboratory);
	}

	// edit existing Laboratory
	public int edit(Laboratory laboratory, int id) {
		return super.update(laboratory, 
				"ua.cn.stu.remotelabs.model.Laboratory", id);
	}

	// delete Laboratory by id
	public int remove(int id) {
		return super.delete(
				"ua.cn.stu.remotelabs.model.Laboratory", id);
	}

	// find laboratory by id
	public Laboratory find(int id) {
		return (Laboratory) super.read(
				"ua.cn.stu.remotelabs.model.Laboratory", id);
	}
	
	// get corps # from lab name
	public int getCorps(String labName) {
		if (!checkLabName(labName)) {
			return -1;
		}
		String[] str = labName.split("-");
		return Integer.parseInt(str[0]);
	}
	
	// get room # from lab name
	public int getRoom(String labName) {
		if (!checkLabName(labName)) {
			return -1;
		}
		String[] str = labName.split("-");
		return Integer.parseInt(str[1]);
	}

	// check if lab format is something like "C-RR"
	// (C - Corps, R - Room)
	public boolean checkLabName(String labName) {
		if (labName == null || !labName.contains("-") 
				|| labName.charAt(0) == '-' 
				|| labName.charAt
				(labName.length()-1) == '-') {
			return false;
		} else {
			return true;
		}
	}

}
