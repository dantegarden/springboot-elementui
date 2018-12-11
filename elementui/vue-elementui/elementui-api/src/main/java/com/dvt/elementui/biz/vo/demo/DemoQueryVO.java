package com.dvt.elementui.biz.vo.demo;

public class DemoQueryVO {

    private Integer page;
    private Integer size;
    private DemoQueryForm queryCondition;

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page==null?1:page;
    }

    public Integer getSize() {
        return this.size;
    }

    public void setSize(Integer size) {
        this.size = size==null?10:size;
    }

    public DemoQueryForm getQueryCondition() {
        return this.queryCondition;
    }

    public void setQueryCondition(DemoQueryForm queryCondition) {
        this.queryCondition = queryCondition;
    }
}
