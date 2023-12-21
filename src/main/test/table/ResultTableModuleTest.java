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
import ua.cn.stu.remotelabs.model.Result;
import ua.cn.stu.remotelabs.table.ResultTableModule;
import ua.cn.stu.remotelabs.model.Sensor;

//test methods of ResultTableModule
public class ResultTableModuleTest {

	private static EJBContainer container;
	private static ResultTableModule instance;
	private static EntityManager entityManager;
	private static EntityManagerFactory emf;
	
	@BeforeClass
	public static void setupClass() throws Exception {
		ResultTableModule resultModule 
		= new ResultTableModule();
		container = javax.ejb.embeddable.
				EJBContainer.createEJBContainer();
		container.getContext().bind
		("java:global/classes/ResultTableModule", 
				resultModule);
		instance = 
				(ResultTableModule) container.getContext().
				lookup("java:global/classes/ResultTableModule");
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
		("--RESULT_TABLE_MODULE_TEST:crud--");
		
		// test create (add)
		Result sampleResult = 
				new Result(25.4, "%", 
						"19:11:05 23/11/2023");
		Sensor sensor = (Sensor) instance.read
				("ua.cn.stu.remotelabs.model.Sensor", 2);
		sampleResult.setSensor(sensor);
		
		int testId = instance.add(sampleResult);
		assertNotEquals(-1, testId);
		System.out.println("id:" + testId);
		Result res = (Result) instance.find(testId);
		assertEquals(res.getId(), testId);
		
		sampleResult = null;
		int id = instance.add(sampleResult);
		assertEquals(-1, id);
		
		// test read (find)
		sampleResult = (Result) instance.find(-3);
		assertEquals(sampleResult, null);
		sampleResult = (Result) instance.find(testId);
		assertNotEquals(sampleResult, null);
		
		// test update (edit)
		sampleResult = new Result
				(18.9, "%", "16:30:00 20/12/2023");
		sampleResult.setSensor((Sensor)
				instance.read
				("ua.cn.stu.remotelabs.model.Sensor", 2));
		int result = instance.edit(sampleResult, testId);
		assertEquals(testId, result);
		
		res = (Result) instance.find(testId);
		assertEquals(res.getValue(), 18.9, 0.1);
		
		result = instance.edit(sampleResult, -5);
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
		("--RESULT_TABLE_MODULE_TEST:add--");
		Result sampleResult = 
				new Result(25.4, "%", 
						"19:13:05 25/11/2023");
		Sensor sensor = (Sensor) instance.read
		("ua.cn.stu.remotelabs.model.Sensor", 2);
		sampleResult.setSensor(sensor);
		
		int testId = instance.add(sampleResult);
		assertNotEquals(-1, testId);
		System.out.println("id:" + testId);
		Result result = (Result) instance.find(testId);
		assertEquals(result.getId(), testId);
		
		sampleResult = null;
		int id = instance.add(sampleResult);
		assertEquals(-1, id);
	}*/
	
	/*@Test
	public void testEdit() {
		System.out.println
		("--RESULT_TABLE_MODULE_TEST:edit--");
		int testId = 1;
		Result sampleResult = new Result
		(18.9, "%", "16:30:00 20/12/2023");
		sampleResult.setSensor((Sensor)
				instance.read
				("ua.cn.stu.remotelabs.model.Sensor", 2));
		int result = instance.edit(sampleResult, testId);
		assertEquals(testId, result);
		
		Result res = (Result) instance.find(testId);
		assertEquals(res.getValue(), 18.9, 0.1);
		
		result = instance.edit(sampleResult, -5);
		assertEquals(-1, result);
	}*/
	
	/*@Test
	public void testDelete() {
		System.out.println
		("--RESULT_TABLE_MODULE_TEST:delete--");
		int testId = 2;
		int result = instance.remove(testId);
		assertEquals(0, result);
		result = instance.remove(-5);
		assertEquals(-1, result);
	}
	
	@Test
	public void findByIdReturnNull() {
		System.out.println
		("--RESULT_TABLE_MODULE_TEST:findById_return:null--");
		Result sampleResult = null;	
		sampleResult = (Result) instance.find(-3);
		assertEquals(null, sampleResult);
	}
	
	@Test
	public void findByIdReturnNonNull() {
		System.out.println
		("--RESULT_TABLE_MODULE_TEST:findById_return:non_null--");	
		Result sampleResult = (Result) instance.find(1);
		assertNotEquals(sampleResult, null);	
	}*/
	
	@Test
	public void isDatetimeCorrect() {
		System.out.println
		("--RESULT_TABLE_MODULE_TEST:isDatetimeCorrect--");
		boolean res = instance.isDatetimeCorrect(null);
		assertFalse(res);
		res = instance.isDatetimeCorrect
				("29/11/2023 18:48:02");
		assertTrue(res);
	}
	
	@Test
	public void checkDatetimeInterval() {
		System.out.println
		("--RESULT_TABLE_MODULE_TEST:checkDatetimeInterval--");
		int res = instance.checkDatetimeInterval
				("29/11/2023 18:48:02", "");
		assertEquals(-1, res);
		res = instance.checkDatetimeInterval
				("29/11/2023 18:48:02", "29/11/2023 16:48:02");
		assertEquals(-1, res);
		res = instance.checkDatetimeInterval
		("29/11/2023 18:48:02","29/11/2023 19:50:02");
		assertEquals(0, res);
	}
	
}
