package com.dvt.elementui.biz.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_role_permission")
public class SysRolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 权限id
     */
    @Column(name = "permission_id")
    private Integer permissionId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 是否有效 1有效     2无效
     */
    @Column(name = "delete_status")
    private String deleteStatus;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取角色id
     *
     * @return role_id - 角色id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取权限id
     *
     * @return permission_id - 权限id
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * 设置权限id
     *
     * @param permissionId 权限id
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取是否有效 1有效     2无效
     *
     * @return delete_status - 是否有效 1有效     2无效
     */
    public String getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 设置是否有效 1有效     2无效
     *
     * @param deleteStatus 是否有效 1有效     2无效
     */
    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus == null ? null : deleteStatus.trim();
    }
}