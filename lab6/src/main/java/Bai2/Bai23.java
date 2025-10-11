package Bai2;

import java.sql.ResultSet;
import Bai2.Bai22;

public class Bai23 {
    public static void main(String[] args) {
        // 1️ TRUY VẤN DỮ LIỆU (SELECT)
        try {
            String sql = "SELECT * FROM Departments";
            ResultSet rs = Bai22.executeQuery(sql);
            System.out.println("=== DANH SÁCH PHÒNG BAN ===");
            while (rs.next()) {
                String id = rs.getString("Id");
                String name = rs.getString("Name");
                String desc = rs.getString("Description");
                System.out.println(id + " - " + name + " - " + desc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2️ THÊM DỮ LIỆU (INSERT)
        try {
            String sql = "INSERT INTO Departments (Id, Name, Description) "
                    + "VALUES ('D05', N'Phòng Bán hàng', N'Phụ trách bán hàng và chăm sóc KH')";
            int rows = Bai22.executeUpdate(sql);
            System.out.println("\nThêm mới phòng ban: " + rows + " dòng bị ảnh hưởng.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 3️ CẬP NHẬT DỮ LIỆU (UPDATE)
        try {
            String sql = "UPDATE Departments "
                    + "SET Name = N'Phòng Kinh doanh', Description = N'Chăm sóc khách hàng doanh nghiệp' "
                    + "WHERE Id = 'D05'";
            int rows = Bai22.executeUpdate(sql);
            System.out.println("\nCập nhật phòng ban: " + rows + " dòng bị ảnh hưởng.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 4️ XÓA DỮ LIỆU (DELETE)
        try {
            String sql = "DELETE FROM Departments WHERE Id = 'D05'";
            int rows = Bai22.executeUpdate(sql);
            System.out.println("\nXóa phòng ban: " + rows + " dòng bị ảnh hưởng.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
