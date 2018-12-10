package com.dvt.elementui.biz.dao;

import com.dvt.elementui.biz.model.SysRole;
import com.dvt.elementui.common.base.BaseMapper;
import com.dvt.elementui.common.bean.UserPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 查询所有的角色
     * 在添加/修改用户的时候要使用此方法
     *
     * @return
     */
    List<SysRole> getAllRoles();

    /**
     * 查询所有角色的用户和权限
     * **/
    List<UserPermission> listRole(@Param("condition") Map<String,Object> condition);
}