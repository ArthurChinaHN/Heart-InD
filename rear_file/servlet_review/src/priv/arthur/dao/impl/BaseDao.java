package priv.arthur.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import priv.arthur.utils.JdbcUtils;

public abstract class BaseDao {
	
	private QueryRunner queryRunner = new QueryRunner();
	
	public int update(String sql,Object ...args) {
		Connection conn = JdbcUtils.getconnction();
		try {
			return queryRunner.update(conn, sql, args);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
