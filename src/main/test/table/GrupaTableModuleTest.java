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

import ua.cn.stu.remotelabs.model.Grupa;
import ua.cn.stu.remotelabs.table.GrupaTableModule;

//test methods of GrupaTableModule
public class GrupaTableModuleTest {
	
	private static EJBContainer container;
	private static GrupaTableModule instance;
	private static EntityManagerFactory emf;
	private static EntityManager entityManager;
		
	@BeforeClass
	public static void setupClass() throws Exception {
		GrupaTableModule grupaModule = 
				new GrupaTableModule();
		container = javax.ejb.embeddable.
				EJBContainer.createEJBContainer();
		container.getContext().bind
		("java:global/classes/GrupaTableModule", 
				grupaModule);
		instance = 
				(GrupaTableModule) container.getContext().
				lookup("java:global/classes/GrupaTableModule");
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
		("--GRUPA_TABLE_MODULE_TEST:crud--");
		
		// test create (add)
		Grupa sampleGrupa = new Grupa("MKI-232");
		
		int testId = instance.add(sampleGrupa);
		assertNotEquals(-1, testId);
		System.out.println("id:" + testId);
		
		Grupa grupa = (Grupa) instance.find(testId);
		assertEquals(grupa.getGrupa(), "MKI-232");
		
		sampleGrupa = null;
		int id = instance.add(sampleGrupa);
		assertEquals(-1, id);
		
		// test read (find)
		sampleGrupa = null;
		sampleGrupa = (Grupa) instance.find(-3);
		assertEquals(null, sampleGrupa);
		sampleGrupa = (Grupa) instance.find(testId);
		assertNotEquals(sampleGrupa, null);
		
		// test update (edit)
		sampleGrupa = new Grupa("MRA-231");	
		int result = instance.edit(sampleGrupa, testId);
		assertEquals(testId, result);
		grupa = (Grupa) instance.find(testId);
		assertEquals(grupa.getGrupa(), "MRA-231");
		result = instance.edit(sampleGrupa, -5);
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
		("--GRUPA_TABLE_MODULE_TEST:add--");
		Grupa sampleGrupa = new Grupa("MKB-231");
		int testId = instance.add(sampleGrupa);
		assertNotEquals(-1, testId);
		System.out.println("id:" + testId);
		Grupa grupa = (Grupa) instance.find(testId);
		assertEquals(grupa.getGrupa(), "MKB-231");
		sampleGrupa = null;
		int id = instance.add(sampleGrupa);
		assertEquals(-1, id);
	}*/
	
	/*@Test
	public void testEdit() {
		System.out.println
		("--GRUPA_TABLE_MODULE_TEST:edit--");
		Grupa sampleGrupa = new Grupa("MPI-231");	
		int testId = 3;
		int result = instance.edit(sampleGrupa, testId);
		assertEquals(testId, result);
		Grupa grupa = (Grupa) instance.find(testId);
		assertEquals(grupa.getGrupa(), "MPI-231");
		result = instance.edit(sampleGrupa, -5);
		assertEquals(-1, result);
	}
	
	@Test
	public void testDelete() {
		System.out.println
		("--GRUPA_TABLE_MODULE_TEST:delete--");
		int testId = 2;
		int result = instance.remove(testId);
		assertEquals(0, result);
		result = instance.remove(-5);
		assertEquals(-1, result);
	}
	
	@Test
	public void findByIdReturnNull() {
		System.out.println
		("--GRUPA_TABLE_MODULE_TEST:findById_return:null--");
		Grupa sampleGrupa = null;
		sampleGrupa = (Grupa) instance.find(-3);
		assertEquals(null, sampleGrupa);
	}
	
	@Test
	public void findByIdReturnNonNull() {
		System.out.println
		("--ROLE_TABLE_MODULE_TEST:findById_return:non_null--");
		Grupa sampleGrupa = (Grupa) instance.find(1);
		assertNotEquals(sampleGrupa, null);	
	}*/
	
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
