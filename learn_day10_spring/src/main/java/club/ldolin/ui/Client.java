package club.ldolin.ui;

import club.ldolin.factory.BeanFactory;
import club.ldolin.service.AccountService;
import club.ldolin.service.impl.AccountServiceImpl;

/**
 * 模拟表现层用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
//        AccountService as = new AccountServiceImpl();
        for (int i = 0; i < 5; i++) {
            AccountService as = (AccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
//            as.saveAccount();
        }

    }
}
