package club.ldolin.test;


import club.ldolin.dao.UserDao;
import club.ldolin.domain.QueryVo;
import club.ldolin.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * mybatis入门案例
 */
public class MybatisTest {
    private InputStream in;
    private SqlSession session;
    private UserDao userDao;

    @Before
    public void init() throws Exception{
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory factory = builder.build(in);
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

    /**
     * 查询所有
     * @throws IOException
     */
    @Test
    public void testFindAll() {

        //5.使用代理对象执行查询方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }

    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("mybatis auto commit");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());

        System.out.println("保存前："+user);
        //5.使用代理对象执行保存方法
        userDao.saveUser(user);
        System.out.println("保存后："+user);

    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(49);
        user.setUsername("mybatis update user");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.updateUser(user);


    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDelete(){

        userDao.deleteUser(48);

    }

    /**
     * 测试根据id查询用户操作
     */
    @Test
    public void testFindOne(){

        User user = userDao.findById(49);
        System.out.println(user);
    }

    /**
     * 测试根据name模糊查询操作
     */
    @Test
    public void testFindByName(){

        List<User> users = userDao.findByName("%王%");
//        List<User> users = userDao.findByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试查询总用户记录条数操作
     */
    @Test
    public void testFindTotal(){
        int count = userDao.findTotal();
        System.out.println(count);
    }

    /**
     * 测试根据QueryVo中的条件查询用户操作
     */
    @Test
    public void testFindByVo(){
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> users = userDao.findUserByVo(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }

    /**
     * 根据传入的条件查询用户
     * @throws IOException
     */
    @Test
    public void testFindByCondition() {
        User u = new User();
        u.setUsername("老王");
//        u.setSex("女");
        //5.使用代理对象执行查询方法
        List<User> users = userDao.findUserByCondition(u);
        for(User user : users){
            System.out.println(user);
        }

    }

    /**
     * 根据QueryVo中提供的id集合，查询用户信息,foreach
     * @throws IOException
     */
    @Test
    public void testFindInIds() {
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(41);
        list.add(42);
        list.add(46);
        vo.setIds(list);

        List<User> users = userDao.findUserInIds(vo);
        for(User user : users){
            System.out.println(user);
        }

    }


}
