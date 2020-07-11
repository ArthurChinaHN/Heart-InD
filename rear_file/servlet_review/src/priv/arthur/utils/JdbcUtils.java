package priv.arthur.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class JdbcUtils {
	
	private static Properties properties = new Properties();
	private static DataSource datasource;
	
	static {
		
		try {
			FileInputStream is = new FileInputStream("src/jdbc.properties");
			properties.load(is);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try{
			datasource = BasicDataSourceFactory.createDataSource(properties);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static Connection getconnction() {
		
		Connection conn = null;
		
		try {
			conn = datasource.getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			conn.setAutoCommit(false);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	public static void close(Connection conn) {
		
	}
}
