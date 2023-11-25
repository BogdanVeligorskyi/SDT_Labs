package ua.cn.stu.remotelabs;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
@Local
public class ResultTableModule implements ITableModule {

	private EntityManager em;

	// add new result
	@Override
	public int add(Object obj) {
		
		Result result = (Result) obj;
		if (result == null) {
			return 1;
		}
		em.persist(result);
		// query to the DB
		return 0;
	}

	// edit existing result
	@Override
	public int edit(Object obj, int id) {
		Result result = findById(id);
		Result resultObj = (Result) obj;
		if (obj == null || result == null) {
			return 1;
		}
		result.setId(resultObj.getId());
		result.setValue(resultObj.getValue());
		result.setDatetime(resultObj.getDatetime());
		result.setMark(resultObj.getMark());
		result.setSensorId(resultObj.getSensorId());
		
		em.merge(result);
		// query to the DB
		return 0;
	}

	// delete result by id
	@Override
	public int delete(int id) {
		Result result = findById(id);
		if (result == null) {
			return 1;
		}
		em.remove(result);
		// query to the DB
		return 0;
	}

	// find result by id
	@Override
	public Result findById(int id) {
		if (id < 0) {
			return null;
		} else {
		// query to the DB
		return em.find(Result.class, id);
		}
	}
	
	public EntityManager getEntityManager() {
		return em;
	}
	
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
}
