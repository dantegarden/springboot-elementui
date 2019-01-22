package com.dvt.elementui.biz.model;

import com.dvt.elementui.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="sys_role_permission")
public class SysRolePermission extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, precision = 12, scale = 0)
    private Integer id;

    /**
     * 角色id
     */
    @JsonIgnoreProperties(value = {"rolePermissions", "hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name = "role_id")
    private SysRole role;

    /**
     * 权限id
     */
    @JsonIgnoreProperties(value = {"rolePermissions", "hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name = "permission_id")
    private SysPermission permission;

    /**
     * 是否有效 1有效     2无效
     */
    @Column(name = "delete_status")
    private Integer deleteStatus;

    public SysRolePermission() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SysRole getRole() {
        return this.role;
    }

    public void setRole(SysRole role) {
        this.role = role;
    }

    public SysPermission getPermission() {
        return this.permission;
    }

    public void setPermission(SysPermission permission) {
        this.permission = permission;
    }

    public Integer getDeleteStatus() {
        return this.deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}
