package com.dvt.elementui.biz.webservice.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.dvt.elementui.biz.dao.SysUserDao;
import com.dvt.elementui.biz.model.SysUser;
import com.dvt.elementui.biz.webservice.MyWebService;
import com.dvt.elementui.common.base.BaseServiceImpl;
import com.dvt.elementui.common.utils.CommonHelper;
import com.dvt.elementui.common.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
/**
 * WebService示例
 * 接口实现类名称前的注解targetNamespace是当前类实现接口所在包名称的反序（PS：加上反斜线）
 * endpointInterface是当前需要实现接口的全称
 * 此外还需要一个注册配置：com.dvt.elementui.common.configuration.MyWebServiceImpl.java
 * **/
@Component
@WebService(targetNamespace="http://webservice.biz.elementui.dvt.com/",endpointInterface = "com.dvt.elementui.biz.webservice.MyWebService")
public class MyWebServiceImpl extends BaseServiceImpl implements MyWebService {

    @Autowired
    private SysUserDao userDao;

    @Override
    public String getUserNameById(Integer userId) {
        return userDao.getOne(userId).getUsername();
    }

    @Override
    public String getUser(Integer userId) {
        SysUser user =  userDao.getOne(userId);
        return JsonUtils.toJson(user);
    }

    @Override
    public String getAlLUser() {
        List<SysUser> users =  userDao.findAll();
        return JsonUtils.toJson(users);
    }
}
