package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public static Connection getConnection() {
		Connection c = null;
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			String url = "jdbc:sqlserver://localhost:1433;DatabaseName=dbNHANKHAU;encrypt=true;trustServerCertificate=true";
			String username = "sa";
			String password = "Danh2652003";
			
			c = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	public static void disConnect(Connection c) {
		try
		{
			if(c != null) {
				c.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(DBConnect.getConnection());
	}
}