package com.dvt.elementui.biz.dao;

import com.dvt.elementui.biz.model.SysOrganization;
import com.dvt.elementui.common.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysOrganizationDao extends BaseRepository<SysOrganization, Integer> {

    @Query("select o from SysOrganization o where o.parent = null ")
    List<SysOrganization> queryRootOrgs();
}
