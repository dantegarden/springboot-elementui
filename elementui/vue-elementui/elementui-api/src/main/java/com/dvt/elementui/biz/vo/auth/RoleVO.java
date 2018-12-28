package com.dvt.elementui.biz.vo.auth;

import java.util.Date;
import java.util.List;

public class RoleVO {

    private Integer id;

    /**
     * 角色名
     */
    private String roleName;

    private Date createTime;

    private Date updateTime;

    /**
     * 是否有效  1有效  2无效
     */
    private String deleteStatus;
    /**
     * 权限id列表
     * **/
    private List<Integer> permissions;

    public RoleVO(Integer id, String roleName, Date createTime, Date updateTime, String deleteStatus, List<Integer> permissions) {
        this.id = id;
        this.roleName = roleName;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleteStatus = deleteStatus;
        this.permissions = permissions;
    }

    public RoleVO() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeleteStatus() {
        return this.deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public List<Integer> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(List<Integer> permissions) {
        this.permissions = permissions;
    }
}
