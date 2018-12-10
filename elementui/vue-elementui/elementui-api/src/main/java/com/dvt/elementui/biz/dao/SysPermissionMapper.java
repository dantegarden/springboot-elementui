package com.dvt.elementui.biz.dao;

import com.dvt.elementui.biz.model.SysPermission;
import com.dvt.elementui.common.base.BaseMapper;
import com.dvt.elementui.common.bean.UserPermission;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface SysPermissionMapper extends BaseMapper<SysPermission> {
    /**
     * 查询用户的角色 菜单 权限
     *
     * @param username
     * @return
     */
    UserPermission getUserPermission(String username);

    /**
     * 查询所有的菜单
     *
     * @return
     */
    Set<String> getAllMenu();

    /**
     * 查询所有的权限
     *
     * @return
     */
    Set<String> getAllPermission();
    /**
     * 查询结构化的权限
     * */
    List<UserPermission> listAllPermission();
}