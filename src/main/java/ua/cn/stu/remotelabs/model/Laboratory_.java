package ua.cn.stu.remotelabs.model;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2023-12-18T14:30:37.097+0200")
@StaticMetamodel(Laboratory.class)
public class Laboratory_ {
	public static volatile SingularAttribute<Laboratory, String> labName;
	public static volatile SingularAttribute<Laboratory, Faculty> faculty;
	public static volatile ListAttribute<Laboratory, Sensor> sensors;
}
