package com.dvt.elementui.domain;

import javax.persistence.*;

public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序
     */
    private String index;

    /**
     * 菜单名
     */
    private String title;

    /**
     * 父级菜单
     */
    private Integer pid;

    /**
     * 是否可用
     */
    private Integer enabled;

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
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取排序
     *
     * @return index - 排序
     */
    public String getIndex() {
        return index;
    }

    /**
     * 设置排序
     *
     * @param index 排序
     */
    public void setIndex(String index) {
        this.index = index == null ? null : index.trim();
    }

    /**
     * 获取菜单名
     *
     * @return title - 菜单名
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置菜单名
     *
     * @param title 菜单名
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取父级菜单
     *
     * @return pid - 父级菜单
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置父级菜单
     *
     * @param pid 父级菜单
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取是否可用
     *
     * @return enabled - 是否可用
     */
    public Integer getEnabled() {
        return enabled;
    }

    /**
     * 设置是否可用
     *
     * @param enabled 是否可用
     */
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}