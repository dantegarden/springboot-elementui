package com.dvt.elementui.biz.service.impl;

import com.dvt.elementui.biz.dao.*;
import com.dvt.elementui.biz.model.*;
import com.dvt.elementui.biz.service.DemoService;
import com.dvt.elementui.biz.vo.demo.QueryForm;
import com.dvt.elementui.common.base.BaseServiceImpl;
import com.dvt.elementui.common.utils.CommonHelper;
import com.dvt.elementui.common.utils.PivotUtils;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DemoServiceImpl extends BaseServiceImpl implements DemoService {

    @Autowired
    private DemoOrderDao demoOrderDao;
    @Autowired
    private DemoOrderItemDao demoOrderItemDao;
    @Autowired
    private DemoCustomerDao demoCustomerDao;
    @Autowired
    private DemoGoodsDao demoGoodsDao;
    @Autowired
    private DemoPivotDao demoPivotDao;
    @Autowired
    private DemoPivotCollectionDao demoPivotCollectionDao;

    @Override
    public Page<DemoOrder> queryByPage(Map<String, Object> condition, Integer page, Integer size) {
        Map<String,Object> params = Maps.newHashMap();
        StringBuilder sql = new StringBuilder();
        sql.append("select o from DemoOrder o where isEnabled=1  ");

        if(condition.get("orderSn")!=null && StringUtils.isNotBlank((String)condition.get("orderSn"))){
            sql.append("     and o.orderSn like concat('%',:orderSn,'%')  ");
            params.put("orderSn", (String)condition.get("orderSn"));
        }
        if(condition.get("orderStatus")!=null && StringUtils.isNotBlank((String)condition.get("orderStatus"))){
            sql.append("     and o.orderStatus = :orderStatus ");
            params.put("orderStatus", Integer.parseInt((String)condition.get("orderStatus")));
        }
        if(condition.get("orderTime")!=null){
            sql.append("     and o.orderTime >= :orderTime1 ");
            sql.append("     and o.orderTime <= :orderTime2 ");
            List<Date> dates = (List<Date>)condition.get("orderTime");
            params.put("orderTime1", dates.get(0));
            params.put("orderTime2", dates.get(1));
        }
        sql.append(" order by orderTime desc ");

        PageRequest pageReq = PageRequest.of(page-1, size);
        return dynamicQuery.query(DemoOrder.class, pageReq, sql.toString(), params);
    }

    @Override
    public DemoOrder findOrderById(Integer id) {
        return this.demoOrderDao.findById(id).get();
    }

    @Override
    public Integer addOrder() {
        DemoOrder newOrder = new DemoOrder();
        newOrder.setIsEnabled(0);
        return this.demoOrderDao.save(newOrder).getId();
    }

    @Override
    public Integer saveOrder(DemoOrder order){
        DemoOrder oldOrder = this.demoOrderDao.findById(order.getId()).get();
        CommonHelper.copyPropertiesIgnoreNull(order, oldOrder);
        oldOrder.setIsEnabled(1);
        return this.demoOrderDao.save(oldOrder).getId();
    }

    @Override
    public List<DemoOrderItem> queryOrderItems(Integer orderId) {
        return this.demoOrderItemDao.findByOrderById(orderId);
    }

    @Override
    public Integer saveOrderItem(DemoOrderItem oi) {
        return this.demoOrderItemDao.save(oi).getId();
    }

    @Override
    public void deleteOrder(Integer id) {
        this.demoOrderDao.deleteById(id);
    }

    @Override
    public void deleteOrderItem(Integer id) {
        this.demoOrderItemDao.deleteById(id);
    }

    @Override
    public List<DemoCustomer> findCustomersByName(String name) {
        return this.demoCustomerDao.findByNameIsLike("%"+ name + "%");
    }

    @Override
    public List<DemoGoods> findGoodsByName(String name) {
        return this.demoGoodsDao.findByGoodsNameIsLike("%"+ name + "%");
    }

    @Override
    public List<DemoPivotCollection> findCollectionsByUserId(Integer id) {
        return this.demoPivotCollectionDao.findByUserId(id);
    }

    @Override
    public List<DemoPivot> findPivotDatas(QueryForm condition) {
        StringBuilder sql = new StringBuilder();
        sql.append("select p from DemoPivot p where 1=1 ");
        sql.append(PivotUtils.transformToSql(condition));
        return this.dynamicQuery.query(DemoPivot.class, sql.toString());
    }

    @Override
    public Integer saveDemoPivotCollection(DemoPivotCollection demoPivotCollection) {
        return this.demoPivotCollectionDao.save(demoPivotCollection).getId();
    }

    @Override
    public void deleteDemoPivotCollection(Integer id) {
        this.demoPivotCollectionDao.deleteById(id);
    }


}
