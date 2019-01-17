package com.dvt.elementui.biz.vo.demo;

public class DemoQueryObject {
    private String area;
    private String province;
    private String month;

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        if (area != null) {
            this.area = "%" + area + "%";
        }
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        if (province != null) {
            this.province = "%" + province + "%";
        }
    }

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String month) {
        if (month != null) {
            this.month = "%" + month + "%";
        }
    }
}
