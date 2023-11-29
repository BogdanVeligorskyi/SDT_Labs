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
	
	// check format of datetime
	public boolean isDatetimeCorrect(String datetime) {
		if (datetime == null 
				|| datetime.length() == 0 
				|| !datetime.contains(":")) {
			return false;
		}
		return true;
	}
	
	// check datetime interval (from datetime1 to datetime2)
	public int checkDatetimeInterval(String datetime1, 
			String datetime2) {
		if (!isDatetimeCorrect(datetime1) 
				|| !isDatetimeCorrect(datetime2)) {
			return -1;
		}
		System.out.println(datetime1.compareToIgnoreCase(datetime2));
		// compare if datetime1 is newer than datetime2
		if (datetime1.compareToIgnoreCase(datetime2) > 0) {
			
			return -1;
		}
		return 0;
	}

}
