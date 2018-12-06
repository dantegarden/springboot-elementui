package com.dvt.elementui.biz.service.impl;

import com.dvt.elementui.biz.dao.*;
import com.dvt.elementui.biz.model.*;
import com.dvt.elementui.biz.service.UserService;
import com.dvt.elementui.biz.vo.RoleVO;
import com.dvt.elementui.common.bean.UserPermission;
import com.dvt.elementui.common.exception.BusinessException;
import com.dvt.elementui.common.utils.CommonHelper;
import com.dvt.elementui.common.utils.PasswordUtils;
import com.dvt.elementui.common.utils.RandomUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysPermissionMapper permissionMapper;

    @Autowired
    private SysRolePermissionMapper rolePermissionMapper;

    @Override
    public PageInfo<UserPermission> queryByPage(Map<String, Object> condition, Integer page, Integer size) {
        //不使用PageHelper的原始分页方式, 需要手动查询总记录数
        //PageHelper.startPage(page,size);
        Integer offset = (page - 1) * size;
        List<UserPermission> list = userMapper.queryUserPermission(condition, offset, size);
        PageInfo<UserPermission> pageInfo = new PageInfo<UserPermission>(list);
        pageInfo.setTotal(this.countEffectiveUsers());
        return pageInfo;
    }

    @Override
    public List<SysRole> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    @Override
    public int addUser(SysUser user) {
        SysUser countUser = new SysUser();
        countUser.setUsername(user.getUsername());
        int exist = userMapper.selectCount(countUser);
        if(exist>0){
            return 0;
        }
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        return userMapper.insert(user);
    }

    @Override
    public int updateUser(SysUser user) {
        SysUser oldUser = userMapper.selectByPrimaryKey(user.getId());
        CommonHelper.copyPropertiesIgnoreNull(user, oldUser, true);
        oldUser.setUpdateTime(new Date());
        return userMapper.updateByPrimaryKey(oldUser);
    }

    @Override
    public int deleteUser(Integer id) {
        //return userMapper.deleteByPrimaryKey(id);
        //假删
        SysUser oldUser = userMapper.selectByPrimaryKey(id);
        oldUser.setDeleteStatus("2");
        oldUser.setUpdateTime(new Date());
        return userMapper.updateByPrimaryKey(oldUser);
    }

    @Override
    public List<UserPermission> listRole(Map<String, Object> condition) {
        List<UserPermission> list = roleMapper.listRole(condition);
        return list;
    }

    @Override
    public List<UserPermission> getAllPermission() {
        return permissionMapper.listAllPermission();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addRole(RoleVO role) {
        SysRole countRole = new SysRole();
        countRole.setRoleName(role.getRoleName());
        int exist = roleMapper.selectCount(countRole);
        if(exist>0){
            return 0;
        }
        Date now = new Date();
        CommonHelper.copyPropertiesIgnoreNull(role, countRole);
        countRole.setCreateTime(now);
        countRole.setUpdateTime(now);
        exist = roleMapper.insert(countRole);
        List<SysRolePermission> rpList = Lists.newArrayList();
        role.getPermissions().forEach(permId -> {
            SysRolePermission rolePermission = new SysRolePermission();
            rolePermission.setRoleId(countRole.getId());
            rolePermission.setPermissionId(permId);
            rolePermission.setDeleteStatus("1");
            rolePermission.setCreateTime(now);
            rolePermission.setUpdateTime(now);
            rpList.add(rolePermission);
        });
        rolePermissionMapper.insertList(rpList);
        return exist;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateRole(RoleVO role) {
        return 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteRole(Integer id) {
        SysRole role = roleMapper.selectByPrimaryKey(id);
        userMapper.selectByCondition()
        return 0;
    }

    private Integer countEffectiveUsers(){
        SysUser user = new SysUser();
        user.setDeleteStatus("1");
        return userMapper.selectCount(user);
    }
}
