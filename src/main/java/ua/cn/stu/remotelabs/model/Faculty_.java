package ua.cn.stu.remotelabs.model;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2023-12-18T14:30:37.000+0200")
@StaticMetamodel(Faculty.class)
public class Faculty_ {
	public static volatile SingularAttribute<Faculty, String> facultyName;
	public static volatile SingularAttribute<Faculty, User> user;
	public static volatile ListAttribute<Faculty, Laboratory> laboratories;
}
