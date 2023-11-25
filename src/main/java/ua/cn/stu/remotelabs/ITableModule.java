package ua.cn.stu.remotelabs;

import javax.persistence.EntityManager;

// add, edit, delete and find by id general methods
public interface ITableModule {
	
	public int add(Object obj);
	public int edit(Object obj, int id);
	public int delete(int id);
	public Object findById(int id);
	public void setEntityManager(EntityManager entityManager);

}
