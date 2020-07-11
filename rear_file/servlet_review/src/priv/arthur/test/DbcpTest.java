package priv.arthur.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import priv.arthur.utils.Db;
import priv.arthur.utils.JdbcUtils;

public class DbcpTest {

	@Test
	public void testWriteDbEveryConn() throws Exception{
		for (int i = 0; i < 2000; i++) {
			writedbbyeveryconn(i);
		}
		System.out.println("Done");
	}
	
	@Test
	public void testwritedbbyoneconn() throws Exception {
		Connection conn = Db.getConnection();
		Statement stat = conn.createStatement();
		for (int i = 0; i < 2000; i++) {
			writedbbyoneconn(i, stat);
		}
		conn.close();
		System.out.println("Done2");
	}
	
	@Test
	public void testwritedbbydbcp() throws Exception {
		for (int i = 0; i < 2000; i++) {
			writedbbydbcp(i);
		}
		System.out.println("Done3");
	}
	
	public void writedbbyeveryconn(int data) {
		String sql = "insert into xuser (xuser_account,xuser_password) values(\"x\",\"y\");";
		Connection conn = Db.getConnection();
		try {
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void writedbbyoneconn(int data,Statement stat) {
		String sql = "insert into xuser (xuser_account,xuser_password) values(\"x\",\"y\");";
		try {
			stat.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writedbbydbcp(int data) {
		String sql = "insert into xuser (xuser_account,xuser_password) values(\"x\",\"y\");";
		try {
			Connection conn = JdbcUtils.getconnction();
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			conn.commit();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
