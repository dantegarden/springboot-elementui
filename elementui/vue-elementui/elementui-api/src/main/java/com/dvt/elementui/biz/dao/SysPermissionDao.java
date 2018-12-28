package com.dvt.elementui.biz.dao;

import com.dvt.elementui.biz.model.SysPermission;
import com.dvt.elementui.biz.vo.auth.PermissionVO;
import com.dvt.elementui.biz.vo.auth.UserPermissionVO;
import com.dvt.elementui.common.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface SysPermissionDao extends BaseRepository<SysPermission, Integer> {

    /**
     * 查询所有的菜单
     *
     * @return
     */
    @Query("select menuCode from SysPermission order by id")
    Set<String> queryAllMenu();

    /**
     * 查询所有的权限
     *
     * @return
     */
    @Query("select permissionCode from SysPermission order by id")
    Set<String> getAllPermission();

}
