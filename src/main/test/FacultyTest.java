import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ua.cn.stu.remotelabs.Faculty;

public class FacultyTest {
	
	@Test
	public void testCreate() throws Exception {
		Faculty testFaculty = new Faculty(1, "FEIT");
		System.out.println("--FACULTY_TEST--");
		assertEquals(testFaculty.getId(), 1);
		assertEquals(testFaculty.getFacultyName(), "FEIT");
		testFaculty.setId(5);
		testFaculty.setFacultyName("Faculty");
		assertEquals(testFaculty.getId(), 5);
		assertEquals(testFaculty.getFacultyName(), "Faculty");
	}

}
