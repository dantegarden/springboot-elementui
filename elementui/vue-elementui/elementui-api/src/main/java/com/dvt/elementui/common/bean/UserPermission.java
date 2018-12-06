package com.dvt.elementui.common.bean;

import com.alibaba.fastjson.JSONObject;
import com.dvt.elementui.biz.model.SysPermission;
import com.dvt.elementui.biz.model.SysUser;

import java.util.List;
import java.util.Set;

public class UserPermission extends JSONObject {
    private Set<String> roleList;
    private Set<String> menuList;
    private Set<String> permissionList;
    private Set<Integer> permissionIds;
    private List<JSONObject> picList;
    private List<JSONObject> menus;
    private List<SysUser> users;
    private List<SysPermission> permissions;
}
