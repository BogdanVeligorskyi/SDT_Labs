package table;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.cn.stu.remotelabs.model.Role;
import ua.cn.stu.remotelabs.table.RoleTableModule;

// test methods of RoleTableModule
public class RoleTableModuleTest {
	
	private static EJBContainer container;
	private static RoleTableModule instance;
	private static EntityManagerFactory emf;
	private static EntityManager entityManager;
		
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
		("--ROLE_TABLE_MODULE_TEST:crud--");
		
		// test create (add)
		Role sampleRole = new Role("Admin");
		
		int testId = instance.add(sampleRole);
		assertNotEquals(-1, testId);
		System.out.println("id:" + testId);
		
		Role role = (Role) instance.find(testId);
		assertEquals(role.getRoleName(), "Admin");
		
		sampleRole = null;
		int id = instance.add(sampleRole);
		assertEquals(-1, id);
		
		// test read (find)
		sampleRole = null;
		sampleRole = (Role) instance.find(-3);
		assertEquals(null, sampleRole);
		sampleRole = (Role) instance.find(testId);
		assertNotEquals(sampleRole, null);
		
		// test update (edit)
		sampleRole = new Role("Teacher");	
		int result = instance.edit(sampleRole, testId);
		assertEquals(testId, result);
		role = (Role) instance.find(testId);
		assertEquals(role.getRoleName(), "Teacher");
		result = instance.edit(sampleRole, -5);
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
		("--ROLE_TABLE_MODULE_TEST:add--");
		Role sampleRole = new Role("Student");
		
		int testId = instance.add(sampleRole);
		assertNotEquals(-1, testId);
		System.out.println("id:" + testId);
		
		Role role = (Role) instance.find(testId);
		assertEquals(role.getRoleName(), "Student");
		
		sampleRole = null;
		int id = instance.add(sampleRole);
		assertEquals(-1, id);
	}*/
	
	/*@Test
	public void testEdit() {
		System.out.println
		("--ROLE_TABLE_MODULE_TEST:edit--");
		Role sampleRole = new Role("Teacher");	
		int testId = 1;
		int result = instance.edit(sampleRole, testId);
		assertEquals(testId, result);
		Role role = (Role) instance.find(testId);
		assertEquals(role.getRoleName(), "Teacher");
		result = instance.edit(sampleRole, -5);
		assertEquals(-1, result);
	}*/
	
	/*@Test
	public void testDelete() {
		System.out.println
		("--ROLE_TABLE_MODULE_TEST:delete--");
		int testId = 1;
		int result = instance.remove(testId);
		assertEquals(0, result);
		result = instance.remove(-5);
		assertEquals(-1, result);
	}
	
	@Test
	public void findByIdReturnNull() {
		System.out.println
		("--ROLE_TABLE_MODULE_TEST:findById_return:null--");
		Role sampleRole = null;
		sampleRole = (Role) instance.find(-3);
		assertEquals(null, sampleRole);
	}
	
	@Test
	public void findByIdReturnNonNull() {
		System.out.println
		("--ROLE_TABLE_MODULE_TEST:findById_return:non_null--");
		Role sampleRole = (Role) instance.find(1);
		assertNotEquals(sampleRole, null);	
	}*/
	
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
