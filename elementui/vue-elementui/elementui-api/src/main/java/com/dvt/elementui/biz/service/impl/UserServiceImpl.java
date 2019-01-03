package com.dvt.elementui.biz.service.impl;

import com.dvt.elementui.biz.dao.*;
import com.dvt.elementui.biz.model.SysOrganization;
import com.dvt.elementui.biz.model.SysRole;
import com.dvt.elementui.biz.model.SysRolePermission;
import com.dvt.elementui.biz.model.SysUser;
import com.dvt.elementui.biz.service.UserService;
import com.dvt.elementui.biz.vo.auth.PermissionVO;
import com.dvt.elementui.biz.vo.auth.RolePermissionVO;
import com.dvt.elementui.biz.vo.auth.RoleVO;
import com.dvt.elementui.biz.vo.auth.UserVO;
import com.dvt.elementui.common.base.BaseServiceImpl;
import com.dvt.elementui.common.exception.BusinessException;
import com.dvt.elementui.common.utils.CommonHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Autowired
    private SysUserDao userDao;
    @Autowired
    private SysRoleDao roleDao;
    @Autowired
    private SysPermissionDao permissionDao;
    @Autowired
    private SysRolePermissionDao rolePermissionDao;
    @Autowired
    private SysOrganizationDao organizationDao;

    @Override
    public Page<UserVO> queryByPage(Map<String, Object> condition, Integer page, Integer size) {
        Map<String,Object> params = Maps.newHashMap();
        StringBuilder sql = new StringBuilder();
        sql.append("select new com.dvt.elementui.biz.vo.auth.UserVO(u.id, u.username, u.nickname, u.createTime, u.updateTime, u.deleteStatus, u.role.id, u.role.roleName, u.organization.id, u.organization.orgName) ");
        sql.append("from ");
        sql.append("SysUser u ");
        sql.append("left join u.organization ");
        sql.append("left join u.role ");
        sql.append("where u.deleteStatus = 1 ");
        if(condition.get("username")!=null && StringUtils.isNotBlank((String)condition.get("username"))){
            sql.append("     and u.username like concat('%',:username,'%')  ");
            params.put("username", (String)condition.get("username"));
        }
        sql.append(" order by u.id ");

        PageRequest pageReq = PageRequest.of(page-1, size);
        Page<UserVO> result = this.dynamicQuery.query(UserVO.class, pageReq, sql.toString(), params);
        result.getContent().forEach(userVO -> {
            if(userVO.getRoleId()!=null){
                SysRole role = roleDao.findById(userVO.getRoleId()).get();
                String permissionName = "";
                for(SysRolePermission rp: role.getRolePermissions()){
                    permissionName += rp.getPermission().getMenuName() +":"+ rp.getPermission().getPermissionName()+",";
                }
                userVO.setPermissionName(permissionName.substring(0,permissionName.length()-1));
            }
        });
        return result;
    }

    @Override
    public List<SysRole> getAllRoles() {
        List<SysRole> roles = roleDao.queryRoles();
        return roles;
    }

    @Override
    public int addUser(SysUser user) {
        SysUser countUser = new SysUser();
        countUser.setUsername(user.getUsername());
        long exist = userDao.count(Example.of(countUser));
        if(exist>0){
            return 0;
        }
        if(user.getOrgId()!=0){
            SysOrganization organization = organizationDao.findById(user.getOrgId()).get();
            user.setOrganization(organization);
        }
        if(user.getRoleId()!=null){
            SysRole role = roleDao.findById(user.getRoleId()).get();
            user.setRole(role);
        }
        user.setDeleteStatus(1);
        return userDao.save(user).getId();
    }

    @Override
    public int updateUser(SysUser user) {
        SysUser oldUser = userDao.findById(user.getId()).get();
        CommonHelper.copyPropertiesIgnoreNull(user, oldUser, true);
        if(user.getRoleId()!=null){
            SysRole role = roleDao.findById(user.getRoleId()).get();
            oldUser.setRole(role);
        }
        if(user.getOrgId()!=0){
            SysOrganization organization = organizationDao.findById(user.getOrgId()).get();
            oldUser.setOrganization(organization);
        }
        return userDao.save(oldUser).getId();
    }

    @Override
    public int deleteUser(Integer id) {
        //return userMapper.deleteByPrimaryKey(id);
        //假删
        SysUser oldUser = userDao.findById(id).get();
        oldUser.setDeleteStatus(2);
        return userDao.save(oldUser).getId();
    }

    @Override
    public List<RolePermissionVO> listRole(Map<String, Object> condition) {
        Map<String,Object> params = Maps.newHashMap();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT \n" +
                "            r.id              roleId,\n" +
                "            r.role_name       roleName,\n" +
                "            GROUP_CONCAT(u.id)              userId,\n" +
                "            GROUP_CONCAT(u.nickname)        nickname,\n" +
                "            GROUP_CONCAT(p.menu_code)       menuCode,\n" +
                "            GROUP_CONCAT(p.menu_name)       menuName,\n" +
                "            GROUP_CONCAT(p.id)              permissionId,\n" +
                "            GROUP_CONCAT(p.permission_name) permissionName ");
        sql.append("FROM sys_role r ");
        sql.append("LEFT JOIN sys_user u ON r.id = u.role_id AND u.delete_status = 1  ");
        sql.append("LEFT JOIN sys_role_permission rp ON r.id = rp.role_id AND rp.delete_status = 1 ");
        sql.append("LEFT JOIN sys_permission p ON rp.permission_id = p.id ");
        sql.append("WHERE r.delete_status = 1 ");
        if(condition.get("roleName")!=null && StringUtils.isNotBlank((String)condition.get("roleName"))){
            sql.append("     and r.role_name like concat('%',:roleName,'%')  ");
            params.put("roleName", (String)condition.get("roleName"));
        }
        sql.append(" GROUP BY r.id ORDER BY r.id asc ");
        List<RolePermissionVO> result = this.dynamicQuery.nativeQuery(RolePermissionVO.class, sql.toString(), params);

        return result;
    }

    @Override
    public List<PermissionVO> getAllPermission() {
        Map<String,Object> params = Maps.newHashMap();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT p.menu_name, GROUP_CONCAT(p.id), GROUP_CONCAT(p.menu_code), \n" +
                "GROUP_CONCAT(p.permission_code) ,GROUP_CONCAT(p.permission_name) , GROUP_CONCAT(p.required_permission) " +
                "FROM sys_permission p " +
                "WHERE 1 = 1 " +
                "GROUP BY p.menu_name ");
        List<PermissionVO> result = dynamicQuery.nativeQuery(PermissionVO.class, sql.toString(), params);
        return result;
    }

    @Override
    public int addRole(RoleVO role) {
        SysRole countRole = new SysRole();
        countRole.setRoleName(role.getRoleName());
        int exist = new Long(roleDao.count(Example.of(countRole))).intValue();
        if(exist>0){
            return 0;
        }
        CommonHelper.copyPropertiesIgnoreNull(role, countRole);
        Set<SysRolePermission> rps = Sets.newHashSet();
        role.getPermissions().forEach(permissionId -> {
            SysRolePermission rolePermission = new SysRolePermission();
            rolePermission.setRole(countRole);
            rolePermission.setPermission(permissionDao.getOne(permissionId));
            rolePermission.setDeleteStatus(1);
            rps.add(rolePermission);
        });
        countRole.setRolePermissions(rps);
        countRole.setDeleteStatus(1);
        exist = roleDao.save(countRole).getId();
        return exist;
    }

    @Override
    public int updateRole(RoleVO role) {
        SysRole oldRole = roleDao.findById(role.getId()).get();
        CommonHelper.copyPropertiesIgnoreNull(role, oldRole, true);
        Set<SysRolePermission> rpList = Sets.newHashSet();
        rolePermissionDao.deleteByRoleId(oldRole.getId());
        role.getPermissions().forEach(permId -> {
            SysRolePermission rolePermission = new SysRolePermission();
            rolePermission.setRole(oldRole);
            rolePermission.setPermission(permissionDao.getOne(permId));
            rolePermission.setDeleteStatus(1);
            rpList.add(rolePermission);
        });
        oldRole.setRolePermissions(rpList);
        return roleDao.save(oldRole).getId();
    }

    @Override
    public int deleteRole(Integer id) {
        SysRole role = roleDao.getOne(id);
        List<SysUser> users = userDao.queryByRoleId(id);
        if(users!=null && users.size()>0){
            throw new BusinessException("仍有用户使用此角色，无法删除");
        }
//        rolePermissionDao.deleteByRoleId(role.getId());
        roleDao.deleteById(id);
        return 1;
    }

    @Override
    public List<SysOrganization> listOrganization(Map<String, Object> condition) {
        Map<String,Object> params = Maps.newHashMap();
        boolean flag = false;
        StringBuilder sql = new StringBuilder();
        sql.append("select o from SysOrganization o where 1=1  ");
        if(condition.get("orgName")!=null && StringUtils.isNotBlank((String)condition.get("orgName"))){
            sql.append("     and o.orgName like concat('%',:orgName,'%')  ");
            params.put("orgName", (String)condition.get("orgName"));
            flag = true;
        }
        if(condition.get("orgCode")!=null && StringUtils.isNotBlank((String)condition.get("orgCode"))){
            sql.append("     and o.orgCode like concat('%',:orgCode,'%')  ");
            params.put("orgCode", (String)condition.get("orgCode"));
            flag = true;
        }
        if(!flag){
            sql.append("and o.parent = null ");
        }
        return dynamicQuery.query(SysOrganization.class, sql.toString(), params); //organizationDao.queryRootOrgs();
    }

    @Override
    public int addOrganization(SysOrganization organization) {

        return organizationDao.save(organization).getId();
    }

    @Override
    public int updateOrganization(SysOrganization organization) {
        SysOrganization o = organizationDao.findById(organization.getId()).get();
        CommonHelper.copyPropertiesIgnoreNull(organization, o, true);
        return organizationDao.save(o).getId();
    }

    @Override
    public int deleteOrganization(Integer id) {
        organizationDao.deleteById(id);
        return 1;
    }

}
