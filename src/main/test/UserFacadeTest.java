import static org.junit.Assert.assertEquals;
import javax.ejb.embeddable.EJBContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserFacadeTest {
	
	private static EJBContainer container;
	private static IUserFacade instance;
	
	public UserFacadeTest() {
	}
	
	@BeforeClass
	public static void setupClass() throws Exception {
		UserFacade uf = new UserFacade();
		container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
		container.getContext().bind("java:global/classes/UserFacade", uf);
		instance = (IUserFacade)
				container.getContext().lookup("java:global/classes/UserFacade");
	}
		
	@AfterClass
	public static void tearDownClass() throws Exception {
		container.close();
	}
	
	@Test
	public void testCreate() throws Exception {
		System.out.println("create");
		/*User entity = new User(1, "test", "test", "gg", "login", "pwd"); 
		int id = entity.getId();
		System.out.println("enity: " + entity);
		instance.create(entity);
		System.out.println("instance: " + instance.find(id));
		assertEquals(entity, instance.find(id));*/
	}

	
}
