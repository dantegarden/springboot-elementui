package com.dvt.elementui.biz.service;

import com.dvt.elementui.biz.model.DemoOrder;
import com.dvt.elementui.biz.model.DemoPivot;
import com.dvt.elementui.biz.model.DemoPivotCollection;
import com.dvt.elementui.biz.vo.demo.QueryForm;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface DemoService {

    public Page<DemoOrder> queryByPage(Map<String, Object> condition, Integer page, Integer size);

    public List<DemoPivotCollection> findCollectionsByUserId(Integer id);

    public List<DemoPivot> findPivotDatas(QueryForm queryForm);

    public Integer saveDemoPivotCollection(DemoPivotCollection demoPivotCollection);

    public void deleteDemoPivotCollection(Integer id);
}
