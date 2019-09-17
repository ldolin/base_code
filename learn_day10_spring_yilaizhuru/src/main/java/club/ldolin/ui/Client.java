package club.ldolin.ui;

import club.ldolin.dao.AccountDao;
import club.ldolin.service.AccountService;
import club.ldolin.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟表现层用于调用业务层
 */
public class Client {

    /**
     * 获取spring的IOC核心容器，并根据id获取对象
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //2.根据id获取bean对象,以下两方式任选一个
        AccountService as = (AccountService)ac.getBean("accountService");
        AccountDao adao = ac.getBean("accountDao",AccountDao.class);

        System.out.println(as);
        System.out.println(adao);

        as.saveAccount();

        //手动关闭容器
//        ac.close();



        //--------------BeanFactory-----------------
//        Resource resource = new ClassPathResource("bean.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
//        AccountService as = (AccountService)factory.getBean("AccountService");
//        System.out.println(as);
    }
}
