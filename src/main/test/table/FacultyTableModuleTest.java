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
import ua.cn.stu.remotelabs.model.Faculty;
import ua.cn.stu.remotelabs.table.FacultyTableModule;

// test methods of FacultyTableModule
public class FacultyTableModuleTest {
	
	private static EJBContainer container;
	private static FacultyTableModule instance;
	private static EntityManagerFactory emf;
	private static EntityManager entityManager;
		
	@BeforeClass
	public static void setupClass() throws Exception {
		FacultyTableModule facultyModule = 
				new FacultyTableModule();
		container = javax.ejb.embeddable.EJBContainer.
				createEJBContainer();
		container.getContext().
		bind("java:global/classes/FacultyTableModule", 
				facultyModule);
		instance = 
				(FacultyTableModule) container.getContext().
				lookup("java:global/classes/FacultyTableModule");
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
		System.out.println("--FACULTY_TABLE_MODULE_TEST:crud--");
		
		// test create (add)
		Faculty sampleFaculty = new Faculty("New Faculty");
		int testId = instance.add(sampleFaculty);
		assertNotEquals(-1, testId);
		
		System.out.println("id:" + testId);
		
		Faculty fac = (Faculty) instance.find(testId);
		//System.out.println(fac.getFacultyName());
		assertEquals(fac.getId(), testId);
		
		sampleFaculty = null;
		int id = instance.add(sampleFaculty);
		assertEquals(-1, id);
		
		// test read (find)
		sampleFaculty = null;
		sampleFaculty = (Faculty) instance.find(225);
		assertEquals(null, sampleFaculty);
		
		sampleFaculty = (Faculty) instance.find(testId);
		assertNotEquals(sampleFaculty, null);
		System.out.println(sampleFaculty.getId());
		System.out.println(sampleFaculty.getFacultyName());
		
		// test update (edit)
		sampleFaculty = new Faculty("JF");	
		int result = instance.edit(sampleFaculty, testId);
		assertEquals(testId, result);
		
		fac = (Faculty) instance.find(testId);
		assertEquals(fac.getFacultyName(), "JF");
		
		result = instance.edit(sampleFaculty, -5);
		assertEquals(-1, result);
		
		// test delete (remove)
		result = instance.remove(testId);
		assertEquals(0, result);
		result = instance.remove(-5);
		assertEquals(-1, result);
	}
	
	
	/*@Test
	public void testAdd() {
		System.out.println("--FACULTY_TABLE_MODULE_TEST:add--");
		Faculty sampleFaculty = new Faculty("New Faculty");
		int testId = instance.add(sampleFaculty);
		assertNotEquals(-1, testId);
		
		System.out.println("id:" + testId);
		
		Faculty fac = (Faculty) instance.find(testId);
		//System.out.println(fac.getFacultyName());
		assertEquals(fac.getId(), testId);
		
		sampleFaculty = null;
		int id = instance.add(sampleFaculty);
		assertEquals(-1, id);
	}
	
	@Test
	public void testEdit() {
		System.out.println("--FACULTY_TABLE_MODULE_TEST:edit--");
		int testId = 8;
		Faculty sampleFaculty = new Faculty("JF");	
		int result = instance.edit(sampleFaculty, testId);
		assertEquals(testId, result);
		
		Faculty fac = (Faculty) instance.find(testId);
		assertEquals(fac.getFacultyName(), "JF");
		
		result = instance.edit(sampleFaculty, -5);
		assertEquals(-1, result);
	}
	
	@Test
	public void testDelete() {
		System.out.println
		("--FACULTY_TABLE_MODULE_TEST:delete--");
		int testId = 5;
		int result = instance.remove(testId);
		assertEquals(0, result);
		result = instance.remove(-5);
		assertEquals(-1, result);
	}
	
	@Test
	public void testFindByIdReturnNull() {
		System.out.println
		("--FACULTY_TABLE_MODULE_TEST:findById_return:null--");
		Faculty sampleFaculty = null;
		sampleFaculty = (Faculty) instance.find(225);
		assertEquals(null, sampleFaculty);	
	}
	
	@Test
	public void testFindByIdReturnNonNull() {
		System.out.println
		("--FACULTY_TABLE_MODULE_TEST:findById_return:non_null--");
		Faculty sampleFaculty = (Faculty) instance.find(8);
		assertNotEquals(sampleFaculty, null);
		System.out.println(sampleFaculty.getId());
		System.out.println(sampleFaculty.getFacultyName());
	}*/
	
	@Test
	public void testCreateAbbreviation() {
		System.out.println
		("--FACULTY_TABLE_MODULE_TEST:create_abbreviation--");
		String res = instance.createAbbreviation(null);
		assertEquals(null, res);
		res = instance.createAbbreviation("");
		assertEquals("", res);
		res = instance.createAbbreviation
				("Faculty of Information Technologies");
		assertEquals("FIT", res);
	}
	
}
