package com.dvt.elementui.biz.service.impl;

import com.dvt.elementui.biz.dao.SysMenuMapper;
import com.dvt.elementui.biz.dao.SysUserMapper;
import com.dvt.elementui.biz.model.SysMenu;
import com.dvt.elementui.biz.model.SysUser;
import com.dvt.elementui.biz.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysMenuMapper menuMapper;


    @Override
    public List<SysMenu> getMenus() {
        return menuMapper.getRootMenu();
    }

    @Override
    public PageInfo<SysUser> queryByPage(Map<String, Object> condition, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<SysUser> list = userMapper.queryByCondition(condition);
        return new PageInfo<SysUser>(list);
    }
}
