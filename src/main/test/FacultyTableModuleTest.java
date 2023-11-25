import static org.junit.Assert.assertEquals;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import ua.cn.stu.remotelabs.Faculty;
import ua.cn.stu.remotelabs.FacultyTableModule;
import ua.cn.stu.remotelabs.ITableModule;

// test methods of FacultyTableModule
public class FacultyTableModuleTest {
	
	private static EJBContainer container;
	private static ITableModule instance;
	
	@BeforeClass
	public static void setupClass() throws Exception {
		FacultyTableModule facultyModule = new FacultyTableModule();
		container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
		container.getContext().bind("java:global/classes/FacultyTableModule", facultyModule);
		instance = 
				(ITableModule) container.getContext().lookup("java:global/classes/FacultyTableModule");
	}
		
	@AfterClass
	public static void tearDownClass() throws Exception {
		container.close();
	}
	
	@Test
	public void addReturn0(){
		System.out.println("--FACULTY_TABLE_MODULE_TEST:add_return:0--");
		Faculty sampleFaculty = new Faculty(0, "MITT");
		EntityManager entityManager = Mockito.mock(EntityManager.class);	
		instance.setEntityManager(entityManager);
		int result = instance.add(sampleFaculty);
		assertEquals(0, result);
	}
	
	@Test
	public void addReturn1(){
		System.out.println("--FACULTY_TABLE_MODULE_TEST:add_return:1--");
		Faculty sampleFaculty = null;
		EntityManager entityManager = Mockito.mock(EntityManager.class);	
		instance.setEntityManager(entityManager);
		int result = instance.add(sampleFaculty);
		assertEquals(1, result);
	}
	
	@Test
	public void editReturn0(){
		System.out.println("--FACULTY_TABLE_MODULE_TEST:edit_return:0--");
		Faculty sampleFaculty = new Faculty(0, "MITT");	
		EntityManager entityManager = Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(Faculty.class, 0)).thenReturn(sampleFaculty);			
		instance.setEntityManager(entityManager);
		int result = instance.edit(sampleFaculty, 0);
		assertEquals(0, result);
	}
	
	@Test
	public void editReturn1() {
		System.out.println("--FACULTY_TABLE_MODULE_TEST:edit_return:1--");
		Faculty sampleFaculty = null;
		EntityManager entityManager = Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(null, 0)).thenReturn(null);
		Mockito.when(entityManager.find(Faculty.class, -5)).thenReturn(null);
		instance.setEntityManager(entityManager);	
		int result = instance.edit(sampleFaculty, 0);
		assertEquals(1, result);
		sampleFaculty = new Faculty(-5, "Faculty");
		result = instance.edit(sampleFaculty, -5);
		assertEquals(1, result);	
	}
	
	@Test
	public void deleteReturn0(){
		System.out.println("--FACULTY_TABLE_MODULE_TEST:delete_return:0--");
		Faculty sampleFaculty = new Faculty(0, "FEIT");	
		EntityManager entityManager = Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(Faculty.class, 0)).thenReturn(sampleFaculty);			
		instance.setEntityManager(entityManager);
		int result = instance.delete(0);
		assertEquals(0, result);
	}
	
	@Test
	public void deleteReturn1() {
		System.out.println("--FACULTY_TABLE_MODULE_TEST:edit_return:1--");
		EntityManager entityManager = Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(null, 0)).thenReturn(null);
		Mockito.when(entityManager.find(Faculty.class, -5)).thenReturn(null);
		instance.setEntityManager(entityManager);	
		int result = instance.delete(0);
		assertEquals(1, result);
		result = instance.delete(-5);
		assertEquals(1, result);	
	}
	
	@Test
	public void findByIdReturnNull() {
		System.out.println("--FACULTY_TABLE_MODULE_TEST:findById_return:null--");
		Faculty sampleFaculty = null;
		EntityManager entityManager = Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(Faculty.class, -3)).thenReturn(null);
		instance.setEntityManager(entityManager);	
		sampleFaculty = (Faculty) instance.findById(-3);
		assertEquals(null, sampleFaculty);	
	}
	
	@Test
	public void findByIdReturnNonNull() {
		System.out.println("--FACULTY_TABLE_MODULE_TEST:findById_return:non_null--");
		Faculty faculty = new Faculty(2,"EIT");
		EntityManager entityManager = Mockito.mock(EntityManager.class);
		Mockito.when(entityManager.find(Faculty.class, 2)).thenReturn(faculty);
		instance.setEntityManager(entityManager);	
		Faculty sampleFaculty = (Faculty) instance.findById(2);
		assertEquals(sampleFaculty, faculty);	
	}
	
}
