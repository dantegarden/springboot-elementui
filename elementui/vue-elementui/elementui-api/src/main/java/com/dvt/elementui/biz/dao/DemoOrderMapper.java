package com.dvt.elementui.biz.dao;

import com.dvt.elementui.biz.model.DemoOrder;
import com.dvt.elementui.common.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DemoOrderMapper extends BaseMapper<DemoOrder> {

    List<DemoOrder> queryOrders(@Param("condition") Map<String, Object> condition);
}