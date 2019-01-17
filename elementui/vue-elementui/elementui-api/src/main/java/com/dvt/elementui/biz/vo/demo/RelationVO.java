package com.dvt.elementui.biz.vo.demo;

public class RelationVO {

    private String label;
    private String value;

    public RelationVO() {
    }

    public static RelationVO of(String label, String value){
        return new RelationVO(label, value);
    }

    public RelationVO(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
