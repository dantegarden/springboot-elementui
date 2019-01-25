package com.dvt.elementui.biz.easyexcel.demo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.util.Date;

public class ImportOrderModel extends BaseRowModel {

    @ExcelProperty(index = 0)
    private String orderSn;

    @ExcelProperty(index = 1)
    private String orderStatus;

    @ExcelProperty(index = 2)
    private String customerName;

    @ExcelProperty(index = 3)
    private String customerAddress;

    @ExcelProperty(index = 4)
    private String orderPrice;

    @ExcelProperty(index = 5, format = "yyyy-MM-dd")
    private Date orderTime;

    public String getOrderSn() {
        return this.orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return this.customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getOrderPrice() {
        return this.orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Date getOrderTime() {
        return this.orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}
