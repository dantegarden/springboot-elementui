package com.dvt.elementui.biz.model;

import com.dvt.elementui.biz.vo.demo.QueryForm;
import com.dvt.elementui.common.base.BaseEntity;
import com.dvt.elementui.common.utils.JsonUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "demo_pivot_collection")
public class DemoPivotCollection extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, precision = 12, scale = 0)
    private Integer id;

    @Column(name = "collection_name")
    private String collectionName;

    @JsonIgnoreProperties(value = {"role", "hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private SysUser user;

    @Lob
    //@Basic(fetch = FetchType.LAZY)
    @Column(name = "collection_json", columnDefinition="TEXT")
    private String collectionJson;

    @Transient
    private QueryForm queryCondition;

    @Transient
    private Integer userId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SysUser getUser() {
        return this.user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public String getCollectionJson() {
        return this.collectionJson;
    }

    public void setCollectionJson(String collectionJson) {
        this.collectionJson = collectionJson;
    }

    public QueryForm getQueryCondition() {
        return this.queryCondition;
    }

    public void setQueryCondition(QueryForm queryCondition) {
        this.queryCondition = queryCondition;
        this.collectionJson = JsonUtils.toJson(queryCondition);
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCollectionName() {
        return this.collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
}
