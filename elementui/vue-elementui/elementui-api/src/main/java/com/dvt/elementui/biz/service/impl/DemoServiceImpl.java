package com.dvt.elementui.biz.service.impl;

import com.dvt.elementui.biz.dao.DemoGoodsDao;
import com.dvt.elementui.biz.dao.DemoOrderDao;
import com.dvt.elementui.biz.dao.DemoPivotCollectionDao;
import com.dvt.elementui.biz.dao.DemoPivotDao;
import com.dvt.elementui.biz.model.DemoOrder;
import com.dvt.elementui.biz.model.DemoPivot;
import com.dvt.elementui.biz.model.DemoPivotCollection;
import com.dvt.elementui.biz.service.DemoService;
import com.dvt.elementui.biz.vo.demo.FieldFilterVO;
import com.dvt.elementui.biz.vo.demo.QueryForm;
import com.dvt.elementui.common.base.BaseServiceImpl;
import com.dvt.elementui.common.enums.QueryFilterRelationEnum;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DemoServiceImpl extends BaseServiceImpl implements DemoService {

    @Autowired
    private DemoOrderDao demoOrderDao;
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
        sql.append("select o from DemoOrder o where 1=1 ");

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
    public List<DemoPivotCollection> findCollectionsByUserId(Integer id) {
        return this.demoPivotCollectionDao.findByUserId(id);
    }

    @Override
    public List<DemoPivot> findPivotDatas(QueryForm condition) {
        StringBuilder sql = new StringBuilder();
        sql.append("select p from DemoPivot p where 1=1 ");
        sql.append(transformToSql(condition));
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

    private String transformToSql(QueryForm queryForm){
        StringBuilder sql = new StringBuilder();
        List<FieldFilterVO> fieldFilter = queryForm.getFieldFilter();
        for (FieldFilterVO ffvo: fieldFilter) {
            sql.append(" and ");

            if(ffvo.getRelation().equals("and")){
                List<List<String>> conditions = ffvo.getQuery();
                sql.append(" ( 1=1 ");
                for(List<String> items: conditions){
                    String field = items.get(0);
                    String relation = items.get(1);
                    String value = items.get(2);
                    this.transformFilter(QueryFilterRelationEnum.AND.getValue(), field, relation, value, sql);
                }
                sql.append(" ) ");
            }else if(ffvo.getRelation().equals("or")){
                List<List<String>> conditions = ffvo.getQuery();
                sql.append(" ( 1=0 ");
                for(List<String> items: conditions){
                    String field = items.get(0);
                    String relation = items.get(1);
                    String value = items.get(2);
                    this.transformFilter(QueryFilterRelationEnum.OR.getValue(), field, relation, value, sql);
                }
                sql.append(" ) ");
            }
        }
        sql.append(" order by month ");
//        List<String> items = (List<String>) CollectionUtils.union(queryForm.getRowKeys(), queryForm.getColKeys());
//        if(CollectionUtils.isNotEmpty(items)){
//            sql.append(" order by ");
//            for(String item: items){
//                sql.append(item +",");
//                sql = new StringBuilder(sql.substring(0, sql.length()-1));
//            }
//        }

        return sql.toString();
    }

    private void transformFilter(String type, String key,String relation, String value, StringBuilder sql){
        boolean flag = false;
        if("=".equals(relation)){
            sql.append(MessageFormat.format(" {0} {1} = ''{2}'' ", type, key,value));
        }else if("!=".equals(relation)){
            sql.append(MessageFormat.format(" {0} {1} != ''{2}'' ", type, key,value));
        }else if("like".equals(relation)){
            sql.append(MessageFormat.format(" {0} {1} like ''%{2}%'' ", type, key,value));
        }else if("not like".equals(relation)){
            sql.append(MessageFormat.format(" {0} {1} not like ''%{2}%'' ", type, key,value));
        }else if("startwith".equals(relation)){
            sql.append(MessageFormat.format(" {0} {1} like ''%{2}'' ", type, key,value));
        }else if("endwith".equals(relation)){
            sql.append(MessageFormat.format(" {0} {1} like ''{2}%'' ", type, key,value));
        }
    }
}
