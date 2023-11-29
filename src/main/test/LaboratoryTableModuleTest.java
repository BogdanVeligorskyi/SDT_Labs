import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ua.cn.stu.remotelabs.Laboratory;
import ua.cn.stu.remotelabs.LaboratoryTableModule;

//test methods of LaboratoryTableModule
public class LaboratoryTableModuleTest {

	private static EJBContainer container;
	private static LaboratoryTableModule instance;
	
	@BeforeClass
	public static void setupClass() throws Exception {
		LaboratoryTableModule labModule 
		= new LaboratoryTableModule();
		container = javax.ejb.embeddable.
				EJBContainer.createEJBContainer();
		container.getContext().bind
		("java:global/classes/LaboratoryTableModule", 
				labModule);
		instance = (LaboratoryTableModule) container.getContext().
				lookup("java:global/classes/LaboratoryTableModule");
	}
		
	@AfterClass
	public static void tearDownClass() throws Exception {
		container.close();
	}
	
	@Test
	public void addReturn0(){
		System.out.println
		("--LABORATORY_TABLE_MODULE_TEST:add_return:0--");
		Laboratory sampleLab = new Laboratory(0, "MITT");
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);	
		instance.setEntityManager(entityManager);
		int result = instance.add(sampleLab);
		assertEquals(0, result);
	}
	
	@Test
	public void addReturn1(){
		System.out.println
		("--LABORATORY_TABLE_MODULE_TEST:add_return:1--");
		Laboratory sampleLab = null;
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);	
		instance.setEntityManager(entityManager);
		int result = instance.add(sampleLab);
		assertEquals(1, result);
	}
	
	@Test
	public void editReturn0(){
		System.out.println
		("--LABORATORY_TABLE_MODULE_TEST:edit_return:0--");
		Laboratory sampleLab = new Laboratory(0, "MITT");	
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(Laboratory.class, 0)).
		thenReturn(sampleLab);			
		instance.setEntityManager(entityManager);
		int result = instance.edit(sampleLab, 0);
		assertEquals(0, result);
	}
	
	@Test
	public void editReturn1() {
		System.out.println
		("--LABORATORY_TABLE_MODULE_TEST:edit_return:1--");
		Laboratory sampleLab = null;
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(null, 0)).
		thenReturn(null);
		Mockito.when(entityManager.find(Laboratory.class, -5)).
		thenReturn(null);
		instance.setEntityManager(entityManager);	
		int result = instance.edit(sampleLab, -5);
		assertEquals(1, result);
		sampleLab = new Laboratory(-5, "Laboratory");
		result = instance.edit(sampleLab, -5);
		assertEquals(1, result);	
	}
	
	@Test
	public void deleteReturn0(){
		System.out.println
		("--LABORATORY_TABLE_MODULE_TEST:delete_return:0--");
		Laboratory sampleLab = new Laboratory(0, "FEIT");	
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(Laboratory.class, 0)).
		thenReturn(sampleLab);			
		instance.setEntityManager(entityManager);
		int result = instance.remove(0);
		assertEquals(0, result);
	}
	
	@Test
	public void deleteReturn1() {
		System.out.println
		("--LABORATORY_TABLE_MODULE_TEST:edit_return:1--");
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(null, 0)).
		thenReturn(null);
		Mockito.when(entityManager.find(Laboratory.class, -5)).
		thenReturn(null);
		instance.setEntityManager(entityManager);	
		int result = instance.remove(0);
		assertEquals(1, result);
		result = instance.remove(-5);
		assertEquals(1, result);	
	}
	
	@Test
	public void findByIdReturnNull() {
		System.out.println
		("--LABORATORY_TABLE_MODULE_TEST:findById_return:null--");
		Laboratory sampleLab = null;
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(Laboratory.class, -3)).
		thenReturn(null);
		instance.setEntityManager(entityManager);	
		sampleLab = (Laboratory) instance.find(-3);
		assertEquals(null, sampleLab);	
	}
	
	@Test
	public void findByIdReturnNonNull() {
		System.out.println
		("--LABORATORY_TABLE_MODULE_TEST:findById_return:non_null--");
		Laboratory lab = new Laboratory(2,"EIT");
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(Laboratory.class, 2)).
		thenReturn(lab);
		instance.setEntityManager(entityManager);	
		Laboratory sampleLab = (Laboratory) 
				instance.find(2);
		assertEquals(sampleLab, lab);	
	}
	
	@Test
	public void getCorps() {
		System.out.println
		("--LABORATORY_TABLE_MODULE_TEST:getCorps--");
		int res = instance.getCorps(null);
		assertEquals(-1, res);
		res = instance.getCorps("4-95");
		assertEquals(4, res);
	}
	
	@Test
	public void getRoom() {
		System.out.println
		("--LABORATORY_TABLE_MODULE_TEST:getRoom--");
		int res = instance.getRoom(null);
		assertEquals(-1, res);
		res = instance.getRoom("4-95");
		assertEquals(95, res);
	}
	
	@Test
	public void getCheckLabName() {
		System.out.println
		("--LABORATORY_TABLE_MODULE_TEST:getCheckLabName--");
		boolean res = instance.checkLabName(null);
		assertFalse(res);
		res = instance.checkLabName("4-64");
		assertTrue(res);
	}
	
	
	
	
}
