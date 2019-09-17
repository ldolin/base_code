package club.ldolin.service.impl;

import club.ldolin.dao.AccountDao;
import club.ldolin.dao.impl.AccountDaoImpl;
import club.ldolin.factory.BeanFactory;
import club.ldolin.service.AccountService;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl implements AccountService {

//    private AccountDao accountDao = new AccountDaoImpl();
    private AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");


    public void saveAccount(){
        int i=1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
