import java.util.HashMap;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ua.cn.stu.remotelabs.User;

@Stateless
@Local
public class UserFacade implements IUserFacade {
	
	@PersistenceContext(unitName = "RemoteLabs")
	private EntityManager em;
	private HashMap<Integer, User> hashMap = new HashMap<Integer, User>();

	@Override
	public void create(Object entity) {
		User user = (User) entity;
		hashMap.put(user.getId(), user);
	}

	@Override
	public User find(int id) {
		return hashMap.get(id);
	}
	
}
