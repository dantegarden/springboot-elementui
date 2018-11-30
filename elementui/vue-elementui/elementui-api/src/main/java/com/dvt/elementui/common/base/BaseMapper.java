package com.dvt.elementui.common.base;

import tk.mybatis.mapper.common.*;
import tk.mybatis.mapper.common.special.InsertListMapper;

public interface BaseMapper<T> extends tk.mybatis.mapper.common.BaseMapper<T>,
        ExampleMapper<T>, ConditionMapper<T>, IdsMapper<T>, InsertListMapper<T> {
}