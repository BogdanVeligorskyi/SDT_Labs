package ua.cn.stu.remotelabs.table;

import javax.ejb.Local;
import javax.ejb.Stateless;
import ua.cn.stu.remotelabs.model.Grupa;

@Stateless
@Local
public class GrupaTableModule extends GenericService {

	// add new grupa
	public int add(Grupa grupa) {
		return super.create(grupa);
	}

	// edit existing grupa
	public int edit(Grupa grupa, int id) {
		return super.update(grupa, 
				"ua.cn.stu.remotelabs.model.Grupa", id);
	}

	// delete grupa by id
	public int remove(int id) {
		return super.delete(
				"ua.cn.stu.remotelabs.model.Grupa", id);
	}

	// find grupa by id
	public Grupa find(int id) {
		return (Grupa) super.read(
				"ua.cn.stu.remotelabs.model.Grupa", id);
	}
	
	// get year of student first year
	// for instance, KI-191 ~ 2019
	public int getStartYear(String grupaName) {
		if (grupaName == null || !grupaName.contains("-")
				|| grupaName.charAt(0) == '-' 
				|| grupaName.charAt
				(grupaName.length()-1) == '-') {
			return -1;
		}
		String[] grupaNameArr = grupaName.split("-");
		String strYear = "20";
		char[] grupaYearChar = grupaNameArr[1].toCharArray();
		for (int i = 0; i < 2; i++) {
			strYear += grupaYearChar[i];
		}
		return Integer.parseInt(strYear);
	}

}
