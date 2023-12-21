package domain;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import ua.cn.stu.remotelabs.model.Grupa;

// test creation of Grupa object
public class GroupTest {
	
	@Test
	public void testCreate() throws Exception {
		Grupa testGroup = new Grupa("MKI-231");
		System.out.println("--GROUP_TEST--");
		assertEquals(testGroup.getGrupa(), "MKI-231");		
		testGroup.setGrupa("MRA-231");
		assertEquals(testGroup.getGrupa(), "MRA-231");
	}
	
}
