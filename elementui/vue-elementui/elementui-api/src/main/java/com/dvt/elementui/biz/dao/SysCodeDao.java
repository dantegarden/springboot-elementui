package com.dvt.elementui.biz.dao;

import com.dvt.elementui.biz.model.SysCode;
import com.dvt.elementui.common.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysCodeDao extends BaseRepository<SysCode,Integer> {

    @Query("select code from SysCode code where code.enabled = 1 order by code.orderNumber desc")
    List<SysCode> queryCodes();
}
