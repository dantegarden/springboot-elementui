package com.dvt.elementui.biz.model;

import java.util.Date;
import javax.persistence.*;

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 是否有效  1.有效  2无效
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
     * 获取文章内容
     *
     * @return content - 文章内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置文章内容
     *
     * @param content 文章内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取是否有效  1.有效  2无效
     *
     * @return delete_status - 是否有效  1.有效  2无效
     */
    public String getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 设置是否有效  1.有效  2无效
     *
     * @param deleteStatus 是否有效  1.有效  2无效
     */
    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus == null ? null : deleteStatus.trim();
    }
}