package club.ldolin.day1.demo2;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/*
jdbc工具类
 */
public class JdbcToolClass {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    /*
    静态代码块随类的加载而加载，只有一次
     */
    static {
        //读取资源文件，获取值
        try {
            //1.创建Properties集合类对象
            Properties pro = new Properties();
            //获取src路径下文件方式，--》ClassLoader类加载器
//            ClassLoader classLoader = JdbcToolClass.class.getClassLoader();
//            URL res  = classLoader.getResource("/jdbc.properties");
//            String path = res.getPath();
            //2.加载文件
            pro.load(new FileReader("D:\\IntelliJ IDEA 2018.2.6\\IdeaProjects\\out\\production\\learn_day1\\jdbc.properties"));
//            pro.load(new FileReader(path));
            //3.获取数据，赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            //4.注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    //获取连接，返回连接对象
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    /*
    释放资源
     */
    public static void close(PreparedStatement pstmt){
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Statement stmt, Connection conn){
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
    public static void close(PreparedStatement pstmt, Connection conn){
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
    public static void close(ResultSet rs, Statement stmt, Connection conn){
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
    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn){
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

}
