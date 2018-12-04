package com.dvt.elementui.biz.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dvt.elementui.biz.dao.SysUserMapper;
import com.dvt.elementui.biz.model.SysUser;
import com.dvt.elementui.biz.service.LoginService;
import com.dvt.elementui.biz.service.PermissionService;
import com.dvt.elementui.common.bean.UserPermission;
import com.dvt.elementui.common.enums.SessionEnum;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger LOGGER = Logger.getLogger(LoginServiceImpl.class);

    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private PermissionService permissionService;

    @Override
    public Boolean authLogin(String username, String password) {
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            currentUser.login(token);
            return Boolean.TRUE;
        } catch (AuthenticationException e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public SysUser getUser(String username, String password) {
        return userMapper.getUser(username, password);
    }

    @Override
    public JSONObject getInfo() {
        Session session = SecurityUtils.getSubject().getSession();
        SysUser userInfo = (SysUser) session.getAttribute(SessionEnum.USER_INFO.getValue());
        String username = userInfo.getUsername();
        JSONObject userPermission = permissionService.getUserPermission(username);
        session.setAttribute(SessionEnum.USER_PERMISSION.getValue(), userPermission);
        return userPermission;
    }

    @Override
    public Boolean logout() {
        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
        } catch (Exception e) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
