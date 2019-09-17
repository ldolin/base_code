package club.ldolin.test;

import club.ldolin.dao.AccountDao;
import club.ldolin.dao.UserDao;
import club.ldolin.domain.Account;
import club.ldolin.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private InputStream in;
    private SqlSession session;
    private AccountDao accountDao;

    @Before
    public void init() throws Exception{
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(); //true->自动提交
        //4.使用SqlSession创建Dao接口的代理对象
        accountDao = session.getMapper(AccountDao.class);
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
     */
    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    /**
     * 查询所有账户,并且带有用户名和地址信息
     */
    @Test
    public void testFindAllAccountUser(){
        List<AccountUser> accounts = accountDao.findAllAccount();
        for (AccountUser account : accounts) {
            System.out.println(account);
        }
    }
}
