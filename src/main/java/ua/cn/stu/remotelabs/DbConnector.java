package ua.cn.stu.remotelabs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// programmable DB setup
public class DbConnector {

	private static String dbFullName = "dbRemoteLabs";
	private static String url = 
			"jdbc:mysql://localhost:3306/" + dbFullName;;
	private static Properties prop = new Properties();
	static private  Connection conn;
	static{		
		prop.setProperty("user", "root");
		prop.setProperty("password","");
		prop.setProperty("create", "true");
	}
	public static Connection getConnection(){
		if(conn == null)
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e1) {} 
		try {	
			conn = DriverManager.getConnection(url, prop);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static String getDbFullName() {
		return dbFullName;
	}
	
	public static void setDbFullName(String dbFullName) {
		DbConnector.url = "jdbc:mysql:" + dbFullName;
	}
	
	public static void setPropertyUser(String str) {
		prop.setProperty("user", str);
	}
	
	public static void setPropertyPassword(String str) {
		prop.setProperty("password", str);
	}
	
	public static void setPropertyCreate(String str) {
		prop.setProperty("create", str);
	}

}
