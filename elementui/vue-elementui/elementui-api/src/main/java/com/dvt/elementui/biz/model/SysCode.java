package com.dvt.elementui.biz.model;

import com.dvt.elementui.common.base.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="sys_code")
public class SysCode extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, precision = 12, scale = 0)
    private Integer id;

    /**
     * 字典键
     */
    @Column(name = "code_key")
    private String codeKey;

    /**
     * 字典类型
     */
    @Column(name = "code_type")
    private String codeType;

    /**
     * 字典名
     */
    @Column(name = "code_name")
    private String codeName;

    /**
     * 字典值
     */
    @Column(name = "code_value")
    private String codeValue;

    /**
     * 排序
     */
    @Column(name = "order_number")
    private Integer orderNumber;

    /**
     * 生效标志
     */
    @Column(name = "enabled")
    private Integer enabled;

    public SysCode() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeKey() {
        return this.codeKey;
    }

    public void setCodeKey(String codeKey) {
        this.codeKey = codeKey;
    }

    public String getCodeType() {
        return this.codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getCodeName() {
        return this.codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeValue() {
        return this.codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public Integer getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}
