package com.dvt.elementui.biz.dao;

import com.dvt.elementui.biz.model.DemoPivotCollection;
import com.dvt.elementui.common.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoPivotCollectionDao extends BaseRepository<DemoPivotCollection, Integer> {

    @Query("select c from DemoPivotCollection c where c.user.id = ?1 ")
    List<DemoPivotCollection> findByUserId(Integer id);
}
