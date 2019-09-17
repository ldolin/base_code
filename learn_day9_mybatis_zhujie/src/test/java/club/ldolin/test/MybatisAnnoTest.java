package club.ldolin.test;

import club.ldolin.dao.UserDao;
import club.ldolin.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisAnnoTest {
    /**
     * 测试基于注解的mybatis使用
     * @param args
     */
    public static void main(String[] args) throws Exception{
        //1.获取字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.根据字节输入流，构建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.根据SqlSessionFactory生产SqlSession对象
        SqlSession session = factory.openSession(); //true->自动提交
        //4.使用SqlSession对象，获取Dao的代理对象
        UserDao userDao = session.getMapper(UserDao.class);
        //5.执行Dao的方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("==每个用户的信息==");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
        //6.释放资源
        session.close();
        in.close();
    }

    private InputStream in;
    private SqlSession session;
    private UserDao userDao;

    @Before
    public void init() throws Exception{
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(); //true->自动提交
        //4.使用SqlSession创建Dao接口的代理对象
        userDao = session.getMapper(UserDao.class);
    }

    @After
    public void destory() throws Exception{
        //提交事务
        session.commit();
        //6.释放资源
        session.close();
        in.close();
    }

    @Test
    public void testDelete(){
        userDao.deleteUser(51);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setUsername("mybatis zhujie");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.insertUser(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();

        user.setUsername("mybatis zhujie1");
        user.setAddress("北京市顺义区1");
        user.setSex("女");
        user.setBirthday(new Date());
        user.setId(52);

        userDao.updateUser(user);
    }

    @Test
    public void testFindOne(){
        User user = userDao.findById(52);
        System.out.println(user);

        User user1 = userDao.findById(52);
        System.out.println(user1);

        System.out.println(user==user1);
    }

    @Test
    public void testFindByName(){
        List<User> users = userDao.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal(){
        int totalUser = userDao.findTotalUser();
        System.out.println(totalUser);
    }


}
