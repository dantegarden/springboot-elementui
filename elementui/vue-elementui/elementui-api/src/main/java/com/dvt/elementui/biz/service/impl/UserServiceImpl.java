package com.dvt.elementui.biz.service.impl;

import com.dvt.elementui.biz.dao.SysUserMapper;
import com.dvt.elementui.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper userMapper;
}
