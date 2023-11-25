import static org.junit.Assert.assertEquals;

import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ua.cn.stu.remotelabs.Group;
import ua.cn.stu.remotelabs.GroupTableModule;
import ua.cn.stu.remotelabs.ITableModule;

//test methods of GroupTableModule
public class GroupTableModuleTest {
	
	private static EJBContainer container;
	private static ITableModule instance;
	
	@BeforeClass
	public static void setupClass() throws Exception {
		GroupTableModule groupModule 
		= new GroupTableModule();
		container = javax.ejb.embeddable.
				EJBContainer.createEJBContainer();
		container.getContext().bind
		("java:global/classes/GroupTableModule", 
				groupModule);
		instance = 
				(ITableModule) container.getContext().
				lookup("java:global/classes/GroupTableModule");
	}
		
	@AfterClass
	public static void tearDownClass() throws Exception {
		container.close();
	}
	
	@Test
	public void addReturn0(){
		System.out.println
		("--GROUP_TABLE_MODULE_TEST:add_return:0--");
		Group sampleGroup = new Group(0, "MKI-231");
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
		Group sampleGroup = null;
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
		Group sampleGroup = new Group(0, "MKI-231");	
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(Group.class, 0)).
		thenReturn(sampleGroup);			
		instance.setEntityManager(entityManager);
		int result = instance.edit(sampleGroup, 0);
		assertEquals(0, result);
	}
	
	@Test
	public void editReturn1() {
		System.out.println
		("--GROUP_TABLE_MODULE_TEST:edit_return:1--");
		Group sampleGroup = null;
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(null, 0)).
		thenReturn(null);
		Mockito.when(entityManager.find(Group.class, -5)).
		thenReturn(null);
		instance.setEntityManager(entityManager);	
		int result = instance.edit(sampleGroup, 0);
		assertEquals(1, result);
		sampleGroup = new Group(-5, "Group");
		result = instance.edit(sampleGroup, -5);
		assertEquals(1, result);	
	}
	
	@Test
	public void deleteReturn0(){
		System.out.println(
				"--GROUP_TABLE_MODULE_TEST:delete_return:0--");
		Group sampleGroup = new Group(0, "MRA-221");	
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(Group.class, 0)).
		thenReturn(sampleGroup);			
		instance.setEntityManager(entityManager);
		int result = instance.delete(0);
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
		Mockito.when(entityManager.find(Group.class, -5)).
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
		("--GROUP_TABLE_MODULE_TEST:findById_return:null--");
		Group sampleGroup = null;
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(Group.class, -3)).
		thenReturn(null);
		instance.setEntityManager(entityManager);	
		sampleGroup = (Group) instance.findById(-3);
		assertEquals(null, sampleGroup);	
	}
	
	@Test
	public void findByIdReturnNonNull() {
		System.out.println
		("--GROUP_TABLE_MODULE_TEST:findById_return:non_null--");
		Group group = new Group(2, "MPI-221");
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(Group.class, 2)).
		thenReturn(group);
		instance.setEntityManager(entityManager);	
		Group sampleGroup = (Group) instance.findById(2);
		assertEquals(sampleGroup, group);	
	}
}
