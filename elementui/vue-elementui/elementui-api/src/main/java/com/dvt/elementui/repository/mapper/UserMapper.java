package com.dvt.elementui.repository.mapper;

import com.dvt.elementui.domain.User;
import com.dvt.elementui.repository.param.PageParam;
import com.dvt.elementui.repository.param.UserParam;

import java.util.List;

public interface UserMapper {
    int deleteById(Integer id);

    int insert(User record);

    User selectById(Integer id);

    List<User> selectAll();

    int updateById(User record);

    List<User> getUserListByPage(UserParam userParam);
}
