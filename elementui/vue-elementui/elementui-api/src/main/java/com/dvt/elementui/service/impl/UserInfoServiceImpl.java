package com.dvt.elementui.service.impl;

import com.dvt.elementui.common.service.impl.BaseServiceImpl;
import com.dvt.elementui.domain.UserInfo;
import com.dvt.elementui.repository.mapper.UserInfoMapper;
import com.dvt.elementui.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userInfoService")
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo> implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
}
