package Bai4;
import java.sql.*;

public class Bai43 {
    public static void main(String[] args) {
        try {
            // 1️⃣ Gọi spInsert
            String sql1 = "{CALL spInsert(?, ?, ?)}";
            Object[] v1 = {"D06", "Phòng QA", "Kiểm tra chất lượng sản phẩm"};
            int rows1 = Bai42.executeUpdate(sql1, v1);
            System.out.println("Đã thêm " + rows1 + " phòng ban.");

            // 2️⃣ Gọi spUpdate
            String sql2 = "{CALL spUpdate(?, ?, ?)}";
            Object[] v2 = {"D06", "Phòng QA/QC", "Đảm bảo chất lượng"};
            int rows2 = Bai42.executeUpdate(sql2, v2);
            System.out.println("Đã cập nhật " + rows2 + " phòng ban.");

            // 3️⃣ Gọi spSelectAll
            String sql3 = "{CALL spSelectAll()}";
            ResultSet rs = Bai42.executeQuery(sql3);
            while (rs.next()) {
                System.out.println(rs.getString("Id") + " - " + rs.getString("Name"));
            }

            // 4️⃣ Gọi spDeleteById
            String sql4 = "{CALL spDeleteById(?)}";
            Object[] v4 = {"D06"};
            int rows4 = Bai42.executeUpdate(sql4, v4);
            System.out.println("Đã xóa " + rows4 + " phòng ban.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
