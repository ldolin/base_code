package club.ldolin.dao;

import club.ldolin.domain.QueryVo;
import club.ldolin.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface UserDao {

    /**
     * 查询所有操作,同时获取用户下所有账户的信息
     * @return
     */
//    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 根据name模糊查询
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询总用户数
     * @return
     */
    int findTotal();

    /**
     * 根据QueryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入的条件查询用户
     * @param user 查询条件 任意一个或多个或无
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据QueryVo中提供的id集合，查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
