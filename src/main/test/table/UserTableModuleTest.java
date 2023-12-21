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
import ua.cn.stu.remotelabs.model.Faculty;
import ua.cn.stu.remotelabs.model.Grupa;
import ua.cn.stu.remotelabs.model.Role;
import ua.cn.stu.remotelabs.model.User;
import ua.cn.stu.remotelabs.table.UserTableModule;

// test methods of UserTableModule
public class UserTableModuleTest {
	
	private static EJBContainer container;
	private static UserTableModule instance;
	private static EntityManagerFactory emf;
	private static EntityManager entityManager;
		
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
				(UserTableModule) container.getContext().
				lookup("java:global/classes/UserTableModule");
		emf = Persistence.createEntityManagerFactory
				("RemoteLabs");
		entityManager = emf.createEntityManager();
		instance.setEntityManager(entityManager);	
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception {
		container.close();
	}
	
	/*@Test
	public void testAdd() {
		System.out.println
		("--USER_TABLE_MODULE_TEST:add--");
		User sampleUser = 
				new User("Veligorskyi", "Bogdan", 
						"Oleksandrovych", "bvl@com", 
						"lklklkalkl");
		Faculty faculty = (Faculty) instance.read
		("ua.cn.stu.remotelabs.model.Faculty", 1);
		Role role = (Role) instance.read
		("ua.cn.stu.remotelabs.model.Role", 2);
		Grupa grupa = (Grupa) instance.read
		("ua.cn.stu.remotelabs.model.Grupa", 1);
		sampleUser.setUserFaculty(faculty);
		sampleUser.setUserRole(role);
		sampleUser.setUserGrupa(grupa);
		
		int testId = instance.add(sampleUser);
		assertNotEquals(-1, testId);
		System.out.println("id:" + testId);
		User user = (User) instance.find(testId);
		
		assertEquals(user.getId(), testId);
		
		sampleUser = null;
		int id = instance.add(sampleUser);
		assertEquals(-1, id);
	}*/
	
	@Test
	public void testCRUD() {
		System.out.println
		("--USER_TABLE_MODULE_TEST:crud--");
		
		// test create (add)
		User sampleUser = 
				new User("Veligorskyi", "Bogdan", 
						"Oleksandrovych", "bl@com", 
						"erklre");
		Faculty faculty = (Faculty) instance.read
				("ua.cn.stu.remotelabs.model.Faculty", 1);
		Role role = (Role) instance.read
				("ua.cn.stu.remotelabs.model.Role", 3);
		Grupa grupa = (Grupa) instance.read
				("ua.cn.stu.remotelabs.model.Grupa", 1);
		sampleUser.setUserFaculty(faculty);
		sampleUser.setUserRole(role);
		sampleUser.setUserGrupa(grupa);
		int testId = instance.add(sampleUser);
		assertNotEquals(-1, testId);
		System.out.println("id:" + testId);
		User user = (User) instance.find(testId);
		assertEquals(user.getId(), testId);
		sampleUser = null;
		int id = instance.add(sampleUser);
		assertEquals(-1, id);
		
		// test login
		boolean isEmpty = instance.login
				("", "1212");
		assertFalse(isEmpty);
		isEmpty = instance.login
				("jkjk", "1212");
		assertFalse(isEmpty);
		isEmpty = instance.login
				("bl@com", "erklre");
		assertTrue(isEmpty);
		
		// test read (find)
		sampleUser = null;	
		sampleUser = (User) instance.find(-3);
		assertEquals(null, sampleUser);	
		sampleUser = (User) instance.find(testId);
		assertNotEquals(sampleUser, null);
		
		// test update (edit)
		sampleUser = 
				new User("Kogol", "Dmytro", 
						"Vitaliyovych", "dim@com", 
						"l1322");
		faculty = (Faculty) instance.read
				("ua.cn.stu.remotelabs.model.Faculty", 2);
		role = (Role) instance.read
				("ua.cn.stu.remotelabs.model.Role", 3);
		grupa = (Grupa) instance.read
				("ua.cn.stu.remotelabs.model.Grupa", 1);
		sampleUser.setUserFaculty(faculty);
		sampleUser.setUserRole(role);
		sampleUser.setUserGrupa(grupa);
						
		int result = instance.edit(sampleUser, testId);
		assertEquals(testId, result);
		
		user = (User) instance.find(testId);
		assertEquals(user.getLastName(), "Kogol");
		
		result = instance.edit(sampleUser, -5);
		assertEquals(-1, result);
		
		// test delete (remove)
		result = instance.remove(testId);
		assertEquals(0, result);
		result = instance.remove(-5);
		assertEquals(-1, result);
	}
	
	/*@Test
	public void testEdit() {
		System.out.println
		("--USER_TABLE_MODULE_TEST:edit--");
		int testId = 1;
		User sampleUser = 
				new User("Kogol", "Dmytro", 
						"Vitaliyovych", "dim@com", 
						"l1322");
		Faculty faculty = (Faculty) instance.read
		("ua.cn.stu.remotelabs.model.Faculty", 2);
		Role role = (Role) instance.read
		("ua.cn.stu.remotelabs.model.Role", 3);
		Grupa grupa = (Grupa) instance.read
		("ua.cn.stu.remotelabs.model.Grupa", 1);
		sampleUser.setUserFaculty(faculty);
		sampleUser.setUserRole(role);
		sampleUser.setUserGrupa(grupa);
						
		int result = instance.edit(sampleUser, testId);
		assertEquals(testId, result);
		
		User user = (User) instance.find(testId);
		assertEquals(user.getLastName(), "Kogol");
		
		result = instance.edit(sampleUser, -5);
		assertEquals(-1, result);	
	}*/
	
	/*@Test
	public void testDelete() {
		System.out.println
		("--USER_TABLE_MODULE_TEST:delete--");
		int testId = 1;					
		int result = instance.remove(testId);
		assertEquals(0, result);
		result = instance.remove(-5);
		assertEquals(-1, result);
	}*/
	
	/*@Test
	public void findByIdReturnNull() {
		System.out.println
		("--USER_TABLE_MODULE_TEST:findById_return:null--");
		User sampleUser = null;	
		sampleUser = (User) instance.find(-3);
		assertEquals(null, sampleUser);	
	}
	
	@Test
	public void findByIdReturnNonNull() {
		System.out.println
		("--USER_TABLE_MODULE_TEST:findById_return:non_null--");	
		User sampleUser = (User) instance.find(1);
		assertNotEquals(sampleUser, null);	
	}*/
	
	/*@Test
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
	}*/
	
	/*@Test
	public void testLogin() {
		System.out.println
		("--USER_TABLE_MODULE_TEST:testLogin--");
		boolean isEmpty = instance.login
				("", "1212");
		assertFalse(isEmpty);
		isEmpty = instance.login
				("jkjk", "1212");
		assertFalse(isEmpty);
		isEmpty = instance.login
				("bvl@com", "lklklkalkl");
		assertTrue(isEmpty);	
	}*/
	
}
