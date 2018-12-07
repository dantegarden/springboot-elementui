package com.dvt.elementui.biz.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "demo_customer")
public class DemoCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 性别  1男  2女
     */
    private String sex;

    /**
     * 地址
     */
    private String address;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**订单列表 一对多*/
    @Transient
    private List<DemoOrder> orderList;

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
     * 获取用户名
     *
     * @return name - 用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名
     *
     * @param name 用户名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取性别  1男  2女
     *
     * @return sex - 性别  1男  2女
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别  1男  2女
     *
     * @param sex 性别  1男  2女
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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


    public List<DemoOrder> getOrderList() {
        return this.orderList;
    }

    public void setOrderList(List<DemoOrder> orderList) {
        this.orderList = orderList;
    }
}