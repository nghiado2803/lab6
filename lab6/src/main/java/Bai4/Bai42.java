package Bai4;

import java.sql.*;

public class Bai42 {
    // 1️⃣ Thông tin kết nối SQL Server
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String dburl = "jdbc:sqlserver://localhost;database=HRM;encrypt=false";
    static String username = "vannghia";
    static String password = "123456";

    // 2️⃣ Nạp driver khi chương trình khởi chạy
    static {
        try {
            Class.forName(driver);
            System.out.println("✅ Đã nạp driver SQL Server thành công!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("❌ Lỗi nạp driver SQL Server", e);
        }
    }

    /** 3️⃣ Mở kết nối */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dburl, username, password);
    }

    /** 4️⃣ Thao tác dữ liệu (INSERT, UPDATE, DELETE) qua Stored Procedure */
    public static int executeUpdate(String sql, Object... values) throws SQLException {
        try (
            Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall(sql)
        ) {
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }
            return statement.executeUpdate();
        }
    }

    /** 5️⃣ Truy vấn dữ liệu (SELECT) qua Stored Procedure */
    public static ResultSet executeQuery(String sql, Object... values) throws SQLException {
        Connection connection = getConnection();
        CallableStatement statement = connection.prepareCall(sql);
        for (int i = 0; i < values.length; i++) {
            statement.setObject(i + 1, values[i]);
        }
        return statement.executeQuery(); 
    }
}
