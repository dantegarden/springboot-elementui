package com.dvt.elementui.biz.dao;

import com.dvt.elementui.biz.model.SysMenu;
import com.dvt.elementui.biz.model.SysUser;
import com.dvt.elementui.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /***返回根菜单***/
    public List<SysMenu> getRootMenu();

    /***根据父一级菜单，返回所有子菜单***/
    public List<SysMenu> findMenuByPid(String pid);

}