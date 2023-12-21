package table;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.cn.stu.remotelabs.model.Laboratory;
import ua.cn.stu.remotelabs.model.Sensor;
import ua.cn.stu.remotelabs.table.SensorTableModule;

// test methods of SensorTableModule
public class SensorTableModuleTest {

	private static EJBContainer container;
	private static SensorTableModule instance;
	private static EntityManagerFactory emf;
	private static EntityManager entityManager;
	
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
				(SensorTableModule) container.getContext().
				lookup("java:global/classes/SensorTableModule");
		emf = Persistence.createEntityManagerFactory
				("RemoteLabs");
		entityManager = emf.createEntityManager();
		instance.setEntityManager(entityManager);	
	}
		
	@AfterClass
	public static void tearDownClass() throws Exception {
		container.close();
	}
	
	@Test
	public void testCRUD() {
		
		System.out.println
		("--SENSOR_TABLE_MODULE_TEST:crud--");
		
		// test create (add)
		Sensor sampleSensor = new Sensor
				("DHT-11", "Temp", false);
		Laboratory lab = (Laboratory) 
				instance.read(
						"ua.cn.stu.remotelabs.model.Laboratory", 17);
		sampleSensor.setLaboratory(lab);
		int testId = instance.add(sampleSensor);
		assertNotEquals(-1, testId);
		
		System.out.println("id:" + testId);
		Sensor sensor = (Sensor) instance.find(testId);
		assertEquals(sensor.getId(), testId);
		
		sampleSensor = null;
		int id = instance.add(sampleSensor);
		assertEquals(-1, id);
		
		// test read (find)
		sampleSensor = 
				(Sensor) instance.find(testId);
		assertNotEquals(sampleSensor, null);
		sampleSensor = null;
		sampleSensor = (Sensor) instance.find(-3);
		assertEquals(null, sampleSensor);
		
		// test update (edit)
		sampleSensor = new Sensor("DHT-11", "Humidity", true);
		sampleSensor.setLaboratory((Laboratory)
				instance.read(
						"ua.cn.stu.remotelabs.model.Laboratory", 7));
		int result = instance.edit(sampleSensor, testId);
		assertEquals(testId, result);
		
		sensor = (Sensor) instance.find(testId);
		assertEquals(sensor.getSensorName(), "DHT-11");
		
		result = instance.edit(sampleSensor, -5);
		assertEquals(-1, result);
		
		// test delete (remove)
		result = instance.remove(testId);
		assertEquals(0, result);
		result = instance.remove(-5);
		assertEquals(-1, result);	
		
	}
	
	/*@Test
	public void testAdd() {
		System.out.println
		("--SENSOR_TABLE_MODULE_TEST:add--");
		Sensor sampleSensor = new Sensor
		("DHT-11", "Temp", false);
		Laboratory lab = (Laboratory) 
				instance.read
				("ua.cn.stu.remotelabs.model.Laboratory", 16);
		sampleSensor.setLaboratory(lab);
		int testId = instance.add(sampleSensor);
		assertNotEquals(-1, testId);
		
		System.out.println("id:" + testId);
		Sensor sensor = (Sensor) instance.find(testId);
		assertEquals(sensor.getId(), testId);
		
		sampleSensor = null;
		int id = instance.add(sampleSensor);
		assertEquals(-1, id);
	}
	
	@Test
	public void testEdit(){
		System.out.println
		("--SENSOR_TABLE_MODULE_TEST:edit--");
		int testId = 8;
		Sensor sampleSensor = new Sensor
		("DHT-11", "Humidity", true);
		sampleSensor.setLaboratory((Laboratory)
				instance.read
				("ua.cn.stu.remotelabs.model.Laboratory", 7));
		int result = instance.edit(sampleSensor, testId);
		assertEquals(testId, result);
		
		Sensor sensor = (Sensor) instance.find(testId);
		assertEquals(sensor.getSensorName(), "DHT-11");
		
		result = instance.edit(sampleSensor, -5);
		assertEquals(-1, result);	
	}
	
	@Test
	public void testDelete(){
		System.out.println
		("--SENSOR_TABLE_MODULE_TEST:delete--");
		int testId = 5;
		int result = instance.remove(testId);
		assertEquals(0, result);
		result = instance.remove(-5);
		assertEquals(-1, result);
	}
	
	@Test
	public void testFindByIdReturnNull() {
		System.out.println
		("--SENSOR_TABLE_MODULE_TEST:findById_return:null--");
		Sensor sampleSensor = null;
		sampleSensor = (Sensor) instance.find(-3);
		assertEquals(null, sampleSensor);	
	}
	
	@Test
	public void testFindByIdReturnNonNull() {
		System.out.println
		("--SENSOR_TABLE_MODULE_TEST:findById_return:non_null--");	
		Sensor sampleSensor = 
				(Sensor) instance.find(2);
		assertNotEquals(sampleSensor, null);	
	}*/
	
	@Test
	public void checkIfActiveSensor() {
		System.out.println
		("--SENSOR_TABLE_MODULE_TEST:checkIfActiveSensor--");
		Sensor sensor = 
				new Sensor("DHT-22", 
						"Humidity", false);
		boolean res = instance.checkIfActiveSensor(null);
		assertFalse(res);
		res = instance.checkIfActiveSensor(sensor);
		assertFalse(res);
		sensor.setIsActive(true);
		res = instance.checkIfActiveSensor(sensor);
		assertTrue(res);
	}
	
}
