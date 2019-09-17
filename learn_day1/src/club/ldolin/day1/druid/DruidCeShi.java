package club.ldolin.day1.druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidCeShi {
    public static void main(String[] args) {
        /**
         * 完成添加操作
         */
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            //1.获取连接
            conn = DruidToolClass.getConnection();
            //2.定义SQL
            String sql = "insert into zhanghu values(?,?,?)";
            //3.获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            //4.给？赋值
            pstmt.setInt(1, 3);
            pstmt.setString(2, "王五");
            pstmt.setDouble(3, 3000);
            //5.执行SQL
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            DruidToolClass.close(pstmt, conn);
        }
    }
}
