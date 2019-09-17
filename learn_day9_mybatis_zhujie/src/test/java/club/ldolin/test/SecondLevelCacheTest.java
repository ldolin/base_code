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

public class SecondLevelCacheTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private UserDao userDao;

    @Before
    public void init() throws Exception{
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(); //true->自动提交
        //4.使用SqlSession创建Dao接口的代理对象
        userDao = session.getMapper(UserDao.class);
    }

    @After
    public void destory() throws Exception{

        in.close();
    }

    @Test
    public void testFindOne(){
        User user = userDao.findById(52);
        System.out.println(user);
        session.close();//释放一级缓存

        SqlSession session1 = factory.openSession(); //再次打开session
        UserDao userDao1 = session1.getMapper(UserDao.class);
        User user1 = userDao1.findById(52);
        System.out.println(user1);
        session1.close();
    }
}
