package com.dvt.elementui.common;

public class PageVO {

    private Integer page;
    private Integer size;
    private String orderBy;

    public PageVO() {
    }

    public PageVO(Integer page, Integer size, String orderBy) {
        this.page = page;
        this.size = size;
        this.orderBy = orderBy;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return this.size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getOrderBy() {
        return this.orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
