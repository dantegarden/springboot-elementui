package com.dvt.elementui.common.base;

import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface BaseSerivce {
    /**获取example**/
    Example getExample(Class entityClass, List<String> condition);
}
