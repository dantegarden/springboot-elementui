package com.dvt.elementui.biz.dao;

import com.dvt.elementui.biz.model.DemoCustomer;
import com.dvt.elementui.common.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoCustomerDao extends BaseRepository<DemoCustomer,Integer> {
}
