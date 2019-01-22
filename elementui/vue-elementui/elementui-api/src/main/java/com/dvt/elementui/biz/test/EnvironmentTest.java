package com.dvt.elementui.biz.test;

import com.dvt.elementui.biz.dao.DemoCustomerDao;
import com.dvt.elementui.biz.dao.DemoPivotDao;
import com.dvt.elementui.biz.dao.SysUserDao;
import com.dvt.elementui.biz.model.DemoPivot;
import com.dvt.elementui.biz.model.SysUser;
import com.dvt.elementui.biz.service.TestMyWebService;
import com.dvt.elementui.common.bean.TypedResult;
import com.dvt.elementui.common.properties.WebServiceProperties;
import com.dvt.elementui.common.utils.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnvironmentTest {

//    @Autowired
//    private DemoService demoService;
//
//    @Test
//    public void say() {
//        Map<String,Object> condition = Maps.newHashMap();
//        Page<DemoOrder> result = demoService.queryByPage(condition, 1, 10);
//        List<DemoOrder> list = result.getContent();
//        list.forEach(d -> {
//            DemoCustomer c = d.getCustomer();
//            System.out.println(c.getName());
//            Set<DemoGoods> gs = d.getGoods();
//            for (DemoGoods g:
//                    gs) {
//                System.out.println(g.getGoodsName());
//            }
//        });
//
//
//        return;
//    }

//    @Autowired
//    DemoPivotDao demoPivotDao;
//    @Autowired
//    DemoCustomerDao demoCustomerDao;

    @Autowired
    TestMyWebService testMyWebService;

    @Test
    public void test(){
        TypedResult<SysUser> result = testMyWebService.getUser(10010);
        SysUser me = result.getData();
        System.out.println(me);
    }

//    @Test
//    public void test(){
//        Page<DemoPivot> pages = demoPivotDao.pageByArea("华北", PageRequest.of(0,10));
//        System.out.println(pages.getContent().size());
//    }

//    public void test(){
//        Map<String,List<String>> areas = Maps.newHashMap();
//        areas.put("华北", ImmutableList.of("北京","天津","河北"));
//        areas.put("东北", ImmutableList.of("黑龙江","吉林","辽宁"));
//        List<String> majors = ImmutableList.of("成本","收入");
//
//        for(String area: areas.keySet()){
//            for(String province: areas.get(area)){
//                for(int i=0; i<12; i++){
//                    for(int j=0; j<2; j++){
//                        DemoPivot p = new DemoPivot();
//                        p.setArea(area);
//                        p.setProvince(province);
//                        p.setMonth(i+1 + "月");
//                        p.setMajor(majors.get(j));
//                        if(j==0){
//                            p.setSubject("人工费");
//                        }
//                        p.setValue("110");
//                        demoPivotDao.save(p);
//                    }
//                }
//            }
//        }
//
//    }

}
