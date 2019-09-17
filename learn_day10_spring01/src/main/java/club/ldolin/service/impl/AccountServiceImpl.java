package club.ldolin.service.impl;

import club.ldolin.dao.AccountDao;
import club.ldolin.dao.impl.AccountDaoImpl;
import club.ldolin.service.AccountService;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl implements AccountService {

//    private AccountDao accountDao = new AccountDaoImpl();

    public AccountServiceImpl(){
        System.out.println("对象被创建了..");
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount执行了");
//        accountDao.saveAccount();
    }

    public void  init(){
        System.out.println("对象初始化了。。。");
    }
    public void  destroy(){
        System.out.println("对象销毁了。。。");
    }
}
