package club.ldolin.dao;

import club.ldolin.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.awt.image.VolatileImage;
import java.util.List;

@CacheNamespace(blocking = true)
public interface UserDao {

    /**
     * 查询所有用户
     * 在mybatis针对crud，一共有4个注解
     * @Select,@Insert，@Update,@Delete
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "address",property = "address"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "birthday",property = "birthday"),
            @Result(property = "accounts",column = "id",
                    many = @Many( select="club.ldolin.dao.AccountDao.findAccountByUid",
                            fetchType= FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 删除用户
     * @param userId
     */
    @Delete("delete from user where id = #{id}")
    void deleteUser(Integer userId);

    /**
     * 增加用户
     * @param user
     */
    @Delete("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void insertUser(User user);

    /**
     * 更新用户
     * @param user
     */
    @Update("update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id=#{id}")
    void updateUser(User user);

    /**
     *根据id查用户
     * @param userId
     * @return
     */
    @Select("select * from user where id=#{id}")
    User findById(Integer userId);

    /**
     *根据name查用户
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
    List<User> findByName(String username);

    /**
     * 查询总用户数
     * @return
     */
    @Select("select count(*) from user")
    int findTotalUser();
}
