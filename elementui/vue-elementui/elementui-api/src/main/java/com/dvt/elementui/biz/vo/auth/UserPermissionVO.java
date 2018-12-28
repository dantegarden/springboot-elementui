package com.dvt.elementui.biz.vo.auth;

import java.util.List;
import java.util.Set;

public class UserPermissionVO {

    private Integer userId;
    private Set<String> menuList;
    private Set<String> permissionList;
    private String nickname;
    private Integer roleId;
    private String roleName;

    public UserPermissionVO(Integer userId, Set<String> menuList, Set<String> permissionList, String nickname, Integer roleId, String roleName) {
        this.userId = userId;
        this.menuList = menuList;
        this.permissionList = permissionList;
        this.nickname = nickname;
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public UserPermissionVO() {
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Set<String> getMenuList() {
        return this.menuList;
    }

    public void setMenuList(Set<String> menuList) {
        this.menuList = menuList;
    }

    public Set<String> getPermissionList() {
        return this.permissionList;
    }

    public void setPermissionList(Set<String> permissionList) {
        this.permissionList = permissionList;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
