package com.dvt.elementui.biz.test;

import com.dvt.elementui.biz.model.SysUser;
import com.dvt.elementui.common.utils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MethodTest {
    @Test
    public void say() {
        String json = "{\"username\":\"123123\", \"password\":\"123123\"}";
        Map<String,Object> map = JsonUtils.toMap(Object.class, json);
        System.out.println(map);
    }
}
