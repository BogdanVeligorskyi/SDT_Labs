import static org.junit.Assert.assertEquals;

import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ua.cn.stu.remotelabs.ITableModule;
import ua.cn.stu.remotelabs.Result;
import ua.cn.stu.remotelabs.ResultTableModule;

//test methods of ResultTableModule
public class ResultTableModuleTest {

	private static EJBContainer container;
	private static ITableModule instance;
	
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
				(ITableModule) container.getContext().
				lookup("java:global/classes/ResultTableModule");
	}
		
	@AfterClass
	public static void tearDownClass() throws Exception {
		container.close();
	}
	
	@Test
	public void addReturn0(){
		System.out.println
		("--RESULT_TABLE_MODULE_TEST:add_return:0--");
		Result sampleResult = 
				new Result(0, 25.4, "%", 
						"19:11:05 23/11/2023", 5);
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);	
		instance.setEntityManager(entityManager);
		int result = instance.add(sampleResult);
		assertEquals(0, result);
	}
	
	@Test
	public void addReturn1(){
		System.out.println
		("--RESULT_TABLE_MODULE_TEST:add_return:1--");
		Result sampleResult = null;
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);	
		instance.setEntityManager(entityManager);
		int result = instance.add(sampleResult);
		assertEquals(1, result);
	}
	
	@Test
	public void editReturn0(){
		System.out.println
		("--RESULT_TABLE_MODULE_TEST:edit_return:0--");
		Result sampleResult = 
				new Result(0, 25.8, "%", 
						"19:11:07 20/10/2021", 5);
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(Result.class, 0)).
		thenReturn(sampleResult);			
		instance.setEntityManager(entityManager);
		int result = instance.edit(sampleResult, 0);
		assertEquals(0, result);
	}
	
	@Test
	public void editReturn1() {
		System.out.println
		("--RESULT_TABLE_MODULE_TEST:edit_return:1--");
		Result sampleResult = null;
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(null, 0)).
		thenReturn(null);
		Mockito.when(entityManager.
				find(Result.class, -5)).
		thenReturn(null);
		instance.setEntityManager(entityManager);	
		int result = instance.edit(sampleResult, 0);
		assertEquals(1, result);
		sampleResult = new Result(-5, 5.8, "%", 
				"19:11:07 20/10/2021", 5);
		result = instance.edit(sampleResult, -5);
		assertEquals(1, result);	
	}
	
	@Test
	public void deleteReturn0(){
		System.out.println
		("--RESULT_TABLE_MODULE_TEST:delete_return:0--");
		Result sampleResult = new 
				Result(0, 25.8, "%", 
						"19:11:07 20/10/2021", 5);
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(Result.class, 0)).
		thenReturn(sampleResult);			
		instance.setEntityManager(entityManager);
		int result = instance.delete(0);
		assertEquals(0, result);
	}
	
	@Test
	public void deleteReturn1() {
		System.out.println
		("--RESULT_TABLE_MODULE_TEST:edit_return:1--");
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(null, 0)).
		thenReturn(null);
		Mockito.when(entityManager.
				find(Result.class, -5)).
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
		("--RESULT_TABLE_MODULE_TEST:findById_return:null--");
		Result sampleResult = null;
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(Result.class, -3)).
		thenReturn(null);
		instance.setEntityManager(entityManager);	
		sampleResult = (Result) instance.findById(-3);
		assertEquals(null, sampleResult);	
	}
	
	@Test
	public void findByIdReturnNonNull() {
		System.out.println
		("--RESULT_TABLE_MODULE_TEST:findById_return:non_null--");
		Result result = new Result(2, 25.8, "%", 
				"19:11:07 20/10/2021", 5);
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(Result.class, 2)).
		thenReturn(result);
		instance.setEntityManager(entityManager);	
		Result sampleResult = (Result) instance.findById(2);
		assertEquals(sampleResult, result);	
	}
	
	
}
