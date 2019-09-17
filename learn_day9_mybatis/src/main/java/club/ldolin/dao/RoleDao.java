package club.ldolin.dao;

import club.ldolin.domain.Role;

import java.util.List;

public interface RoleDao {
    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();
}
