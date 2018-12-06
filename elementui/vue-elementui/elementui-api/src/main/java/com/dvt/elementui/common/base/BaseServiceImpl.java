package com.dvt.elementui.common.base;

import org.apache.commons.lang.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class BaseServiceImpl implements BaseSerivce {

    @Override
    public Example getExample(Class entityClass, List<String> conditions) {
        Example example = new Example(entityClass);
        Example.Criteria criteria = example.createCriteria();
        for(String condition: conditions){
            if(StringUtils.isNotBlank(condition)){
                criteria.andCondition(condition);
            }
        }
        return example;
    }
}
