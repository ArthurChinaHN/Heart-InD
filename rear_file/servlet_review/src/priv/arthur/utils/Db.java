package priv.arthur.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Db {

	private static Connection conn = null;

	// ��ȡһ�����ݿ�����
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String dbUrl = "jdbc:mysql://127.0.0.1:3306/HeartInD?serverTimezone=UTC";
			conn = DriverManager.getConnection(dbUrl, "xqn", "arthur960804");
//	            System.out.println("========���ݿ����ӳɹ�========");
		} catch (Exception e) {
			e.printStackTrace();
//	            System.out.println("========���ݿ�����ʧ��========");
			return null;
		}
		return conn;
	}
}
