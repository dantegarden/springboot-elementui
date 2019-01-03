package com.dvt.elementui.common.utils;

import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;

public class HibernateUtils {

    /**通过懒加载代理对象获取真实Class**/
    public static Class getClassWithoutInitializingProxy (Object obj) {
        if (obj instanceof HibernateProxy) {
            HibernateProxy proxy = (HibernateProxy) obj;
            LazyInitializer li = proxy.getHibernateLazyInitializer();
            return li.getPersistentClass();
        }
        // Not a Proxy.
        return obj.getClass();
    }
    /**通过懒加载代理对象真实Object**/
    public static <T>  T deproxy (T obj) {
        if (obj == null)
            return obj;
        if (obj instanceof HibernateProxy) {
            // Unwrap Proxy;
            //      -- loading, if necessary.
            HibernateProxy proxy = (HibernateProxy) obj;
            LazyInitializer li = proxy.getHibernateLazyInitializer();
            return (T)  li.getImplementation();
        }
        return obj;
    }
}
