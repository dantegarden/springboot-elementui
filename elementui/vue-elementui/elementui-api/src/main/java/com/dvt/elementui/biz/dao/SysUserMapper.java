package com.dvt.elementui.biz.dao;

import com.dvt.elementui.biz.model.SysUser;
import com.dvt.elementui.common.base.BaseMapper;
import com.dvt.elementui.common.bean.UserPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 根据用户名和密码查询对应的用户
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    SysUser getUser(@Param("username") String username, @Param("password") String password);
    /**
     * 查询用户列表
     *
     * @param condition
     * @return
     */
    List<UserPermission> queryUserPermission(@Param("condition") Map<String,Object> condition);
}