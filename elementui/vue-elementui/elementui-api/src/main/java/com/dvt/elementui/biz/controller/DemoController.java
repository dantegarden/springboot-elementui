package com.dvt.elementui.biz.controller;

import com.dvt.elementui.biz.model.DemoOrder;
import com.dvt.elementui.biz.service.DemoService;
import com.dvt.elementui.biz.vo.demo.DemoQueryVO;
import com.dvt.elementui.common.bean.Result;
import com.dvt.elementui.common.utils.CommonHelper;
import com.dvt.elementui.common.utils.JsonUtils;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanMap;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private static final Logger LOGGER = Logger.getLogger(DemoController.class);

    @Autowired
    private DemoService demoService;

    @RequiresPermissions("demo:list")
    @PostMapping("/listOrders")
    public Result listOrders(@RequestBody DemoQueryVO vo) {
        Map<String,Object> queryCondition = CommonHelper.javaBean2Map(vo.getQueryCondition());
        PageInfo<DemoOrder> pageInfo =demoService.queryByPage(queryCondition, vo.getPage(), vo.getSize());
        return Result.ok(pageInfo);
    }
}
