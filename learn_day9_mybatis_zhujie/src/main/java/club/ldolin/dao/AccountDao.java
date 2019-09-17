package club.ldolin.dao;

import club.ldolin.domain.Account;
import club.ldolin.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {

    /**
     * 查询所有账户，获取账户所属用户信息
     * @return
     */
    @Select("select * from account")
    @Results(id = "accountMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(property = "user",column = "uid",one = @One( select="club.ldolin.dao.UserDao.findById",fetchType= FetchType.EAGER))
    })
    List<Account> findAll();

    @Select("select * from account where uid=#{userId}")
    List<Account> findAccountByUid(Integer userId);
}
