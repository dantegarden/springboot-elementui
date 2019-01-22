package com.dvt.elementui.biz.webservice;

import com.dvt.elementui.biz.model.SysUser;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public interface MyWebService {

    @WebMethod
    String getUserNameById(@WebParam(name = "userId") Integer userId);

    @WebMethod
    String getUser(@WebParam(name = "userId") Integer userId);

    @WebMethod
    String getAlLUser();
}
