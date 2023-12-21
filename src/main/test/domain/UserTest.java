package domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ua.cn.stu.remotelabs.model.User;

// test creation of User object
public class UserTest {
	
	@Test
	public void testCreate() throws Exception {
		User testUser = new User
				("Vel", "Bogdan", "Add", 
						"email@com", "pwd");
		System.out.println("--USER_TEST--");
		assertEquals(testUser.getLastName(), "Vel");
		assertEquals(testUser.getFirstName(), "Bogdan");
		assertEquals(testUser.getAddName(), "Add");
		assertEquals(testUser.getEmail(), "email@com");
		assertEquals(testUser.getPassword(), "pwd");
		testUser.setLastName("LastName");
		testUser.setFirstName("FirstName");
		testUser.setAddName("add");
		testUser.setEmail("example@gmail.com");
		testUser.setPassword("newpwd");
		assertEquals(testUser.getLastName(), "LastName");
		assertEquals(testUser.getFirstName(), "FirstName");
		assertEquals(testUser.getAddName(), "add");
		assertEquals(testUser.getEmail(), "example@gmail.com");
		assertEquals(testUser.getPassword(), "newpwd");
	}
}
