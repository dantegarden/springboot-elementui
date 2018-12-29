package com.dvt.elementui.biz.controller;

import com.dvt.elementui.biz.model.SysOrganization;
import com.dvt.elementui.biz.model.SysUser;
import com.dvt.elementui.biz.service.UserService;
import com.dvt.elementui.biz.vo.auth.RoleVO;
import com.dvt.elementui.biz.vo.auth.UserVO;
import com.dvt.elementui.common.bean.PageData;
import com.dvt.elementui.common.bean.Result;
import com.dvt.elementui.common.exception.BusinessException;
import com.dvt.elementui.common.utils.JsonUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 查询用户列表
     *
     * @return
     */
    @RequiresPermissions("user:list")
    @GetMapping("/list")
    public Result queryUsers(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size){
        Map<String,Object> queryCondition = JsonUtils.toMap(Object.class, request.getParameter("queryCondition"));
        Page<UserVO> pageInfo = userService.queryByPage(queryCondition, page, size);
        return Result.ok(new PageData(pageInfo));
    }
     /**
     * 查询全部角色
     *
     * @return
     */
    @RequiresPermissions(value = {"user:add", "user:update"}, logical = Logical.OR)
    @GetMapping("/getAllRoles")
    public Result getAllRoles() {
        return Result.ok(userService.getAllRoles());
    }

    /**
     * 添加用户
     * **/
    @RequiresPermissions("user:add")
    @PostMapping("/addUser")
    public Result addUser(@RequestBody SysUser user) {
        //TODO 字段校验
        int count = userService.addUser(user);
        if(count>0){
            return Result.ok(Boolean.TRUE);
        }else{
            return Result.fail("用户名重复");
        }
    }
    /**
     * 修改用户
     * **/
    @RequiresPermissions("user:update")
    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody SysUser user) {
        //TODO 字段校验
        return Result.ok(userService.updateUser(user));
    }

    /**
     * 删除用户
     * **/
    @RequiresPermissions("user:update")
    @GetMapping("/deleteUser/{id}")
    public Result deleteUser(@PathVariable("id") Integer id) {
        return Result.ok(userService.deleteUser(id));
    }

    /**
     * 角色列表
     *
     * @return
     */
    @RequiresPermissions("role:list")
    @GetMapping("/listRole")
    public Result listRole(HttpServletRequest request) {
        Map<String,Object> queryCondition = JsonUtils.toMap(Object.class, request.getParameter("queryCondition"));
        return Result.ok(userService.listRole(queryCondition));
    }

    /**
     * 查询所有权限, 给角色分配权限时调用
     *
     * @return
     */
    @RequiresPermissions("role:list")
    @GetMapping("/getAllPermission")
    public Result getAllPermission() {
        return Result.ok(userService.getAllPermission());
    }

    /**
     * 新增角色
     *
     * @return
     */
    @RequiresPermissions("role:add")
    @PostMapping("/addRole")
    public Result addRole(@RequestBody RoleVO role) {
        int count = userService.addRole(role);
        if(count>0){
            return Result.ok(Boolean.TRUE);
        }else{
            return Result.fail("角色名重复");
        }
    }

    /**
     * 修改角色
     *
     * @return
     */
    @RequiresPermissions("role:update")
    @PostMapping("/updateRole")
    public Result updateRole(@RequestBody RoleVO role) {
        return Result.ok(userService.updateRole(role));
    }

    /**
     * 删除角色
     *
     * @return
     */
    @RequiresPermissions("role:delete")
    @PostMapping("/deleteRole/{id}")
    public Result deleteRole(@PathVariable Integer id) {
        try{
            int exist = userService.deleteRole(id);
            return Result.ok(exist);
        }catch (BusinessException e){
            return Result.fail(e.getErrorMessage());
        }

    }

    /**
     * 机构列表
     *
     * @return
     */
    @RequiresPermissions("organization:list")
    @GetMapping("/listOrganization")
    public Result listOrganization(HttpServletRequest request) {
        Map<String,Object> queryCondition = JsonUtils.toMap(Object.class, request.getParameter("queryCondition"));
        return Result.ok(userService.listOrganization(queryCondition));
    }

    /**
     * 新增机构
     *
     * @return
     */
    @RequiresPermissions("organization:add")
    @PostMapping("/addOrganization")
    public Result addOrganization(@RequestBody SysOrganization organization) {
        int count = userService.addOrganization(organization);
        if(count>0){
            return Result.ok(Boolean.TRUE);
        }else{
            return Result.fail("未知错误");
        }
    }

    /**
     * 修改机构
     *
     * @return
     */
    @RequiresPermissions("organization:update")
    @PostMapping("/updateOrganization")
    public Result updateOrganization(@RequestBody SysOrganization organization) {
        return Result.ok(userService.updateOrganization(organization));
    }

    /**
     * 删除角色
     *
     * @return
     */
    @RequiresPermissions("organization:delete")
    @PostMapping("/deleteOrganization/{id}")
    public Result deleteOrganization(@PathVariable Integer id) {
        try{
            int exist = userService.deleteOrganization(id);
            return Result.ok(exist);
        }catch (BusinessException e){
            return Result.fail(e.getErrorMessage());
        }
    }

}
