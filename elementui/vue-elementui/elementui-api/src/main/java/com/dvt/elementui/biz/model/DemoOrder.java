package com.dvt.elementui.biz.model;

import com.dvt.elementui.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="demo_order")
public class DemoOrder extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, precision = 12, scale = 0)
    private Integer id;

    /**
     * 订单号
     */
    @Column(name = "order_sn")
    private String orderSn;

    /**
     * 订单状态 1 待付款 2 待发货 3 待收货 4 完成
     */
    @Column(name = "order_status")
    private Integer orderStatus;

    /**
     * 订单总价
     */
    @Column(name = "order_price")
    private Double orderPrice;

    /**
     * 备注
     */
    @Column(name = "note")
    private String note;

    /**
     * 下单时间
     */
    @Column(name = "order_time")
    private Date orderTime;

    /**多对一**/
    @JsonIgnoreProperties(value = {"orders", "hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private DemoCustomer customer;

    /**一对多**/
    @JsonIgnoreProperties(value = {"permission", "hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Set<DemoOrderItem> orderItems;


    @Column(name="is_enabled")
    private Integer isEnabled;

    public DemoOrder() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderSn() {
        return this.orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Integer getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getOrderPrice() {
        return this.orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getOrderTime() {
        return this.orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public DemoCustomer getCustomer() {
        return this.customer;
    }

    public void setCustomer(DemoCustomer customer) {
        this.customer = customer;
    }

    public Set<DemoOrderItem> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(Set<DemoOrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Integer getIsEnabled() {
        return this.isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }
}
