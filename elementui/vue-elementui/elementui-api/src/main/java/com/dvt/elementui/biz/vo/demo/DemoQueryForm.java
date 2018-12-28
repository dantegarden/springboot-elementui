package com.dvt.elementui.biz.vo.demo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class DemoQueryForm {

    private String orderSn;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private List<Date> orderTime;

    private String orderStatus;

    public DemoQueryForm() {
    }

    public String getOrderSn() {
        return this.orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public List<Date> getOrderTime() {
        return this.orderTime;
    }

    public void setOrderTime(List<Date> orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
