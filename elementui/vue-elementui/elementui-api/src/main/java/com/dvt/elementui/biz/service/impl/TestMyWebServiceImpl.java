package com.dvt.elementui.biz.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.dvt.elementui.biz.model.SysUser;
import com.dvt.elementui.biz.service.TestMyWebService;
import com.dvt.elementui.common.base.BaseServiceImpl;
import com.dvt.elementui.common.bean.TypedResult;
import com.dvt.elementui.common.webservice.WebServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestMyWebServiceImpl extends BaseServiceImpl implements TestMyWebService {

    @Autowired
    private WebServices webServices;

    private static final String SERVICE_NAME = "myWebService";


    @Override
    public TypedResult<SysUser> getUser(Integer userId) {
        return webServices.doInvokeWebService(SERVICE_NAME, "getUser", new TypeReference<SysUser>(){}, userId);
    }
}
