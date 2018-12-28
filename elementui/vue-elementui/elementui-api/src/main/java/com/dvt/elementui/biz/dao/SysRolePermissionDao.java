package com.dvt.elementui.biz.dao;

import com.dvt.elementui.biz.model.SysRolePermission;
import com.dvt.elementui.common.base.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRolePermissionDao extends BaseRepository<SysRolePermission, Integer> {

    @Modifying
    @Query("delete from SysRolePermission rp where rp.role.id = ?1 ")
    int deleteByRoleId(Integer roleId);

}
