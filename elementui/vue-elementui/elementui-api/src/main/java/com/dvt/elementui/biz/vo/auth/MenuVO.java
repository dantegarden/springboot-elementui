package com.dvt.elementui.biz.vo.auth;

import com.dvt.elementui.biz.model.SysPermission;

import java.util.List;
import java.util.Set;

public class MenuVO {

    private String menuCode;
    private String menuName;
    private List<SysPermission> permissions;

    public String getMenuCode() {
        return this.menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<SysPermission> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }
}
