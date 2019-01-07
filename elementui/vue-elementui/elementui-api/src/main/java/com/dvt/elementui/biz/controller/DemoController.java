package com.dvt.elementui.biz.controller;

import com.dvt.elementui.biz.model.*;
import com.dvt.elementui.biz.service.DemoService;
import com.dvt.elementui.biz.vo.demo.DemoQueryVO;
import com.dvt.elementui.biz.vo.demo.FieldVO;
import com.dvt.elementui.biz.vo.demo.DemoOrderItemVO;
import com.dvt.elementui.biz.vo.demo.QueryForm;
import com.dvt.elementui.common.bean.PageData;
import com.dvt.elementui.common.bean.Result;
import com.dvt.elementui.common.utils.CommonHelper;
import com.dvt.elementui.common.utils.JsonUtils;
import com.dvt.elementui.common.utils.SessionUtils;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        Page<DemoOrder> page =demoService.queryByPage(queryCondition, vo.getPage(), vo.getSize());
        CommonHelper.clearFields(page.getContent());
        return Result.ok(new PageData(page));
    }

    @RequiresPermissions("demo:add")
    @PostMapping("/addOrder")
    public Result createOrder(){
        DemoOrder newOrder = new DemoOrder();
        newOrder.setIsEnabled(0);
        return Result.ok(demoService.saveOrder(newOrder));
    }

    @GetMapping("/listOrderItems/{id}")
    public Result listOrderItems(@PathVariable Integer id){
        List<DemoOrderItem> orderItems = demoService.queryOrderItems(id);
        return Result.ok(orderItems);
    }

    @RequiresPermissions(value = {"demo:add", "demo:update"}, logical = Logical.OR)
    @PostMapping("/saveOrderItem")
    public Result saveOrderItem(@RequestBody DemoOrderItem oi){
        Integer id = demoService.saveOrderItem(oi);
        return Result.ok(id);
    }

    @GetMapping("/customer/name")
    public Result getCustomerByName(@RequestParam String name){
        List<DemoCustomer> customers = Lists.newArrayList();
        if(StringUtils.isNotBlank(name)){
            customers = demoService.findCustomersByName(name);
            CommonHelper.clearFields(customers);
        }
        return Result.ok(customers);
    }

    @GetMapping("/goods/name")
    public Result getGoodsByName(@RequestParam String name){
        List<DemoGoods> goods = Lists.newArrayList();
        if(StringUtils.isNotBlank(name)){
            goods = demoService.findGoodsByName(name);
            CommonHelper.clearFields(goods);
        }
        return Result.ok(goods);
    }

    @GetMapping(value = "/pivot/config")
    public Result getTableConfig() {
        //表头
        List<FieldVO> keys = Lists.newArrayList();
        keys.add(new FieldVO("month","月份"));
        keys.add(new FieldVO("major","大类"));
        keys.add(new FieldVO("subject","小类"));
        //表旁
        keys.add(new FieldVO("area","区域"));
        keys.add(new FieldVO("province","省份"));

        List<DemoPivotCollection> collectionItems = demoService.findCollectionsByUserId(SessionUtils.getCurrentUserId());
        collectionItems.forEach(dp->{dp.setQueryCondition(JsonUtils.toBean(QueryForm.class, dp.getCollectionJson()));});

        Map<String, List> config = ImmutableMap.of("rows", keys, "cols", keys, "collectionFieldFilter", collectionItems);
        return Result.ok(config);
    }

    @PostMapping("/pivot/list")
    public Result getPivotData(@RequestBody QueryForm queryForm){
        List<DemoPivot> result = demoService.findPivotDatas(queryForm);
        return Result.ok(result);
    }

    @PostMapping("/pivot/collect/add")
    public Result addCollection(@RequestBody DemoPivotCollection collectionItem){
        SysUser currentUser = SessionUtils.getCurrentUser();
        collectionItem.setUser(currentUser);
        this.demoService.saveDemoPivotCollection(collectionItem);
        List<DemoPivotCollection> collectionItems = demoService.findCollectionsByUserId(SessionUtils.getCurrentUserId());
        collectionItems.forEach(dp->{dp.setQueryCondition(JsonUtils.toBean(QueryForm.class, dp.getCollectionJson()));});
        return Result.ok(collectionItems);
    }

    @GetMapping("/pivot/collect/del/{index}")
    public Result delCollection(@PathVariable Integer index){
        this.demoService.deleteDemoPivotCollection(index);
        List<DemoPivotCollection> collectionItems = demoService.findCollectionsByUserId(SessionUtils.getCurrentUserId());
        collectionItems.forEach(dp->{dp.setQueryCondition(JsonUtils.toBean(QueryForm.class, dp.getCollectionJson()));});
        return Result.ok(collectionItems);
    }
}
