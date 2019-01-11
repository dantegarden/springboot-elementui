package com.dvt.elementui.biz.service;

import com.dvt.elementui.biz.model.*;
import com.dvt.elementui.biz.vo.demo.QueryForm;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface DemoService {

    public Page<DemoOrder> queryByPage(Map<String, Object> condition, Integer page, Integer size);

    public DemoOrder findOrderById(Integer id);

    public Integer addOrder();

    public Integer saveOrder(DemoOrder order);

    public List<DemoOrderItem> queryOrderItems(Integer orderId);

    public Integer saveOrderItem(DemoOrderItem oi);

    public void deleteOrder(Integer id);

    public void deleteOrderItem(Integer id);

    public List<DemoCustomer> findCustomersByName(String name);

    public List<DemoGoods> findGoodsByName(String name);

    public List<DemoPivotCollection> findCollectionsByUserId(Integer id);

    public List<DemoPivot> findPivotDatas(QueryForm queryForm);

    public Integer saveDemoPivotCollection(DemoPivotCollection demoPivotCollection);

    public void deleteDemoPivotCollection(Integer id);
}
