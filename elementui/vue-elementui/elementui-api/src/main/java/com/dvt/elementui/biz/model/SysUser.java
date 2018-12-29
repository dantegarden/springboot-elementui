package com.dvt.elementui.biz.model;

import com.dvt.elementui.common.base.BaseEntity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="sys_user")
public class SysUser extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, precision = 12, scale = 0)
    private Integer id;

    /**
     * 用户名
     */
    @Column(name="username", length=200)
    private String username;

    /**
     * 密码
     */
    @Column(name="password", length=200)
    private String password;

    /**
     * 昵称
     */
    @Column(name="nickname", length=200)
    private String nickname;

    /**
     * 是否有效  1有效  2无效
     */
    @Column(name = "delete_status")
    private Integer deleteStatus;

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private SysRole role;

    @OneToOne
    @JoinColumn(name = "org_id", referencedColumnName = "id")
    private SysOrganization organization;

    @Transient
    private Integer roleId;

    @Transient
    private Integer orgId;

    public SysUser() {
    }

    public SysUser(Integer id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getDeleteStatus() {
        return this.deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public SysRole getRole() {
        return this.role;
    }

    public void setRole(SysRole role) {
        this.role = role;
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public SysOrganization getOrganization() {
        return this.organization;
    }

    public void setOrganization(SysOrganization organization) {
        this.organization = organization;
    }

    public Integer getOrgId() {
        return this.orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
}
