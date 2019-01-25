package com.dvt.elementui.biz.controller;

import com.dvt.elementui.biz.model.*;
import com.dvt.elementui.biz.service.DemoService;
import com.dvt.elementui.biz.vo.demo.DemoQueryVO;
import com.dvt.elementui.biz.vo.demo.FieldVO;
import com.dvt.elementui.biz.vo.demo.DemoOrderItemVO;
import com.dvt.elementui.biz.vo.demo.QueryForm;
import com.dvt.elementui.common.bean.ExcelData;
import com.dvt.elementui.common.bean.PageData;
import com.dvt.elementui.common.bean.Result;
import com.dvt.elementui.common.datadict.DataDict;
import com.dvt.elementui.common.utils.*;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private static final Logger LOGGER = Logger.getLogger(DemoController.class);

    @Autowired
    private DemoService demoService;

    @Autowired
    private DataDict dataDict;

    @RequiresPermissions("demo:list")
    @PostMapping("/listOrders")
    public Result listOrders(@RequestBody DemoQueryVO vo) {
        Map<String,Object> queryCondition = CommonHelper.javaBean2Map(vo.getQueryCondition());
        Page<DemoOrder> page =demoService.queryByPage(queryCondition, vo.getPage(), vo.getSize());
        CommonHelper.clearFields(page.getContent());
        return Result.ok(new PageData(page));
    }

    @RequiresPermissions("demo:list")
    @PostMapping("/exportOrders")
    public void exportOrders(@RequestBody DemoQueryVO vo, HttpServletResponse response) throws Exception {
        Map<String,Object> queryCondition = CommonHelper.javaBean2Map(vo.getQueryCondition());
        List<DemoOrder> list = demoService.query(queryCondition);
        ExcelData data = new ExcelData();
        data.setName("订单表"); //sheetName
        data.setTitles(ImmutableList.of("订单号", "客户", "收货地址", "订单总价", "订单状态", "下单时间")); //表头
        List<List<Object>> rows = Lists.newArrayList();
        for(DemoOrder o: list){
            rows.add(ImmutableList.of(
                    o.getOrderSn(),
                    o.getCustomer().getName(),
                    o.getCustomer().getAddress(),
                    o.getOrderPrice(),
                    dataDict.getCodeName("OrderStatus", o.getOrderStatus()+""),
                    DateUtils.format(o.getOrderTime())
            ));
        }
        data.setRows(rows);
        //生成本地
        /*File f = new File("c:/test.xlsx");
        FileOutputStream out = new FileOutputStream(f);
        ExportExcelUtils.exportExcel(data, out);
        out.close();*/
        ExportExcelUtils.exportExcel(response,"订单表.xlsx", data);
    }

    @GetMapping("/getOrder/{id}")
    public Result getOrder(@PathVariable Integer id){
        return Result.ok(this.demoService.findOrderById(id));
    }

    @RequiresPermissions("demo:add")
    @PostMapping("/addOrder")
    public Result createOrder(){
        return Result.ok(demoService.addOrder());
    }

    @RequiresPermissions(value = {"demo:add", "demo:update"}, logical = Logical.OR)
    @PostMapping("/saveOrder")
    public Result saveOrder(@RequestBody DemoOrder o){
        Integer id = demoService.saveOrder(o);
        return Result.ok(id);
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

    @RequiresPermissions(value = {"demo:add", "demo:update"}, logical = Logical.OR)
    @GetMapping("/removeOrderItem/{id}")
    public Result removeOrderItem(@PathVariable Integer id){
        demoService.deleteOrderItem(id);
        return Result.ok(id);
    }

    @RequiresPermissions("demo:delete")
    @PostMapping("/removeOrders")
    public Result removeOrder(@RequestBody List<Integer> ids){
        for (int i=0;i<ids.size();i++){
            demoService.deleteOrder(ids.get(i));
        }
        return Result.ok(Boolean.TRUE);
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

    @RequiresPermissions("demo:add")
    @RequestMapping("/upload")
    public Result importOrders(@RequestParam("uploadFile") MultipartFile[] uploadFile) throws IOException {

        String baseUploadFilePath = Thread.currentThread().getContextClassLoader().getResource("").toString().replaceAll("file:/", "");

        if(uploadFile != null && uploadFile.length>0){
            for(MultipartFile item : uploadFile){
                LOGGER.info("接收上传文件：" + item.getOriginalFilename());
                String fileName = new Date().getTime()+".xlsx";
                String filePath = baseUploadFilePath + "upload/" + DateUtils.todayDateStr();//自定义上传路径
                File file = new File(filePath,fileName);

                if(!file.exists()){
                    FileUtils.forceMkdir(file.getParentFile());
                    file.createNewFile();
                }
                item.transferTo(file);//上传文件
            }
        }

        return Result.ok(null);
    }

    /*****************交叉表示例********************/

    @GetMapping(value = "/pivot/config")
    public Result getTableConfig() {
        //表头
        List<FieldVO> keys = Lists.newArrayList();
        keys.add(new FieldVO("month","月份"));
        keys.add(new FieldVO("major","大类", "DemoMajor"));
        keys.add(new FieldVO("subject","小类"));
        //表旁
        keys.add(new FieldVO("area","区域"));
        keys.add(new FieldVO("province","省份"));
        keys.add(new FieldVO("rate","汇率", FieldVO.FieldTypeEnum.NUMBER));
        keys.add(new FieldVO("update_time","更新时间", FieldVO.FieldTypeEnum.DATE));

        List<DemoPivotCollection> collectionItems = demoService.findCollectionsByUserId(SessionUtils.getCurrentUserId());
        collectionItems.forEach(dp->{dp.setQueryCondition(JsonUtils.toBean(QueryForm.class, dp.getCollectionJson()));});

        Map<String, List> config = ImmutableMap.of("fields", keys,  "collectionFieldFilter", collectionItems);
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
