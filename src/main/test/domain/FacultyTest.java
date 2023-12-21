package domain;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ua.cn.stu.remotelabs.model.Faculty;

// test creation of Faculty object
public class FacultyTest {
	
	@Test
	public void testCreate() throws Exception {
		Faculty testFaculty = new Faculty("FEIT");
		System.out.println("--FACULTY_TEST--");
		assertEquals(testFaculty.getFacultyName(), "FEIT");
		testFaculty.setFacultyName("Faculty");
		assertEquals(testFaculty.getFacultyName(), "Faculty");
	}

}
