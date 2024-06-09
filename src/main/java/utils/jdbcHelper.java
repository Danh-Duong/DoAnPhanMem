/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcHelper {

	static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String url = "jdbc:sqlserver://DESKTOP-R4TO9PD\\SQLEXPRESS:1433;Databasename=dbNHANKHAU;encrypt=true;trustServerCertificate=true;username=sa;password=24072002";

	static {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static PreparedStatement getStatement(String sql, Object... arr) throws SQLException, UnknownHostException {
		// SQLServerDataSource dataSource = new SQLServerDataSource();
		Connection conn = DriverManager.getConnection(url);
		PreparedStatement preparedStatement;
		if (sql.trim().startsWith("{")) {
			preparedStatement = conn.prepareCall(sql);
		} else {
			preparedStatement = conn.prepareStatement(sql);
		}
		for (int i = 0; i < arr.length; i++) {
			preparedStatement.setObject(i + 1, arr[i]);
		}
		return preparedStatement;
	}

	public static ResultSet query(String sql, Object... arr) throws SQLException, UnknownHostException {
		PreparedStatement ps = jdbcHelper.getStatement(sql, arr);
		return ps.executeQuery();
	}

	public static int update(String sql, Object... arr) throws SQLException, UnknownHostException {
		PreparedStatement ps = jdbcHelper.getStatement(sql, arr);
		try {
			return ps.executeUpdate();
		} finally {
			ps.getConnection().close();
		}
	}

	public static Object value(String sql, Object... arr) throws SQLException, UnknownHostException {
		ResultSet rs = query(sql, arr);
		while (rs.next()) {
			return rs.getObject(0);
		}
		rs.getStatement().getConnection().close();
		return null;
	}
}
