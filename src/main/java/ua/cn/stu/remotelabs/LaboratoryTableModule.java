package ua.cn.stu.remotelabs;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local
public class LaboratoryTableModule extends GenericService {

	// add new laboratory
	public int add(Laboratory laboratory) {
		return super.create(laboratory);
	}

	// edit existing Laboratory
	public int edit(Laboratory laboratory, int id) {
		return super.update(laboratory, "ua.cn.stu.remotelabs.Laboratory", id);
	}

	// delete Laboratory by id
	public int remove(int id) {
		return super.delete("ua.cn.stu.remotelabs.Laboratory", id);
	}

	// find laboratory by id
	public Laboratory find(int id) {
		return (Laboratory) super.read("ua.cn.stu.remotelabs.Laboratory", id);
	}


}
