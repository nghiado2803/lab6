package Bai2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bai22 {
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String dburl = "jdbc:sqlserver://localhost;database=HRM;encrypt=false";
    static String username = "vannghia";
    static String password = "123456";

    static {
        try {
            // Nạp driver SQL Server
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Không tìm thấy driver SQL Server", e);
        }
    }

    /** Mở kết nối */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dburl, username, password);
    }

    /** Thao tác dữ liệu (INSERT, UPDATE, DELETE) */
    public static int executeUpdate(String sql) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        try {
            return statement.executeUpdate(sql);
        } finally {
            // Đóng kết nối để tránh rò rỉ
            statement.close();
            connection.close();
        }
    }

    /** Truy vấn dữ liệu (SELECT) */
    public static ResultSet executeQuery(String sql) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        // KHÔNG đóng connection ở đây vì cần đọc dữ liệu từ ResultSet
        return statement.executeQuery(sql);
    }
}
