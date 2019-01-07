package com.dvt.elementui.biz.dao;

import com.dvt.elementui.biz.model.DemoCustomer;
import com.dvt.elementui.common.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoCustomerDao extends BaseRepository<DemoCustomer,Integer> {

    List<DemoCustomer> findByNameIsLike(String name);
}
