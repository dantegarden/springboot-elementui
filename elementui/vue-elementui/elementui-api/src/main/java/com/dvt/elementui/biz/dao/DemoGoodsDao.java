package com.dvt.elementui.biz.dao;

import com.dvt.elementui.biz.model.DemoGoods;
import com.dvt.elementui.common.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoGoodsDao extends BaseRepository<DemoGoods, Integer> {

    List<DemoGoods> findByGoodsNameIsLike(String name);
}
