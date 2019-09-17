package club.ldolin.service.impl;

import club.ldolin.dao.AccountDao;
import club.ldolin.dao.impl.AccountDaoImpl;
import club.ldolin.service.AccountService;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    public void saveAccount() {
        System.out.println("service中的saveAccount执行了");
    }
}
