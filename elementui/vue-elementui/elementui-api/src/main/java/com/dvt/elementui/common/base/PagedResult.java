package com.dvt.elementui.common.base;

import java.util.List;

public class PagedResult {

    private Long total;
    private List<?> rows;

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return this.rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
