package com.dvt.elementui.biz.dao;

import com.dvt.elementui.biz.model.SysUser;
import com.dvt.elementui.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**条件查询**/
    public List<SysUser> queryByCondition(Map<String,Object> condition);
}