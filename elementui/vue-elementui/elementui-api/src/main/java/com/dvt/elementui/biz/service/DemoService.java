package com.dvt.elementui.biz.service;

import com.dvt.elementui.biz.model.DemoOrder;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface DemoService {

    /**分页条件查询**/
    PageInfo<DemoOrder> queryByPage(Map<String, Object> condition, Integer page, Integer size);
}
