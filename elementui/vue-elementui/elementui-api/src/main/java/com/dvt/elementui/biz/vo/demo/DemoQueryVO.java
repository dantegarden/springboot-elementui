package com.dvt.elementui.biz.vo.demo;

import com.dvt.elementui.common.PageVO;

public class DemoQueryVO extends PageVO {

    private DemoQueryForm queryCondition;

    public DemoQueryForm getQueryCondition() {
        return this.queryCondition;
    }

    public void setQueryCondition(DemoQueryForm queryCondition) {
        this.queryCondition = queryCondition;
    }
}
