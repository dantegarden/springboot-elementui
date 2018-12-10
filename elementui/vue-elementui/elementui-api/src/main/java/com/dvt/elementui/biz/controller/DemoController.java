package com.dvt.elementui.biz.controller;

import com.dvt.elementui.biz.model.DemoOrder;
import com.dvt.elementui.biz.service.DemoService;
import com.dvt.elementui.common.bean.Result;
import com.dvt.elementui.common.utils.JsonUtils;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private static final Logger LOGGER = Logger.getLogger(DemoController.class);

    @Autowired
    private DemoService demoService;

    @RequiresPermissions("demo:list")
    @GetMapping("/listOrders")
    public Result listOrders(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        Map<String,Object> queryCondition = JsonUtils.toMap(Object.class, request.getParameter("queryCondition"));
        PageInfo<DemoOrder> pageInfo =demoService.queryByPage(queryCondition, page, size);
        return Result.ok(pageInfo);
    }
}
