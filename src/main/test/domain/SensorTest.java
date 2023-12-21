package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import ua.cn.stu.remotelabs.model.Sensor;

// test creation of Sensor object
public class SensorTest {
	
	@Test
	public void testCreate() throws Exception {
		Sensor testSensor = new Sensor(
				"DHT-11", "Humidity", false);
		System.out.println("--SENSOR_TEST--");
		assertEquals(testSensor.getSensorName(), 
				"DHT-11");
		assertEquals(testSensor.getMeasurement(), 
				"Humidity");
		assertFalse(testSensor.getIsActive());
		testSensor.setSensorName("SensorName");
		testSensor.setMeasurement("Temp");
		testSensor.setIsActive(true);
		assertEquals(testSensor.getSensorName(), 
				"SensorName");
		assertEquals(testSensor.getMeasurement(), 
				"Temp");
		assertFalse(!testSensor.getIsActive());
	}
	
}
