package com.dvt.elementui.biz.dao;

import com.dvt.elementui.biz.model.SysRole;
import com.dvt.elementui.common.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRoleDao extends BaseRepository<SysRole, Integer> {

    @Query("select new SysRole(r.id, r.roleName) from SysRole r where r.deleteStatus = 1 ")
    List<SysRole> queryRoles();

}
