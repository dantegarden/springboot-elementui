package com.dvt.elementui.biz.model;

import com.dvt.elementui.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="sys_role")
public class SysRole extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, precision = 12, scale = 0)
    private Integer id;

    /**
     * 角色名
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 是否有效  1有效  2无效
     */
    @Column(name = "delete_status")
    private Integer deleteStatus;

    @JsonIgnoreProperties(value = {"role", "hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Set<SysRolePermission> rolePermissions;


    public SysRole() {
    }

    public SysRole(Integer id, String roleName){
        this.id = id;
        this.roleName = roleName;
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

    public Integer getDeleteStatus() {
        return this.deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Set<SysRolePermission> getRolePermissions() {
        return this.rolePermissions;
    }

    public void setRolePermissions(Set<SysRolePermission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }
}
