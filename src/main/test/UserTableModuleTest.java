import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ua.cn.stu.remotelabs.ITableModule;
import ua.cn.stu.remotelabs.User;
import ua.cn.stu.remotelabs.UserTableModule;

// test methods of UserTableModule
public class UserTableModuleTest {
	
	private static EJBContainer container;
	private static ITableModule instance;
	
	@BeforeClass
	public static void setupClass() throws Exception {
		UserTableModule userModule = 
				new UserTableModule();
		container = javax.ejb.embeddable.
				EJBContainer.createEJBContainer();
		container.getContext().bind
		("java:global/classes/UserTableModule", 
				userModule);
		instance = 
				(ITableModule) container.getContext().
				lookup("java:global/classes/UserTableModule");
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception {
		container.close();
	}
	
	@Test
	public void addReturn0(){
		System.out.println
		("--USER_TABLE_MODULE_TEST:add_return:0--");
		User sampleUser = 
				new User(0, "Vel", "Bogdan", 
						"Add", "bvel@com", 
						"erre", 1, 1, 1, 1);
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);	
		instance.setEntityManager(entityManager);
		int result = instance.add(sampleUser);
		assertEquals(0, result);
	}
	
	@Test
	public void addReturn1(){
		System.out.println
		("--USER_TABLE_MODULE_TEST:add_return:1--");
		User sampleUser = null;
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);	
		instance.setEntityManager(entityManager);
		int result = instance.add(sampleUser);
		assertEquals(1, result);
	}
	
	@Test
	public void editReturn0(){
		System.out.println
		("--USER_TABLE_MODULE_TEST:edit_return:0--");
		User sampleUser = 
				new User(1, "Vel", "Bogdan", 
						"Add", "bvel@com", 
						"erre", 1, 1, 1, 1);	
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(User.class, 0)).
		thenReturn(sampleUser);			
		instance.setEntityManager(entityManager);
		int result = instance.edit(sampleUser, 0);
		assertEquals(0, result);
	}
	
	@Test
	public void editReturn1() {
		System.out.println
		("--USER_TABLE_MODULE_TEST:edit_return:1--");
		User sampleUser = null;
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(null, 0)).
		thenReturn(null);
		Mockito.when(entityManager.
				find(User.class, -5)).
		thenReturn(null);
		instance.setEntityManager(entityManager);
		int result = instance.edit(sampleUser, 0);
		assertEquals(1, result);
		sampleUser = new User(-5, "LastName", "FirstName", 
				"AddName", "example@com", 
				"pws", 1, 1, 1, 1);
		result = instance.edit(sampleUser, -5);
		assertEquals(1, result);	
	}
	
	@Test
	public void deleteReturn0(){
		System.out.println
		("--USER_TABLE_MODULE_TEST:delete_return:0--");
		User sampleUser = 
				new User(1, "Vel", "Bogdan", 
						"Add", "bvel@com", 
						"erre", 1, 1, 1, 1);	
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(User.class, 1)).
		thenReturn(sampleUser);			
		instance.setEntityManager(entityManager);
		int result = instance.delete(1);
		assertEquals(0, result);
	}
	
	@Test
	public void deleteReturn1() {
		System.out.println
		("--USER_TABLE_MODULE_TEST:edit_return:1--");
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(null, 0)).
		thenReturn(null);
		Mockito.when(entityManager.
				find(User.class, -5)).
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
		("--USER_TABLE_MODULE_TEST:findById_return:null--");
		User sampleUser = null;
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(User.class, -3)).
		thenReturn(null);
		instance.setEntityManager(entityManager);	
		sampleUser = (User) instance.findById(-3);
		assertEquals(null, sampleUser);	
	}
	
	@Test
	public void findByIdReturnNonNull() {
		System.out.println
		("--USER_TABLE_MODULE_TEST:findById_return:non_null--");
		User user = 
				new User(2, "Vel", "Bogdan", 
						"Add", "bvel@com", 
						"erre", 1, 1, 1, 1);
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.
				find(User.class, 2)).
		thenReturn(user);
		instance.setEntityManager(entityManager);	
		User sampleUser = (User) instance.findById(2);
		assertEquals(sampleUser, user);	
	}
	
	@Test
	public void checkIfNotEmpty() {
		System.out.println
		("--USER_TABLE_MODULE_TEST:checkIfNotEmpty--");
		UserTableModule utm = new UserTableModule();
		boolean isEmpty = 
				utm.checkIfNotEmpty("", "1212");
		assertFalse(isEmpty);
		isEmpty = utm.checkIfNotEmpty(null, "1212");
		assertFalse(isEmpty);
		isEmpty = 
				utm.checkIfNotEmpty
				("login", "password");
		assertTrue(isEmpty);	
	}
	
	@Test
	public void testLogin() {
		System.out.println
		("--USER_TABLE_MODULE_TEST:testLogin--");
		UserTableModule utm = 
				new UserTableModule();
		EntityManager entityManager = 
				Mockito.mock(EntityManager.class);
		User user = new User(2, "Vel", "Bogdan", "Add", 
				"user@com", "1212", 1, 1, 1, 1);
		instance.setEntityManager(entityManager);
		boolean isEmpty = utm.login
				(user, "", "1212");
		assertFalse(isEmpty);
		isEmpty = utm.login
				(user, "jkjk", "1212");
		assertFalse(isEmpty);
		isEmpty = utm.login
				(user, "user@com", "1212");
		assertTrue(isEmpty);	
	}
	
	
}
