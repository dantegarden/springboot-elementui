package com.dvt.elementui.biz.controller;

import com.dvt.elementui.common.bean.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;

@RestController
@RequestMapping("/home")
public class HomeController {

    private static final Logger LOGGER = Logger.getLogger(HomeController.class);

    @GetMapping("/loadData")
    public Result loadData() {
        return Result.ok("hello");
    }
}
