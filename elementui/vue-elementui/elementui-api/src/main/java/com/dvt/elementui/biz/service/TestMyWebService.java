package com.dvt.elementui.biz.service;

import com.dvt.elementui.biz.model.SysUser;
import com.dvt.elementui.common.bean.TypedResult;

public interface TestMyWebService {

    TypedResult<SysUser> getUser(Integer userId);
}
