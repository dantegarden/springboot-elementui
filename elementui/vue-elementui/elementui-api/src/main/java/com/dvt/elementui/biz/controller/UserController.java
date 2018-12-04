package com.dvt.elementui.biz.controller;

import com.alibaba.fastjson.JSONObject;
import com.dvt.elementui.biz.model.SysMenu;
import com.dvt.elementui.biz.model.SysUser;
import com.dvt.elementui.biz.service.UserService;
import com.dvt.elementui.common.bean.Result;
import com.dvt.elementui.common.bean.UserPermission;
import com.dvt.elementui.common.enums.HttpStatusCodeEnum;
import com.dvt.elementui.common.utils.JWTUtils;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
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
    public Result queryUsers(Map<String,Object> queryCondition, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size){
        PageInfo<UserPermission> pageInfo = userService.queryByPage(queryCondition, page, size);
        return Result.ok(pageInfo);
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

}
