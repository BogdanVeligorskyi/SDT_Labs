package domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ua.cn.stu.remotelabs.model.Role;

// test creation of Role object
public class RoleTest {
	
	@Test
	public void testCreate() throws Exception {
		Role testRole = new Role("Admin");
		System.out.println("--ROLE_TEST--");
		assertEquals(testRole.getRoleName(), "Admin");
		testRole.setRoleName("Teacher");
		assertEquals(testRole.getRoleName(), "Teacher");
	}
}
