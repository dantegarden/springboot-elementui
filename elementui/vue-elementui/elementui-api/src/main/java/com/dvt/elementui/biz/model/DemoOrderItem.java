package com.dvt.elementui.biz.model;

import com.dvt.elementui.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="demo_order_item")
public class DemoOrderItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, precision = 12, scale = 0)
    private Integer id;

    /**多对一**/
    @JsonIgnoreProperties(value = {"ordersItems", "hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name = "order_id")
    private DemoOrder order;

    /**
     * 单向多对一
     * **/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id")
    private DemoGoods goods;

    /**
     * 成交单价
     */
    @Column(name = "retail_price")
    private Double retailPrice;

    /**
     * 数量
     * **/
    @Column(name = "number")
    private Integer number;

    /**
     * 成交总价
     * **/
    @Column(name = "total_price")
    private Double totalPrice;

    public DemoOrderItem() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DemoOrder getOrder() {
        return this.order;
    }

    public void setOrder(DemoOrder order) {
        this.order = order;
    }

    public DemoGoods getGoods() {
        return this.goods;
    }

    public void setGoods(DemoGoods goods) {
        this.goods = goods;
    }

    public Double getRetailPrice() {
        return this.retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
