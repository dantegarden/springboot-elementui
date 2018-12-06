package com.dvt.elementui.biz.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dvt.elementui.biz.dao.SysPermissionMapper;
import com.dvt.elementui.biz.service.PermissionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {

    private static final Logger LOGGER = Logger.getLogger(PermissionServiceImpl.class);

    @Autowired
    private SysPermissionMapper permissionMapper;

    @Override
    public JSONObject getUserPermission(String username) {
        JSONObject userPermission = getUserPermissionFromDB(username);
        return userPermission;
    }

    /**
     * 从数据库查询用户权限信息
     *
     * @param username
     * @return
     */
    private JSONObject getUserPermissionFromDB(String username) {
        JSONObject userPermission = permissionMapper.getUserPermission(username);
        //管理员角色ID为1
        int adminRoleId = 1;
        //如果是管理员
        String roleIdKey = "roleId";
        if (adminRoleId == userPermission.getIntValue(roleIdKey)) {
            //查询所有菜单  所有权限
            Set<String> menuList = permissionMapper.getAllMenu();
            Set<String> permissionList = permissionMapper.getAllPermission();
            userPermission.put("menuList", menuList);
            userPermission.put("permissionList", permissionList);
        }
        return userPermission;
    }
}
