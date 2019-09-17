package club.ldolin.day1.demo2;

import java.sql.*;


public class ShiXian {
    public static void main(String[] args) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = JdbcToolClass.getConnection();
            // 4.定义sql语句
//            String sql = "update stu1 set name = '12' where id=2";
            String sql = "select * from stu1";
            // 5.获取执行sql对象的 Statement
//            stmt = conn.createStatement();
            //使用PreparedStatement防止SQL注入
            pstmt = conn.prepareStatement(sql);
            // 6.执行sql
//            int count = stmt.executeUpdate(sql);
            rs = pstmt.executeQuery();
            // 7.处理结果
//            System.out.println(count);
            // 7.1游标向下移动一行,并判断是否有数据
            while (rs.next()) {
                //7.2获取数据
                int id = rs.getInt(1);
                System.out.println(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcToolClass.close(rs,pstmt,conn);
        }
    }
}
