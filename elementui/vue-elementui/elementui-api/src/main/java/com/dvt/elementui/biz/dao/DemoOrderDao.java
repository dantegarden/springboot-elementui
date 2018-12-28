package com.dvt.elementui.biz.dao;

import com.dvt.elementui.biz.model.DemoOrder;
import com.dvt.elementui.common.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoOrderDao extends BaseRepository<DemoOrder,Integer> {
}
