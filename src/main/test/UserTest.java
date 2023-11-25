import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ua.cn.stu.remotelabs.User;

public class UserTest {
	
	@Test
	public void testCreate() throws Exception {
		User testUser = new User
				(1, "Vel", "Bogdan", "Add", 
						"email@com", "pwd", 1, 2, 3, 4);
		System.out.println("--USER_TEST--");
		assertEquals(testUser.getId(), 1);
		assertEquals(testUser.getLastName(), "Vel");
		assertEquals(testUser.getFirstName(), "Bogdan");
		assertEquals(testUser.getAddName(), "Add");
		assertEquals(testUser.getEmail(), "email@com");
		assertEquals(testUser.getPassword(), "pwd");
		assertEquals(testUser.getGroupId(), 1);
		assertEquals(testUser.getFacultyId(), 2);
		assertEquals(testUser.getRoleId(), 3);
		assertEquals(testUser.getLaboratoryId(), 4);
		testUser.setId(44);
		testUser.setLastName("LastName");
		testUser.setFirstName("FirstName");
		testUser.setAddName("add");
		testUser.setEmail("example@gmail.com");
		testUser.setPassword("newpwd");
		testUser.setGroupId(2);
		testUser.setFacultyId(3);
		testUser.setRoleId(4);
		testUser.setLaboratoryId(5);
		assertEquals(testUser.getId(), 44);
		assertEquals(testUser.getLastName(), "LastName");
		assertEquals(testUser.getFirstName(), "FirstName");
		assertEquals(testUser.getAddName(), "add");
		assertEquals(testUser.getEmail(), "example@gmail.com");
		assertEquals(testUser.getPassword(), "newpwd");
		assertEquals(testUser.getGroupId(), 2);
		assertEquals(testUser.getFacultyId(), 3);
		assertEquals(testUser.getRoleId(), 4);
		assertEquals(testUser.getLaboratoryId(), 5);
	}
}
