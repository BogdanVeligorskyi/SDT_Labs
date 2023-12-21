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
import ua.cn.stu.remotelabs.model.Laboratory;
import ua.cn.stu.remotelabs.table.LaboratoryTableModule;

//test methods of LaboratoryTableModule
public class LaboratoryTableModuleTest {

	private static EJBContainer container;
	private static LaboratoryTableModule instance;
	private static EntityManagerFactory emf;
	private static EntityManager entityManager;
	
	@BeforeClass
	public static void setupClass() throws Exception {
		LaboratoryTableModule laboratoryModule = 
				new LaboratoryTableModule();
		container = javax.ejb.embeddable.
				EJBContainer.createEJBContainer();
		container.getContext().bind
		("java:global/classes/LaboratoryTableModule", 
				laboratoryModule);
		instance = 
				(LaboratoryTableModule) container.getContext().
				lookup("java:global/classes/LaboratoryTableModule");
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
		("--LABORATORY_TABLE_MODULE_TEST:add--");
		
		// test create (add)
		Laboratory sampleLab = new Laboratory("1-303");
		Faculty faculty = (Faculty) 
				instance.read("ua.cn.stu.remotelabs.model.Faculty", 1);
		sampleLab.setFaculty(faculty);
		int testId = instance.add(sampleLab);
		assertNotEquals(-1, testId);
		System.out.println("id:" + testId);
		Laboratory lab = (Laboratory) instance.find(testId);
		assertEquals(lab.getId(), testId);
		sampleLab = null;
		int id = instance.add(sampleLab);
		assertEquals(-1, id);
		
		// test read (find)
		sampleLab = (Laboratory) instance.find(-3);
		assertEquals(null, sampleLab);	
		sampleLab = (Laboratory) 
				instance.find(testId);
		assertNotEquals(sampleLab, null);
		
		// test update (edit)
		sampleLab = new Laboratory("4-444");
		sampleLab.setFaculty((Faculty)
				instance.read("ua.cn.stu.remotelabs.model.Faculty", 2));
		int result = instance.edit(sampleLab, testId);
		assertEquals(testId, result);
		lab = (Laboratory) instance.find(testId);
		assertEquals(lab.getLabName(), "4-444");
		result = instance.edit(sampleLab, -5);
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
		("--LABORATORY_TABLE_MODULE_TEST:add--");
		Laboratory sampleLab = new Laboratory("4-53");
		Faculty faculty = (Faculty) 
				instance.read
				("ua.cn.stu.remotelabs.model.Faculty", 1);
		sampleLab.setFaculty(faculty);
		int testId = instance.add(sampleLab);
		assertNotEquals(-1, testId);
		System.out.println("id:" + testId);
		Laboratory lab = (Laboratory) instance.find(testId);
		assertEquals(lab.getId(), testId);
		sampleLab = null;
		int id = instance.add(sampleLab);
		assertEquals(-1, id);
	}
	
	@Test
	public void testEdit() {
		System.out.println
		("--LABORATORY_TABLE_MODULE_TEST:edit--");
		int testId = 8;
		Laboratory sampleLab = new Laboratory("4-444");
		sampleLab.setFaculty((Faculty)
				instance.read
				("ua.cn.stu.remotelabs.model.Faculty", 2));
		int result = instance.edit(sampleLab, testId);
		assertEquals(testId, result);
		
		Laboratory lab = (Laboratory) instance.find(testId);
		assertEquals(lab.getLabName(), "4-444");
		
		result = instance.edit(sampleLab, -5);
		assertEquals(-1, result);	
	}
	
	@Test
	public void testDelete() {
		System.out.println
		("--LABORATORY_TABLE_MODULE_TEST:delete--");
		int testId = 5;
		int result = instance.remove(testId);
		assertEquals(0, result);
		result = instance.remove(-5);
		assertEquals(-1, result);
	}
	
	@Test
	public void testFindByIdReturnNull() {
		System.out.println
		("--LABORATORY_TABLE_MODULE_TEST:findById_return:null--");
		Laboratory sampleLab = (Laboratory) instance.find(-3);
		assertEquals(null, sampleLab);	
	}
	
	@Test
	public void testFindByIdReturnNonNull() {
		System.out.println
		("--LABORATORY_TABLE_MODULE_TEST:findById_return:non_null--");
		Laboratory sampleLab = (Laboratory) 
				instance.find(13);
		assertNotEquals(sampleLab, null);
	}*/
	
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
