package com.dvt.elementui.biz.model;

import com.dvt.elementui.common.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="demo_pivot")
public class DemoPivot extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, precision = 12, scale = 0)
    private Integer id;

    @Column(name = "area")
    private String area;

    @Column(name = "province")
    private String province;

    @Column(name = "month")
    private String month;

    @Column(name = "major")
    private String major;

    @Column(name = "subject")
    private String subject;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "value")
    private String value;

    public DemoPivot() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMajor() {
        return this.major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Double getRate() {
        return this.rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
