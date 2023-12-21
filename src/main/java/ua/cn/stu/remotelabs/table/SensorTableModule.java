package ua.cn.stu.remotelabs.table;

import javax.ejb.Local;
import javax.ejb.Stateless;
import ua.cn.stu.remotelabs.model.Sensor;

@Stateless
@Local
public class SensorTableModule extends GenericService {

	// add new sensor
	public int add(Sensor sensor) {
		return super.create(sensor);
	}

	// edit existing sensor
	public int edit(Sensor sensor, int id) {
		return super.update(sensor, 
				"ua.cn.stu.remotelabs.model.Sensor", id);
	}

	// delete sensor by id
	public int remove(int id) {
		return super.delete(
				"ua.cn.stu.remotelabs.model.Sensor", id);
	}

	// find sensor by id
	public Sensor find(int id) {
		return (Sensor) super.read(
				"ua.cn.stu.remotelabs.model.Sensor", id);
	}
	
	// check if selected sensor is active
	public boolean checkIfActiveSensor(Sensor sensor) {
		if (sensor == null || !sensor.getIsActive()) {
			return false;
		}
		return true;
	}
	
}
