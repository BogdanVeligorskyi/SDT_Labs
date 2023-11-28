import static org.junit.Assert.assertEquals;

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
		Laboratory sampleLab = new Laboratory(0, "MITT", 2);
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
		Laboratory sampleLab = new Laboratory(0, "MITT", 4);	
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
		sampleLab = new Laboratory(-5, "Laboratory", 5);
		result = instance.edit(sampleLab, -5);
		assertEquals(1, result);	
	}
	
	@Test
	public void deleteReturn0(){
		System.out.println
		("--LABORATORY_TABLE_MODULE_TEST:delete_return:0--");
		Laboratory sampleLab = new Laboratory(0, "FEIT", 6);	
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
		Laboratory lab = new Laboratory(2,"EIT", 6);
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(Laboratory.class, 2)).
		thenReturn(lab);
		instance.setEntityManager(entityManager);	
		Laboratory sampleLab = (Laboratory) 
				instance.find(2);
		assertEquals(sampleLab, lab);	
	}
	
}
