package com.dvt.elementui.biz.dao;

import com.dvt.elementui.biz.model.DemoPivot;
import com.dvt.elementui.biz.vo.demo.DemoQueryObject;
import com.dvt.elementui.biz.vo.demo.TestVO;
import com.dvt.elementui.common.base.BaseRepository;
import com.slyak.spring.jpa.TemplateQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoPivotDao extends BaseRepository<DemoPivot,Integer> {

    @TemplateQuery
    Long countArea(@Param("area") String area);

    @TemplateQuery
    List<TestVO> getDtos(@Param("month") String month);

    @TemplateQuery
    List<DemoPivot> findByQueryObj(DemoQueryObject queryObject);

}
