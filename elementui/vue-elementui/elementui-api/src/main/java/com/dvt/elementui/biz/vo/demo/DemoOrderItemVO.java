package com.dvt.elementui.biz.vo.demo;

import com.dvt.elementui.biz.model.DemoGoods;
import com.dvt.elementui.biz.model.DemoOrder;

public class DemoOrderItemVO {
    private Integer id;
    private Integer number;
    private Double originPrice;
    private Double retailPrice;
    private Double totalPrice;
    private DemoGoods goods;
    private DemoOrder order;

    public DemoOrderItemVO() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getRetailPrice() {
        return this.retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public DemoGoods getGoods() {
        return this.goods;
    }

    public void setGoods(DemoGoods goods) {
        this.goods = goods;
    }

    public DemoOrder getOrder() {
        return this.order;
    }

    public void setOrder(DemoOrder order) {
        this.order = order;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getOriginPrice() {
        return this.originPrice;
    }

    public void setOriginPrice(Double originPrice) {
        this.originPrice = originPrice;
    }
}
