import static org.junit.Assert.assertEquals;

import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ua.cn.stu.remotelabs.ITableModule;
import ua.cn.stu.remotelabs.Sensor;
import ua.cn.stu.remotelabs.SensorTableModule;

// test methods of SensorTableModule
public class SensorTableModuleTest {

	private static EJBContainer container;
	private static ITableModule instance;
	
	@BeforeClass
	public static void setupClass() throws Exception {
		SensorTableModule sensorModule = 
				new SensorTableModule();
		container = javax.ejb.embeddable.
				EJBContainer.createEJBContainer();
		container.getContext().bind
		("java:global/classes/SensorTableModule", 
				sensorModule);
		instance = 
				(ITableModule) container.getContext().
				lookup("java:global/classes/SensorTableModule");
	}
		
	@AfterClass
	public static void tearDownClass() throws Exception {
		container.close();
	}
	
	@Test
	public void addReturn0(){
		System.out.println
		("--SENSOR_TABLE_MODULE_TEST:add_return:0--");
		Sensor sampleSensor = 
				new Sensor(0, "DHT-22", 
						"Humidity", true, 5);
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);	
		instance.setEntityManager(entityManager);
		int result = instance.add(sampleSensor);
		assertEquals(0, result);
	}
	
	@Test
	public void addReturn1(){
		System.out.println
		("--SENSOR_TABLE_MODULE_TEST:add_return:1--");
		Sensor sampleSensor = null;
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);	
		instance.setEntityManager(entityManager);
		int result = instance.add(sampleSensor);
		assertEquals(1, result);
	}
	
	@Test
	public void editReturn0(){
		System.out.println
		("--SENSOR_TABLE_MODULE_TEST:edit_return:0--");
		Sensor sampleSensor = 
				new Sensor(0, "DHT-22", 
						"Humidity", true, 5);	
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(Sensor.class, 0)).
		thenReturn(sampleSensor);			
		instance.setEntityManager(entityManager);
		int result = instance.edit(sampleSensor, 0);
		assertEquals(0, result);
	}
	
	@Test
	public void editReturn1() {
		System.out.println
		("--SENSOR_TABLE_MODULE_TEST:edit_return:1--");
		Sensor sampleSensor = null;
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(null, 0)).
		thenReturn(null);
		Mockito.when(entityManager.
				find(Sensor.class, -5)).
		thenReturn(null);
		instance.setEntityManager(entityManager);	
		int result = instance.edit(sampleSensor, 0);
		assertEquals(1, result);
		sampleSensor = 
				new Sensor(-5, "DHT-22", 
						"Humidity", true, 7);
		result = instance.edit(sampleSensor, -5);
		assertEquals(1, result);	
	}
	
	@Test
	public void deleteReturn0(){
		System.out.println
		("--SENSOR_TABLE_MODULE_TEST:delete_return:0--");
		Sensor sampleSensor = 
				new Sensor(0, "DHT-22", 
						"Humidity", true, 5);	
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(Sensor.class, 0)).
		thenReturn(sampleSensor);			
		instance.setEntityManager(entityManager);
		int result = instance.delete(0);
		assertEquals(0, result);
	}
	
	@Test
	public void deleteReturn1() {
		System.out.println
		("--SENSOR_TABLE_MODULE_TEST:edit_return:1--");
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(null, 0)).
		thenReturn(null);
		Mockito.when(entityManager.
				find(Sensor.class, -5)).
		thenReturn(null);
		instance.setEntityManager(entityManager);	
		int result = instance.delete(0);
		assertEquals(1, result);
		result = instance.delete(-5);
		assertEquals(1, result);	
	}
	
	@Test
	public void findByIdReturnNull() {
		System.out.println
		("--SENSOR_TABLE_MODULE_TEST:findById_return:null--");
		Sensor sampleSensor = null;
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(Sensor.class, -3)).
		thenReturn(null);
		instance.setEntityManager(entityManager);	
		sampleSensor = (Sensor) instance.findById(-3);
		assertEquals(null, sampleSensor);	
	}
	
	@Test
	public void findByIdReturnNonNull() {
		System.out.println
		("--SENSOR_TABLE_MODULE_TEST:findById_return:non_null--");
		Sensor sensor = 
				new Sensor(2, "DHT-22", 
						"Humidity", true, 5);
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(Sensor.class, 2)).
		thenReturn(sensor);
		instance.setEntityManager(entityManager);	
		Sensor sampleSensor = 
				(Sensor) instance.findById(2);
		assertEquals(sampleSensor, sensor);	
	}
	
}
