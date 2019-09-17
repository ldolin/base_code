package club.ldolin.dao;

import club.ldolin.domain.Account;
import club.ldolin.domain.AccountUser;

import java.util.List;

public interface AccountDao {

    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户,并且带有用户名和地址信息
     * @return
     */
    List<AccountUser> findAllAccount();
}
