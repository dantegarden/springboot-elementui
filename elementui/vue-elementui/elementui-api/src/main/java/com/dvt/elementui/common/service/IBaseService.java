package com.dvt.elementui.common.service;

import java.util.List;

public interface IBaseService<T> {

    int deleteById(Integer id);

    int insert(T record);

    T selectById(Integer id);

    List<T> selectAll();

    int updateById(T record);
}
