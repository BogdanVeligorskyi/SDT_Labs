import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ua.cn.stu.remotelabs.Role;

public class RoleTest {
	
	@Test
	public void testCreate() throws Exception {
		Role testRole = new Role(1, "Admin");
		System.out.println("--ROLE_TEST--");
		assertEquals(testRole.getId(), 1);
		assertEquals(testRole.getRoleName(), "Admin");
		testRole.setId(5);
		testRole.setRoleName("Teacher");
		assertEquals(testRole.getId(), 5);
		assertEquals(testRole.getRoleName(), "Teacher");
	}
}
