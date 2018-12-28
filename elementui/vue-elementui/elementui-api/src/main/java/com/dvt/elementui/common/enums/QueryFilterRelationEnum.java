package com.dvt.elementui.common.enums;

public enum QueryFilterRelationEnum {
    /**
     * 筛选器 关联关系类型
     */
    AND("and"),
    OR("or");

    private String value;

    QueryFilterRelationEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
