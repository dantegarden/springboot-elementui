package com.dvt.elementui.biz.controller;

import com.dvt.elementui.biz.service.UserService;
import com.dvt.elementui.common.bean.Result;
import com.dvt.elementui.common.enums.HttpStatusCodeEnum;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        }
        return Result.ok(null);
    }

}
