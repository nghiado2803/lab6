package Bai3;

import java.sql.*;

public class Bai32 {
    public static void main(String[] args) {

        // 1️⃣ SELECT * FROM Employees
        try {
            String sql = "SELECT * FROM Employees";
            ResultSet rs = Bai31.executeQuery(sql);
            while (rs.next()) {
                System.out.println(
                    rs.getString("Id") + " - " +
                    rs.getString("Fullname") + " - " +
                    rs.getDouble("Salary")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2️⃣ SELECT * FROM Employees WHERE Salary > ?
        try {
            String sql = "SELECT * FROM Employees WHERE Salary > ?";
            Object[] values = { 13000000 };
            ResultSet rs = Bai31.executeQuery(sql, values);
            while (rs.next()) {
                System.out.println("NV lương cao: " +
                    rs.getString("Fullname") + " - " +
                    rs.getDouble("Salary"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 3️⃣ SELECT * FROM Employees WHERE DepartmentId = ?
        try {
            String sql = "SELECT * FROM Employees WHERE DepartmentId = ?";
            Object[] values = { "D02" }; // Ví dụ: phòng Kế toán - Tài chính
            ResultSet rs = Bai31.executeQuery(sql, values);
            while (rs.next()) {
                System.out.println("NV phòng D02: " +
                    rs.getString("Fullname") + " - " +
                    rs.getString("DepartmentId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 4️⃣ INSERT nhân viên mới
        try {
            String sql = "INSERT INTO Employees (Id, Password, Fullname, Photo, Gender, Birthday, Salary, DepartmentId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            Object[] values = { "E11", "123", "Nguyễn Văn An", "an.jpg", 1, java.sql.Date.valueOf("2001-01-01"), 15000000, "D01" };
            int rows = Bai31.executeUpdate(sql, values);
            System.out.println("Đã thêm " + rows + " nhân viên.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 5️⃣ UPDATE nhân viên
        try {
            String sql = "UPDATE Employees SET Salary = ?, DepartmentId = ? WHERE Id = ?";
            Object[] values = { 16000000, "D02", "E11" };
            int rows = Bai31.executeUpdate(sql, values);
            System.out.println("Đã cập nhật " + rows + " nhân viên.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 6️⃣ DELETE nhân viên
        try {
            String sql = "DELETE FROM Employees WHERE Id = ?";
            Object[] values = { "E11" };
            int rows = Bai31.executeUpdate(sql, values);
            System.out.println("Đã xóa " + rows + " nhân viên.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
