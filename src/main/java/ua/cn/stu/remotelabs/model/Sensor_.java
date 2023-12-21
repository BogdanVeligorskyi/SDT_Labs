package ua.cn.stu.remotelabs.model;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2023-12-18T14:30:37.106+0200")
@StaticMetamodel(Sensor.class)
public class Sensor_ {
	public static volatile SingularAttribute<Sensor, String> sensorName;
	public static volatile SingularAttribute<Sensor, String> measurement;
	public static volatile SingularAttribute<Sensor, Boolean> isActive;
	public static volatile SingularAttribute<Sensor, Laboratory> laboratory;
	public static volatile ListAttribute<Sensor, Result> results;
}
