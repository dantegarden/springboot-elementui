package com.dvt.elementui.biz.vo.demo;

public class FieldVO {

    private String field;
    private String label;

    public FieldVO() {
    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public FieldVO(String field, String label) {
        this.field = field;
        this.label = label;
    }
}
