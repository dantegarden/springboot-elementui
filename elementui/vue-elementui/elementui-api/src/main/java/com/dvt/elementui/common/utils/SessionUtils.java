package com.dvt.elementui.common.utils;

import com.dvt.elementui.biz.model.SysUser;
import com.dvt.elementui.common.enums.SessionEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
/**
 * Shiro上下文工具
 * **/
public class SessionUtils {
    /**
     * 获取当前Session
     *
     * @return 当前Session
     */
    public static Session getCurrentSession() {
        Subject subject = SecurityUtils.getSubject();
        return subject == null ? null : subject.getSession();
    }

    /**
     * 获取当前Session的ID
     *
     * @return 当前Session的ID
     */
    public static String getCurrentSessionId() {
        return getCurrentSession() == null ? null : getCurrentSession().getId().toString();
    }

    /**
     * 获取当前的用户对象
     *
     * @return 当前用户
     */
    public static SysUser getCurrentUser() {
        return getCurrentSession() == null ? null : (SysUser) getCurrentSession().getAttribute(SessionEnum.USER_INFO.getValue());
    }

    /**
     * 获取当前用户的ID
     *
     * @return 当前用户的ID
     */
    public static Integer getCurrentUserId() {
        return getCurrentUser() == null ? null : getCurrentUser().getId();
    }

    /**
     * 存储参数到Session
     *
     * @param key   存储的key
     * @param value 存储的value
     */
    public static void setAttribute(String key, Object value) {
        Session session = getCurrentSession();
        if (session != null) {
            session.setAttribute(key, value);
        }
    }

    /**
     * 存储参数到Session
     *
     * @param sessionEnum 存储的key（枚举）
     * @param value       存储的value
     */
    public static void setAttribute(SessionEnum sessionEnum, Object value) {
        setAttribute(sessionEnum.getValue(), value);
    }

}
