package com.dvt.elementui.biz.vo.demo;

import java.util.List;

public class QueryForm {

    private List<String> rowKeys;
    private List<String> colKeys;
    private List<FieldFilterVO> fieldFilter;

    public QueryForm(List<String> rowKeys, List<String> colKeys, List<FieldFilterVO> fieldFilter) {
        this.rowKeys = rowKeys;
        this.colKeys = colKeys;
        this.fieldFilter = fieldFilter;
    }

    public QueryForm() {
    }

    public List<String> getRowKeys() {
        return this.rowKeys;
    }

    public void setRowKeys(List<String> rowKeys) {
        this.rowKeys = rowKeys;
    }

    public List<String> getColKeys() {
        return this.colKeys;
    }

    public void setColKeys(List<String> colKeys) {
        this.colKeys = colKeys;
    }

    public List<FieldFilterVO> getFieldFilter() {
        return this.fieldFilter;
    }

    public void setFieldFilter(List<FieldFilterVO> fieldFilter) {
        this.fieldFilter = fieldFilter;
    }
}
