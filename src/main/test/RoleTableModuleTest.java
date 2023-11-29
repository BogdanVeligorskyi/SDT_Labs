import static org.junit.Assert.assertEquals;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ua.cn.stu.remotelabs.Role;
import ua.cn.stu.remotelabs.RoleTableModule;

// test methods of RoleTableModule
public class RoleTableModuleTest {
	
	private static EJBContainer container;
	private static RoleTableModule instance;
	
	@BeforeClass
	public static void setupClass() throws Exception {
		RoleTableModule roleModule = 
				new RoleTableModule();
		container = javax.ejb.embeddable.
				EJBContainer.createEJBContainer();
		container.getContext().bind
		("java:global/classes/RoleTableModule", 
				roleModule);
		instance = 
				(RoleTableModule) container.getContext().
				lookup("java:global/classes/RoleTableModule");
	}
		
	@AfterClass
	public static void tearDownClass() throws Exception {
		container.close();
	}
	
	@Test
	public void addReturn0(){
		System.out.println
		("--ROLE_TABLE_MODULE_TEST:add_return:0--");
		Role sampleRole = new Role(0, "Admin");
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);	
		instance.setEntityManager(entityManager);
		int result = instance.add(sampleRole);
		assertEquals(0, result);
	}
	
	@Test
	public void addReturn1(){
		System.out.println
		("--ROLE_TABLE_MODULE_TEST:add_return:1--");
		Role sampleRole = null;
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);	
		instance.setEntityManager(entityManager);
		int result = instance.add(sampleRole);
		assertEquals(1, result);
	}
	
	@Test
	public void editReturn0(){
		System.out.println
		("--ROLE_TABLE_MODULE_TEST:edit_return:0--");
		Role sampleRole = new Role(0, "Admin");	
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(Role.class, 0)).
		thenReturn(sampleRole);			
		instance.setEntityManager(entityManager);
		int result = instance.edit(sampleRole, 0);
		assertEquals(0, result);
	}
	
	@Test
	public void editReturn1() {
		System.out.println
		("--ROLE_TABLE_MODULE_TEST:edit_return:1--");
		Role sampleRole = null;
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(null, 0)).
		thenReturn(null);
		Mockito.when(entityManager.find
				(Role.class, -5)).
		thenReturn(null);
		instance.setEntityManager(entityManager);	
		int result = instance.edit(sampleRole, -5);
		assertEquals(1, result);
		sampleRole = new Role(-6, "Student");
		result = instance.edit(sampleRole, -6);
		assertEquals(1, result);	
	}
	
	@Test
	public void deleteReturn0(){
		System.out.println
		("--ROLE_TABLE_MODULE_TEST:delete_return:0--");
		Role sampleRole = new Role(0, "Admin");	
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(Role.class, 0)).
		thenReturn(sampleRole);			
		instance.setEntityManager(entityManager);
		int result = instance.remove(0);
		assertEquals(0, result);
	}
	
	@Test
	public void deleteReturn1() {
		System.out.println
		("--ROLE_TABLE_MODULE_TEST:edit_return:1--");
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(null, 0)).
		thenReturn(null);
		Mockito.when(entityManager.
				find(Role.class, -5)).
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
		("--ROLE_TABLE_MODULE_TEST:findById_return:null--");
		Role sampleRole = null;
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(Role.class, -3)).
		thenReturn(null);
		instance.setEntityManager(entityManager);	
		sampleRole = (Role) instance.find(-3);
		assertEquals(null, sampleRole);	
	}
	
	@Test
	public void findByIdReturnNonNull() {
		System.out.println
		("--ROLE_TABLE_MODULE_TEST:findById_return:non_null--");
		Role role = new Role(2, "Admin");
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(Role.class, 2)).
		thenReturn(role);
		instance.setEntityManager(entityManager);	
		Role sampleRole = (Role) instance.find(2);
		assertEquals(sampleRole, role);	
	}
	
	@Test
	public void getPermissions() {
		System.out.println
		("--ROLE_TABLE_MODULE_TEST:getPermissions--");
		
		String res = instance.getPermissions("");
		assertEquals(null, res);
		res = instance.getPermissions("Administrator");
		assertEquals("Admin permissions", res);	
		res = instance.getPermissions("Teacherr");
		assertEquals("Teacher permissions", res);
		res = instance.getPermissions("Studentt");
		assertEquals("Student permissions", res);	
		res = instance.getPermissions("AAAAAA");
		assertEquals("Unknown permissions", res);	
	}
	
		
}
