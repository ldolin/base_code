package club.ldolin.day1.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * druid连接池工具类
 */
public class DruidToolClass {
    //1.定义成员变量DataSource
    private static DataSource ds;
    static {
        try {
            //1.加载配置文件
            Properties pro = new Properties();
            pro.load(DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties"));
            //2.获取DataSource
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
    获取连接对象
    */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    /**
     * 释放资源
     */
    public static void close(PreparedStatement pstmt, Connection conn){
        close(null,pstmt,conn);
    }
    public static void close(ResultSet rs,PreparedStatement pstmt, Connection conn){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (pstmt != null) {
            try {
                pstmt.close();
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
    /**
     * 获取连接池的方法
     */
    public static DataSource getDataSource(){
        return ds;
    }
}
