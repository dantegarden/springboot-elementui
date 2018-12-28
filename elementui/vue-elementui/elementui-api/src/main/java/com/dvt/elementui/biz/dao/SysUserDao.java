package com.dvt.elementui.biz.dao;

import com.dvt.elementui.biz.model.SysUser;
import com.dvt.elementui.common.base.BaseRepository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserDao extends BaseRepository<SysUser, Integer> {

    @Query("select u from SysUser u where u.username=?1 and u.password=?2 and u.deleteStatus = 1")
    SysUser getUser(String username, String password);

    /**
     * 查询用户的角色 菜单 权限
     *
     * @param id
     * @return
     */
    SysUser queryById(Integer id);

    @Query("select u from SysUser u where u.role.id = ?1 and u.deleteStatus = 1 ")
    List<SysUser> queryByRoleId(Integer roleId);

//    /**
//     * 查询结构化的权限
//     * */
//    List<UserPermission> listAllPermission();
}
