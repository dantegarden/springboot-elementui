package com.dvt.elementui.common.bean;

import com.dvt.elementui.biz.vo.auth.UserVO;
import org.springframework.data.domain.Page;

import java.util.List;

public class PageData {

    private List list;
    private Long total;

    public PageData() {
    }

    public PageData(List list, Long total) {
        this.list = list;
        this.total = total;
    }

    public PageData(Page pageInfo) {
        this.list = pageInfo.getContent();
        this.total = pageInfo.getTotalElements();
    }

    public List getList() {
        return this.list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
