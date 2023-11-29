import static org.junit.Assert.assertEquals;

import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ua.cn.stu.remotelabs.Grupa;
import ua.cn.stu.remotelabs.GrupaTableModule;

//test methods of GrupaTableModule
public class GrupaTableModuleTest {
	
	private static EJBContainer container;
	private static GrupaTableModule instance;
	
	@BeforeClass
	public static void setupClass() throws Exception {
		GrupaTableModule groupModule 
		= new GrupaTableModule();
		container = javax.ejb.embeddable.
				EJBContainer.createEJBContainer();
		container.getContext().bind
		("java:global/classes/GrupaTableModule", 
				groupModule);
		instance = 
				(GrupaTableModule) container.getContext().
				lookup("java:global/classes/GrupaTableModule");
	}
		
	@AfterClass
	public static void tearDownClass() throws Exception {
		container.close();
	}
	
	@Test
	public void addReturn0(){
		System.out.println
		("--GROUP_TABLE_MODULE_TEST:add_return:0--");
		Grupa sampleGroup = new Grupa(0, "MKI-231");
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);	
		instance.setEntityManager(entityManager);
		int result = instance.add(sampleGroup);
		assertEquals(0, result);
	}
	
	@Test
	public void addReturn1(){
		System.out.println
		("--GROUP_TABLE_MODULE_TEST:add_return:1--");
		Grupa sampleGroup = null;
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);	
		instance.setEntityManager(entityManager);
		int result = instance.add(sampleGroup);
		assertEquals(1, result);
	}
	
	@Test
	public void editReturn0(){
		System.out.println
		("--GROUP_TABLE_MODULE_TEST:edit_return:0--");
		Grupa sampleGroup = new Grupa(0, "MKI-231");	
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(Grupa.class, 0)).
		thenReturn(sampleGroup);			
		instance.setEntityManager(entityManager);
		int result = instance.edit(sampleGroup, 0);
		assertEquals(0, result);
	}
	
	@Test
	public void editReturn1() {
		System.out.println
		("--GROUP_TABLE_MODULE_TEST:edit_return:1--");
		Grupa sampleGroup = null;
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(null, 0)).
		thenReturn(null);
		Mockito.when(entityManager.find(Grupa.class, -5)).
		thenReturn(null);
		instance.setEntityManager(entityManager);	
		int result = instance.edit(sampleGroup, -5);
		assertEquals(1, result);
		sampleGroup = new Grupa(-5, "Group");
		result = instance.edit(sampleGroup, -5);
		assertEquals(1, result);	
	}
	
	@Test
	public void deleteReturn0(){
		System.out.println(
				"--GROUP_TABLE_MODULE_TEST:delete_return:0--");
		Grupa sampleGroup = new Grupa(0, "MRA-221");	
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(Grupa.class, 0)).
		thenReturn(sampleGroup);			
		instance.setEntityManager(entityManager);
		int result = instance.remove(0);
		assertEquals(0, result);
	}
	
	@Test
	public void deleteReturn1() {
		System.out.println
		("--GROUP_TABLE_MODULE_TEST:edit_return:1--");
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(null, 0)).
		thenReturn(null);
		Mockito.when(entityManager.find(Grupa.class, -5)).
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
		("--GROUP_TABLE_MODULE_TEST:findById_return:null--");
		Grupa sampleGroup = null;
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(Grupa.class, -3)).
		thenReturn(null);
		instance.setEntityManager(entityManager);	
		sampleGroup = (Grupa) instance.find(-3);
		assertEquals(null, sampleGroup);	
	}
	
	@Test
	public void findByIdReturnNonNull() {
		System.out.println
		("--GROUP_TABLE_MODULE_TEST:findById_return:non_null--");
		Grupa group = new Grupa(2, "MPI-221");
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(Grupa.class, 2)).
		thenReturn(group);
		instance.setEntityManager(entityManager);	
		Grupa sampleGroup = (Grupa) instance.find(2);
		assertEquals(sampleGroup, group);	
	}
	
	@Test
	public void getStartYear() {
		System.out.println
		("--GROUP_TABLE_MODULE_TEST:getStartYear--");
		int res = instance.getStartYear(null);
		assertEquals(-1, res);
		res = instance.getStartYear("-192");
		assertEquals(-1, res);
		res = instance.getStartYear("MKI-231");
		assertEquals(2023, res);
	}
	
}
