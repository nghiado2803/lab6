package test;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;

import Bai2.Bai22;

public class TestJdbc {
    public static void main(String[] args) {
        try {
            Connection conn = Bai22.getConnection();
            System.out.println("✅ Kết nối thành công tới CSDL HRM!");

            ResultSet rs = Bai22.executeQuery("SELECT * FROM Departments");
            while (rs.next()) {
                System.out.println(rs.getString("Id") + " - " + rs.getString("Name"));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
