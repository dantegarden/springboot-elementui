package com.dvt.elementui.biz.service.impl;

import com.dvt.elementui.biz.dao.SysUserDao;
import com.dvt.elementui.biz.model.SysUser;
import com.dvt.elementui.biz.service.LoginService;
import com.dvt.elementui.biz.vo.auth.UserPermissionVO;
import com.dvt.elementui.common.base.BaseServiceImpl;
import com.dvt.elementui.common.enums.SessionEnum;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.assertj.core.util.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


@Service
@Transactional
public class LoginServiceImpl extends BaseServiceImpl implements LoginService {


    private static final Logger LOGGER = Logger.getLogger(LoginServiceImpl.class);

    @Autowired
    private SysUserDao userDao;

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
        return userDao.getUser(username, password);
    }

    @Override
    public UserPermissionVO getInfo() {
        Session session = SecurityUtils.getSubject().getSession();
        SysUser userInfo = (SysUser) session.getAttribute(SessionEnum.USER_INFO.getValue());
        Set<String> menuList = Sets.newHashSet();
        Set<String> permissionList = Sets.newHashSet();
        userInfo.getRole().getRolePermissions().forEach(rp->{
            menuList.add(rp.getPermission().getMenuCode());
        });
        userInfo.getRole().getRolePermissions().forEach(rp->{
            permissionList.add(rp.getPermission().getPermissionCode());
        });
        UserPermissionVO userPermission = new UserPermissionVO(
                userInfo.getId(),
                menuList,
                permissionList,
                userInfo.getNickname(),
                userInfo.getRole().getId(),
                userInfo.getRole().getRoleName());
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
