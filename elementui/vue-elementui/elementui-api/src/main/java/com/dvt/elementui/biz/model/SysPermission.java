package com.dvt.elementui.biz.model;

import com.dvt.elementui.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="sys_permission")
public class SysPermission extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, precision = 12, scale = 0)
    private Integer id;

    /**
     * 归属菜单,前端判断并展示菜单使用,
     */
    @Column(name = "menu_code")
    private String menuCode;

    /**
     * 菜单的中文释义
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 权限的代码/通配符,对应代码中@RequiresPermissions 的value
     */
    @Column(name = "permission_code")
    private String permissionCode;

    /**
     * 本权限的中文释义
     */
    @Column(name = "permission_name")
    private String permissionName;

    /**
     * 是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选
     */
    @Column(name = "required_permission")
    private Integer requiredPermission;

    @JsonIgnoreProperties(value = {"rolePermissions", "hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "permission")
    private Set<SysRolePermission> rolePermissions;

    public SysPermission() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getPermissionCode() {
        return this.permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionName() {
        return this.permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Integer getRequiredPermission() {
        return this.requiredPermission;
    }

    public void setRequiredPermission(Integer requiredPermission) {
        this.requiredPermission = requiredPermission;
    }

    public Set<SysRolePermission> getRolePermissions() {
        return this.rolePermissions;
    }

    public void setRolePermissions(Set<SysRolePermission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }
}
