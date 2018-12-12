package com.dvt.elementui.biz.controller;

import com.alibaba.fastjson.JSONObject;
import com.dvt.elementui.biz.service.LoginService;
import com.dvt.elementui.biz.vo.AuthVO;
import com.dvt.elementui.common.bean.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    /**
     * 登录
     *
     * @return
     */
    @PostMapping("/auth")
    public Result authLogin(@RequestBody AuthVO authVO) { //@RequestBody JSONObject requestJson
//        String username = requestJson.getString("username");
//        String password = requestJson.getString("password");
        //TODO 校验username, password非空
        return Result.ok(loginService.authLogin(authVO.getUsername(), authVO.getPassword()));
    }

    /**
     * 查询当前登录用户的信息
     *
     * @return
     */
    @PostMapping("/getInfo")
    public Result getInfo() {
        return Result.ok(loginService.getInfo());
    }

    /**
     * 登出
     *
     * @return
     */
    @PostMapping("/logout")
    public Result logout() {
        return Result.ok(loginService.logout());
    }
}
