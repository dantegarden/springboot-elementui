package com.dvt.elementui.biz.dao;

import com.dvt.elementui.biz.model.DemoOrderItem;
import com.dvt.elementui.common.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoOrderItemDao extends BaseRepository<DemoOrderItem, Integer> {

    @Query("select oi from DemoOrderItem oi where oi.order.id = ?1")
    List<DemoOrderItem> findByOrderById(Integer id);
}