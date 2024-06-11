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
                // ??ng k� driver n?u c?n thi?t (t�y thu?c v�o m�i tr??ng v� c�ch b?n s? d?ng JDBC)
                DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                // X? l� l?i k?t n?i
                System.err.println("K?t n?i c? s? d? li?u th?t b?i:");
                e.printStackTrace();
                throw new SQLException("Kh�ng th? k?t n?i ??n c? s? d? li?u", e);
            }
        }
        return connection;
    }

    // ??m b?o r?ng b?n ?�ng k?t n?i sau khi s? d?ng
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Kh�ng th? ?�ng k?t n?i c? s? d? li?u:");
                e.printStackTrace();
            }
        }
    }
}