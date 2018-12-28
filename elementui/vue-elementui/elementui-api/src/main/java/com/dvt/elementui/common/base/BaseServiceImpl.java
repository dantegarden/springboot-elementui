package com.dvt.elementui.common.base;

import com.dvt.elementui.common.query.DynamicQuery;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.Registration;

public class BaseServiceImpl implements BaseService {

    @Autowired
    public DynamicQuery dynamicQuery;

}
