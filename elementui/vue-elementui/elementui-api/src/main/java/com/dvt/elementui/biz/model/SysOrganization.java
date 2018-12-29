package com.dvt.elementui.biz.model;

import com.dvt.elementui.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sys_organization")
public class SysOrganization extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, precision = 12, scale = 0)
    private Integer id;

    /**
     * 组织机构代码,
     */
    @Column(name = "org_code")
    private String orgCode;

    /**
     * 组织机构名称,
     */
    @Column(name = "org_name")
    private String orgName;


    /**
     * 是否直属机构
     * 0 不是 1 是
     */
    @Column(name = "is_directly_under")
    private Integer isDirectlyUnder;

    /**
     * 树形自关联
     * **/
    @JsonIgnoreProperties(value = {"children", "hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name = "parent_org_id")
    private SysOrganization parent;

    @OneToMany(mappedBy="parent", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @OrderBy("id")
    private List<SysOrganization> children;

    public SysOrganization() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgCode() {
        return this.orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return this.orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getIsDirectlyUnder() {
        return this.isDirectlyUnder;
    }

    public void setIsDirectlyUnder(Integer isDirectlyUnder) {
        this.isDirectlyUnder = isDirectlyUnder;
    }

    public List<SysOrganization> getChildren() {
        return this.children;
    }

    public void setChildren(List<SysOrganization> children) {
        this.children = children;
    }

    public SysOrganization getParent() {
        return this.parent;
    }

    public void setParent(SysOrganization parent) {
        this.parent = parent;
    }
}
