package com.dvt.elementui.biz.service.impl;

import com.dvt.elementui.biz.dao.DemoOrderMapper;
import com.dvt.elementui.biz.model.DemoOrder;
import com.dvt.elementui.biz.service.DemoService;
import com.dvt.elementui.common.base.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DemoServiceImpl extends BaseServiceImpl implements DemoService  {

    @Autowired
    private DemoOrderMapper orderMapper;

    @Override
    public PageInfo<DemoOrder> queryByPage(Map<String, Object> condition, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<DemoOrder> list = orderMapper.queryOrders(condition);
        return new PageInfo<DemoOrder>(list);
    }
}
