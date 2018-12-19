package com.dvt.elementui.biz.vo.demo;

import com.dvt.elementui.common.converter.JsonDateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
