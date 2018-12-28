package com.dvt.elementui.biz.model;

import com.dvt.elementui.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.nutz.dao.entity.annotation.One;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="demo_customer")
public class DemoCustomer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, precision = 12, scale = 0)
    private Integer id;

    /**
     * 用户名
     */
    @Column(name = "name")
    private String name;

    /**
     * 性别  1男  2女
     */
    @Column(name = "sex")
    private Integer sex;

    /**
     * 地址
     */
    @Column(name = "address")
    private String address;


    /**一对多**/
    @JsonIgnoreProperties(value = {"customer", "hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<DemoOrder> orders;

    public DemoCustomer() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<DemoOrder> getOrders() {
        return this.orders;
    }

    public void setOrders(Set<DemoOrder> orders) {
        this.orders = orders;
    }
}
