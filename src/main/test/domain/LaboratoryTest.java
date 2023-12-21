package domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import ua.cn.stu.remotelabs.model.Laboratory;

// test creation of Laboratory object
public class LaboratoryTest {
	
	@Test
	public void testCreate() throws Exception {
		Laboratory testLaboratory = new Laboratory("4-73");
		System.out.println("--LABORATORY_TEST--");
		assertEquals(testLaboratory.getLabName(), "4-73");	
		testLaboratory.setLabName("1-303");
		assertEquals(testLaboratory.getLabName(), "1-303");
	}
	
}
