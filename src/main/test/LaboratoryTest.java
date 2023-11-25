import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ua.cn.stu.remotelabs.Laboratory;

public class LaboratoryTest {
	
	@Test
	public void testCreate() throws Exception {
		Laboratory testLaboratory = new Laboratory(1, "4-73", 1);
		System.out.println("--LABORATORY_TEST--");
		assertEquals(testLaboratory.getId(), 1);
		assertEquals(testLaboratory.getLabName(), "4-73");
		assertEquals(testLaboratory.getFacultyId(), 1);
	
		testLaboratory.setId(11);
		testLaboratory.setLabName("1-303");
		testLaboratory.setFacultyId(5);
		
		assertEquals(testLaboratory.getId(), 11);
		assertEquals(testLaboratory.getLabName(), "1-303");
		assertEquals(testLaboratory.getFacultyId(), 5);
	}
	
}
