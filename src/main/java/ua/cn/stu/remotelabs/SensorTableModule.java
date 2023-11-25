package ua.cn.stu.remotelabs;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
@Local
public class SensorTableModule implements ITableModule {

	private EntityManager em;

	// add new sensor
	@Override
	public int add(Object obj) {

		Sensor sensor = (Sensor) obj;
		if (sensor == null) {
			return 1;
		}
		em.persist(sensor);
		// query to the DB
		return 0;
	}

	// edit existing sensor
	@Override
	public int edit(Object obj, int id) {
		Sensor sensor = findById(id);
		Sensor sensorObj = (Sensor) obj;
		if (obj == null || sensor == null) {
			return 1;
		}
		sensor.setId(sensorObj.getId());
		sensor.setSensorName(sensorObj.getSensorName());
		sensor.setMeasurement(sensorObj.getMeasurement());
		sensor.setIsActive(sensorObj.getIsActive());
		sensor.setLaboratoryId(sensorObj.getLaboratoryId());
		
		em.merge(sensor);
		// query to the DB
		return 0;
	}

	// delete sensor by id
	@Override
	public int delete(int id) {
		Sensor sensor = findById(id);
		if (sensor == null) {
			return 1;
		}
		em.remove(sensor);
		// query to the DB
		return 0;
	}

	// find sensor by id
	@Override
	public Sensor findById(int id) {
		if (id < 0) {
			return null;
		} else {
			// query to the DB
			return em.find(Sensor.class, id);
		}
	}

	public EntityManager getEntityManager() {
		return em;
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

}
