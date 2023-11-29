package ua.cn.stu.remotelabs;

import java.sql.Connection;

public class Main {

	public static void main(String[] args) {
		Connection conn = DbConnector.getConnection();
		System.out.println(conn);
	}

}
