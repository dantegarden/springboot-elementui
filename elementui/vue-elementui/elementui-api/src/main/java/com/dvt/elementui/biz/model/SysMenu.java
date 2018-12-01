package com.dvt.elementui.biz.model;

import javax.persistence.*;
import java.util.List;

@Table(name = "sys_menu")
public class SysMenu {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 菜单名
     */
    private String title;

    /**
     * 图标
     */
    private String icon;

    /**
     * 路由
     */
    private String route;

    /**
     * 排序
     */
    private Integer index;

    /**
     * 是否生效
     */
    private Integer enable;

    /**
     * PID
     */
    private Long pid;

    /**
     * 子菜单列表
     * */
    private List<SysMenu> subMenus; //子菜单列表

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
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
     * 获取路由
     *
     * @return route - 路由
     */
    public String getRoute() {
        return route;
    }

    /**
     * 设置路由
     *
     * @param route 路由
     */
    public void setRoute(String route) {
        this.route = route == null ? null : route.trim();
    }

    /**
     * 获取排序
     *
     * @return index - 排序
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * 设置排序
     *
     * @param index 排序
     */
    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     * 获取是否生效
     *
     * @return enable - 是否生效
     */
    public Integer getEnable() {
        return enable;
    }

    /**
     * 设置是否生效
     *
     * @param enable 是否生效
     */
    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    /**
     * 获取PID
     *
     * @return pid - PID
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置PID
     *
     * @param pid PID
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    public List<SysMenu> getSubMenus() {
        return this.subMenus;
    }

    public void setSubMenus(List<SysMenu> subMenus) {
        this.subMenus = subMenus;
    }
}