package com.dvt.elementui.biz.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "sys_code")
public class SysCode implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String enabled;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取字典键
     *
     * @return code_key - 字典键
     */
    public String getCodeKey() {
        return codeKey;
    }

    /**
     * 设置字典键
     *
     * @param codeKey 字典键
     */
    public void setCodeKey(String codeKey) {
        this.codeKey = codeKey == null ? null : codeKey.trim();
    }

    /**
     * 获取字典类型
     *
     * @return code_type - 字典类型
     */
    public String getCodeType() {
        return codeType;
    }

    /**
     * 设置字典类型
     *
     * @param codeType 字典类型
     */
    public void setCodeType(String codeType) {
        this.codeType = codeType == null ? null : codeType.trim();
    }

    /**
     * 获取字典名
     *
     * @return code_name - 字典名
     */
    public String getCodeName() {
        return codeName;
    }

    /**
     * 设置字典名
     *
     * @param codeName 字典名
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName == null ? null : codeName.trim();
    }

    /**
     * 获取字典值
     *
     * @return code_value - 字典值
     */
    public String getCodeValue() {
        return codeValue;
    }

    /**
     * 设置字典值
     *
     * @param codeValue 字典值
     */
    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue == null ? null : codeValue.trim();
    }

    /**
     * 获取排序
     *
     * @return order_number - 排序
     */
    public Integer getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置排序
     *
     * @param orderNumber 排序
     */
    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * 获取生效标志
     *
     * @return enabled - 生效标志
     */
    public String getEnabled() {
        return enabled;
    }

    /**
     * 设置生效标志
     *
     * @param enabled 生效标志
     */
    public void setEnabled(String enabled) {
        this.enabled = enabled == null ? null : enabled.trim();
    }
}