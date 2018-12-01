package com.dvt.elementui.biz.controller;

import com.dvt.elementui.biz.model.SysMenu;
import com.dvt.elementui.biz.model.SysUser;
import com.dvt.elementui.biz.service.UserService;
import com.dvt.elementui.common.bean.Result;
import com.dvt.elementui.common.enums.HttpStatusCodeEnum;
import com.dvt.elementui.common.utils.JWTUtils;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(String username, String password) {
        if (!StringUtils.hasText(username)) {
            return Result.fail("用户名不能为空", HttpStatusCodeEnum.PARAM_ERROR.getCode());
        }
        if (!StringUtils.hasText(password)) {
            return Result.fail("密码不能为空", HttpStatusCodeEnum.PARAM_ERROR.getCode());
        }
        if (username.equals("admin") && password.equals("admin")) {
            List<SysMenu> menus = userService.getMenus();
            Map<String, Object> result = new HashMap<>();
            result.put("token", JWTUtils.getToken("1002"));
            result.put("meuns", menus);
            result.put("routers", "/home_/users");
            return Result.ok(result);
        }
        return Result.fail("账号或者密码错误");
    }

    @GetMapping("/list")
    public Result queryUsers(Map<String,Object> queryCondition, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size){
        PageInfo<SysUser> pageInfo = userService.queryByPage(queryCondition, page, size);
        return Result.ok(pageInfo);
    }

}
