import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import ua.cn.stu.remotelabs.Sensor;

public class SensorTest {
	
	@Test
	public void testCreate() throws Exception {
		Sensor testSensor = new Sensor(1, "DHT-11", "Humidity", false, 5);
		System.out.println("--SENSOR_TEST--");
		assertEquals(testSensor.getId(), 1);
		assertEquals(testSensor.getSensorName(), "DHT-11");
		assertEquals(testSensor.getMeasurement(), "Humidity");
		assertFalse(testSensor.getIsActive());
		assertEquals(testSensor.getLaboratoryId(), 5);

		testSensor.setId(14);
		testSensor.setSensorName("SensorName");
		testSensor.setMeasurement("Temp");
		testSensor.setIsActive(true);
		testSensor.setLaboratoryId(6);
		
		assertEquals(testSensor.getId(), 14);
		assertEquals(testSensor.getSensorName(), "SensorName");
		assertEquals(testSensor.getMeasurement(), "Temp");
		assertFalse(!testSensor.getIsActive());
		assertEquals(testSensor.getLaboratoryId(), 6);
	}
	
}
