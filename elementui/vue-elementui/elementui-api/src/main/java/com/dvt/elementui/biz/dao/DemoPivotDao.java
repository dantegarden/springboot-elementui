package com.dvt.elementui.biz.dao;

import com.dvt.elementui.biz.model.DemoPivot;
import com.dvt.elementui.common.base.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoPivotDao extends BaseRepository<DemoPivot,Integer> {

}
