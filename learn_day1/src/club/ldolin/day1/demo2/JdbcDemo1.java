package club.ldolin.day1.demo2;

import java.sql.*;

public class JdbcDemo1 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            // 1.导入驱动jar包
            // 2.注册驱动
//        Class.forName("com.mysql.jdbc.Driver");
            // 3.获取数据库连接对象
            // 外部或本机
//        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/python","root","123456");
            // 本机mysql默认3306端口
            conn = DriverManager.getConnection("jdbc:mysql:///python", "root", "123456");
            // 4.定义sql语句
//            String sql = "update stu1 set name = '12' where id=2";
            String sql = "select * from stu1";
            // 5.获取执行sql对象的 Statement
            stmt = conn.createStatement();
            // 6.执行sql
//            int count = stmt.executeUpdate(sql);
            rs = stmt.executeQuery(sql);
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
            // 8.释放资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
