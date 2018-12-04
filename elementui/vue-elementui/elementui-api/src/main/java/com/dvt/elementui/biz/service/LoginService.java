package com.dvt.elementui.biz.service;

import com.alibaba.fastjson.JSONObject;
import com.dvt.elementui.biz.model.SysUser;
import com.dvt.elementui.common.bean.UserPermission;

import java.util.Map;

public interface LoginService {
    /**
     * 登录表单提交
     *
     * @return
     */
    Boolean authLogin(String username, String password);

    /**
     * 根据用户名和密码查询对应的用户
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    SysUser getUser(String username, String password);

    /**
     * 查询当前登录用户的权限等信息
     *
     * @return
     */
    JSONObject getInfo();

    /**
     * 退出登录
     *
     * @return
     */
    Boolean logout();
}
