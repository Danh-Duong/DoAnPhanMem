package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static final String URL = "jdbc:sqlserver://DESKTOP-EJCDLG2\\SQLEXPRESS;databaseName=dbNHANKHAU";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123456";
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                // ??ng ký driver n?u c?n thi?t (tùy thu?c vào môi tr??ng và cách b?n s? d?ng JDBC)
                DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                // X? lý l?i k?t n?i
                System.err.println("K?t n?i c? s? d? li?u th?t b?i:");
                e.printStackTrace();
                throw new SQLException("Không th? k?t n?i ??n c? s? d? li?u", e);
            }
        }
        return connection;
    }

    // ??m b?o r?ng b?n ?óng k?t n?i sau khi s? d?ng
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Không th? ?óng k?t n?i c? s? d? li?u:");
                e.printStackTrace();
            }
        }
    }
}