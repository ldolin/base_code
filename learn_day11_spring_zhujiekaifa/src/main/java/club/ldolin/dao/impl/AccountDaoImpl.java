package club.ldolin.dao.impl;

import club.ldolin.dao.AccountDao;
import org.springframework.stereotype.Repository;


/**
 * 账户持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    public void saveAccount(){
        System.out.println("保存了账户");
    }

}
