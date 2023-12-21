package ua.cn.stu.remotelabs.model;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2023-12-18T14:30:37.112+0200")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, String> lastName;
	public static volatile SingularAttribute<User, String> firstName;
	public static volatile SingularAttribute<User, String> addName;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> password;
	public static volatile ListAttribute<User, Faculty> faculties;
	public static volatile SingularAttribute<User, Role> role;
	public static volatile SingularAttribute<User, Grupa> grupa;
}
