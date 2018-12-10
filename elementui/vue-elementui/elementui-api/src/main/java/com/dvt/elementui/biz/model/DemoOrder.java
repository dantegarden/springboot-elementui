package com.dvt.elementui.biz.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "demo_order")
public class DemoOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 顾客id
     */
    @Column(name = "customer_id")
    private Integer customerId;

    /**
     * 订单号
     */
    @Column(name = "order_sn")
    private String orderSn;

    /**
     * 订单状态 1 待付款 2 待发货 3 待收货 4 完成
     */
    @Column(name = "order_status")
    private String orderStatus;

    /**
     * 订单总价
     */
    @Column(name = "order_price")
    private Double orderPrice;

    /**
     * 备注
     */
    private String note;

    /**
     * 下单时间
     */
    @Column(name = "order_time")
    private Date orderTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**多对一 顾客**/
    @Transient
    private DemoCustomer customer;

    /**多对多 商品**/
    @Transient
    private List<DemoGoods> goodsList;

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
     * 获取顾客id
     *
     * @return customer_id - 顾客id
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * 设置顾客id
     *
     * @param customerId 顾客id
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取订单号
     *
     * @return order_sn - 订单号
     */
    public String getOrderSn() {
        return orderSn;
    }

    /**
     * 设置订单号
     *
     * @param orderSn 订单号
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    /**
     * 获取订单状态 1 待付款 2 待发货 3 待收货 4 完成
     *
     * @return order_status - 订单状态 1 待付款 2 待发货 3 待收货 4 完成
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置订单状态 1 待付款 2 待发货 3 待收货 4 完成
     *
     * @param orderStatus 订单状态 1 待付款 2 待发货 3 待收货 4 完成
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    /**
     * 获取订单总价
     *
     * @return order_price - 订单总价
     */
    public Double getOrderPrice() {
        return orderPrice;
    }

    /**
     * 设置订单总价
     *
     * @param orderPrice 订单总价
     */
    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * 获取备注
     *
     * @return note - 备注
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置备注
     *
     * @param note 备注
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * 获取下单时间
     *
     * @return order_time - 下单时间
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * 设置下单时间
     *
     * @param orderTime 下单时间
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
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

    public DemoCustomer getCustomer() {
        return this.customer;
    }

    public void setCustomer(DemoCustomer customer) {
        this.customer = customer;
    }

    public List<DemoGoods> getGoodsList() {
        return this.goodsList;
    }

    public void setGoodsList(List<DemoGoods> goodsList) {
        this.goodsList = goodsList;
    }
}