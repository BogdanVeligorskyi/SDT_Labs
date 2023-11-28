package ua.cn.stu.remotelabs;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local
public class ResultTableModule extends GenericService {

	// add new result
	public int add(Result result) {
		return super.create(result);
	}

	// edit existing result
	public int edit(Result result, int id) {
		return super.update(result, "ua.cn.stu.remotelabs.Result", id);
	}

	// delete result by id
	public int remove(int id) {
		return super.delete("ua.cn.stu.remotelabs.Result", id);
	}

	// find result by id
	public Result find(int id) {
		return (Result) super.read("ua.cn.stu.remotelabs.Result", id);
	}

}
