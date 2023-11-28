import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ua.cn.stu.remotelabs.Grupa;

public class GroupTest {
	
	@Test
	public void testCreate() throws Exception {
		Grupa testGroup = new Grupa(1, "MKI-231");
		System.out.println("--GROUP_TEST--");
		assertEquals(testGroup.getId(), 1);
		assertEquals(testGroup.getGrupa(), "MKI-231");
		
		testGroup.setId(55);
		testGroup.setGrupa("MRA-231");
		
		assertEquals(testGroup.getId(), 55);
		assertEquals(testGroup.getGrupa(), "MRA-231");
	}
	
}
