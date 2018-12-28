package com.dvt.elementui.biz.vo.demo;

import java.util.List;

public class FieldFilterVO {

    private String label;
    private String relation;
    private List<List<String>> query;

    public FieldFilterVO(String label, String relation, List<List<String>> query) {
        this.label = label;
        this.relation = relation;
        this.query = query;
    }

    public FieldFilterVO() {
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRelation() {
        return this.relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public List<List<String>> getQuery() {
        return this.query;
    }

    public void setQuery(List<List<String>> query) {
        this.query = query;
    }
}
