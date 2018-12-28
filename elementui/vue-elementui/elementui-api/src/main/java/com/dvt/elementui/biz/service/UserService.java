package com.dvt.elementui.biz.service;

import com.dvt.elementui.biz.model.SysRole;
import com.dvt.elementui.biz.model.SysUser;
import com.dvt.elementui.biz.vo.auth.PermissionVO;
import com.dvt.elementui.biz.vo.auth.RolePermissionVO;
import com.dvt.elementui.biz.vo.auth.RoleVO;
import com.dvt.elementui.biz.vo.auth.UserVO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 用户列表
     *
     * @return
     */
    Page<UserVO> queryByPage(Map<String,Object> condition, Integer page, Integer size);
    /**
     * 获取全部角色
     *
     * @return
     * **/
    List<SysRole> getAllRoles();

    /**
     * 添加用户
     *
     * @return
     */
    int addUser(SysUser user);

    /**
     * 修改用户
     *
     * @return
     */
    int updateUser(SysUser user);
    /**
     * 删除用户
     *
     * @return
     */
    int deleteUser(Integer id);
    /**
     * 角色列表
     *
     * @return
     */
    List<RolePermissionVO> listRole(Map<String,Object> condition);

    /**
     * 查询所有权限, 给角色分配权限时调用
     *
     * @return
     */
    List<PermissionVO> getAllPermission();
    /**
     * 创建角色
     *
     * @return
     */
    int addRole(RoleVO role);
    /**
     * 修改角色
     *
     * @return
     */
    int updateRole(RoleVO role);
    /**
     * 删除角色
     *
     * @return
     */
    int deleteRole(Integer id);
}
