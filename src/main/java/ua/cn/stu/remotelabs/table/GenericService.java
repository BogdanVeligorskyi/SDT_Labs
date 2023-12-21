package ua.cn.stu.remotelabs.table;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ua.cn.stu.remotelabs.model.DomainObject;
import ua.cn.stu.remotelabs.model.Faculty;
import ua.cn.stu.remotelabs.model.Grupa;
import ua.cn.stu.remotelabs.model.Laboratory;
import ua.cn.stu.remotelabs.model.Result;
import ua.cn.stu.remotelabs.model.Role;
import ua.cn.stu.remotelabs.model.Sensor;
import ua.cn.stu.remotelabs.model.User;

// generic CRUD operations
public abstract class GenericService {
	
	private EntityManager em;
	
	// add row to the database table
	public int create(DomainObject obj) {
		if (obj == null) {
			return -1;
		}
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		System.out.println("ADDED");
		return obj.getId();
	}

	// update row in database table
	public int update(
			DomainObject obj, String className, int id) {
		int returnValue = -1;
		em.getTransaction().begin();
		DomainObject domainObject = read(className, id);		
		if (obj == null || domainObject == null) {
			em.getTransaction().commit();
			return returnValue;
		}
		if (className.startsWith(
				"ua.cn.stu.remotelabs.model.Faculty")) {
			Faculty facNew = (Faculty) obj;
			Faculty facOld = (Faculty) domainObject;
			domainObject = obj;
			facOld.setFacultyName(facNew.getFacultyName());
			em.merge(facOld);
			em.getTransaction().commit();
			returnValue = facOld.getId();
		}
		if (className.startsWith(
				"ua.cn.stu.remotelabs.model.Laboratory")) {
			Laboratory labNew = (Laboratory) obj;
			Laboratory labOld = (Laboratory) domainObject;
			domainObject = obj;
			labOld.setLabName(labNew.getLabName());
			labOld.setFaculty(labNew.getFaculty());
			em.merge(labOld);
			em.getTransaction().commit();
			returnValue = labOld.getId();
		}
		if (className.startsWith(
				"ua.cn.stu.remotelabs.model.Sensor")) {
			Sensor sensorNew = (Sensor) obj;
			Sensor sensorOld = (Sensor) domainObject;
			domainObject = obj;
			sensorOld.setSensorName
			(sensorNew.getSensorName());
			sensorOld.setIsActive
			(sensorNew.getIsActive());
			sensorOld.setMeasurement
			(sensorNew.getMeasurement());
			sensorOld.setLaboratory
			(sensorNew.getLaboratory());
			em.merge(sensorOld);
			em.getTransaction().commit();
			returnValue = sensorOld.getId();
		}
		if (className.startsWith(
				"ua.cn.stu.remotelabs.model.Result")) {
			Result resultNew = (Result) obj;
			Result resultOld = (Result) domainObject;
			domainObject = obj;
			resultOld.setValue(resultNew.getValue());
			resultOld.setMark(resultNew.getMark());
			resultOld.setDatetime(resultNew.getDatetime());
			resultOld.setSensor(resultNew.getSensor());
			em.merge(resultOld);
			em.getTransaction().commit();
			returnValue = resultOld.getId();
		}
		if (className.startsWith(
				"ua.cn.stu.remotelabs.model.User")) {
			User userNew = (User) obj;
			User userOld = (User) domainObject;
			domainObject = obj;
			userOld.setAddName(userNew.getAddName());
			userOld.setEmail(userNew.getEmail());
			userOld.setFirstName(userNew.getFirstName());
			userOld.setLastName(userNew.getLastName());
			userOld.setPassword(userNew.getPassword());
			userOld.setUserFaculty(userNew.getUserFaculty());
			userOld.setUserGrupa(userNew.getUserGrupa());
			userOld.setUserRole(userNew.getUserRole());
			em.merge(userOld);
			em.getTransaction().commit();
			returnValue = userOld.getId();
		}
		if (className.startsWith(
				"ua.cn.stu.remotelabs.model.Role")) {
			Role roleNew = (Role) obj;
			Role roleOld = (Role) domainObject;
			domainObject = obj;
			roleOld.setRoleName(roleNew.getRoleName());
			em.merge(roleOld);
			em.getTransaction().commit();
			returnValue = roleOld.getId();
		}
		if (className.startsWith(
				"ua.cn.stu.remotelabs.model.Grupa")) {
			Grupa grupaNew = (Grupa) obj;
			Grupa grupaOld = (Grupa) domainObject;
			domainObject = obj;
			grupaOld.setGrupa(grupaNew.getGrupa());
			em.merge(grupaOld);
			em.getTransaction().commit();
			returnValue = grupaOld.getId();
		}
			
		System.out.println("EDITED");
		return returnValue;
	}

	// delete row from database table
	public int delete(String className, int id) {
		em.getTransaction().begin();
		DomainObject domainObj = read(className, id);
		if (domainObj == null) {
			em.getTransaction().commit();
			return -1;
		}
		em.remove(domainObj);
		em.getTransaction().commit();
		System.out.println("DELETED");
		return 0;
	}

	// find row in database table by id
	public DomainObject read(String className, int id) {
		Class cls = null;
		try {
			cls = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (id < 0) {
			return null;
		}
		// query to the db
		DomainObject obj = (DomainObject) em.find(cls, id);
		System.out.println(cls);
		return obj;	
	}
	
	// pass EntityManager object here
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	// query to db in order to find email and password
	public boolean findEmailAndPassword(
			String email, String password) {
		em.getTransaction().begin();
		TypedQuery<User> query =
		      em.createNamedQuery(
		    		  "User.findLoginData", User.class).
		      setParameter("emailText", email).
		      setParameter("passwordText", password);
		List<User> results = query.getResultList();
		em.getTransaction().commit();
		if (results.size() > 0) {
			return true;
		} else {
		  return false;
		}
	}
	
}
