package com.dvt.elementui.biz.service;

import com.dvt.elementui.biz.model.SysMenu;
import com.dvt.elementui.biz.model.SysRole;
import com.dvt.elementui.biz.model.SysUser;
import com.dvt.elementui.common.bean.UserPermission;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 用户列表
     *
     * @return
     */
    PageInfo<UserPermission> queryByPage(Map<String,Object> condition, Integer page, Integer size);
    /**
     * 获取全部角色
     *
     * @return
     * **/
    List<SysRole> getAllRoles();
}
