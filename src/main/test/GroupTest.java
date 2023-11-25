import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ua.cn.stu.remotelabs.Group;

public class GroupTest {
	
	@Test
	public void testCreate() throws Exception {
		Group testGroup = new Group(1, "MKI-231");
		System.out.println("--GROUP_TEST--");
		assertEquals(testGroup.getId(), 1);
		assertEquals(testGroup.getGroup(), "MKI-231");
		
		testGroup.setId(55);
		testGroup.setGroup("MRA-231");
		
		assertEquals(testGroup.getId(), 55);
		assertEquals(testGroup.getGroup(), "MRA-231");
	}
	
}
