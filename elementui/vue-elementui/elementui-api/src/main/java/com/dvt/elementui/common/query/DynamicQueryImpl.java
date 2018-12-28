package com.dvt.elementui.common.query;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.alibaba.fastjson.JSONObject;
import com.dvt.elementui.common.base.BaseEntity;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.Typed;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.hql.internal.ast.QueryTranslatorImpl;
import org.hibernate.hql.spi.QueryTranslator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

@Repository
public class DynamicQueryImpl implements DynamicQuery{

    @PersistenceContext
    private EntityManager em;

    /**
     * 从EntityManager获取Hibernate的Session
     * 下面所有方式的实现都基于Hibernate
     */
    private Session getHibernateSession() {
        return em.unwrap(Session.class);
    }

    /**
     * 获取Hibernate的SessionFactory对象
     * @return
     */
    private SessionFactory getHibernateSessionFactory() {
        return getHibernateSession().getSessionFactory();
    }

    // -====================================== jpql查询 ======================================-

    @Override
    public List<?> query(String jpql, Object... params) {
        return createQuery(jpql, params).getResultList();
    }

    @Override
    public <T> T querySingleResult(Class<T> resultClass, String jpql, Object...params) {
        return createTypedQuery(resultClass, jpql, params).getSingleResult();
    }

    @Override
    public <T> List<T> query(Class<T> resultClass, String jpql, Object... params) {
        return createTypedQuery(resultClass, jpql, params).getResultList();
    }

    @Override
    public List<?> queryPagingList(Pageable pageable, String jpql, Object... params) {
        Integer pageNumber = pageable.getPageNumber();
        Integer pageSize = pageable.getPageSize();
        Integer startPosition = pageNumber * pageSize;
        return createQuery(jpql, params).setFirstResult(startPosition).setMaxResults(pageSize).getResultList();
    }

    @Override
    public <T> List<T> queryPagingList(Class<T> resultClass, Pageable pageable, String jpql, Object... params) {
        Integer pageNumber = pageable.getPageNumber();
        Integer pageSize = pageable.getPageSize();
        Integer startPosition = pageNumber * pageSize;
        return createTypedQuery(resultClass, jpql, params).setFirstResult(startPosition).setMaxResults(pageSize).getResultList();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Page query(Pageable pageable, String jpql, Object... params) {
        List<?> rows = queryPagingList(pageable, jpql, params);
        Long total = queryCount(jpql, params);
        return new PageImpl(rows, pageable, total);
    }

    @Override
    public <T> Page<T> query(Class<T> resultClass, Pageable pageable, String jpql, Object... params) {
        List<T> rows = queryPagingList(resultClass, pageable, jpql, params);
        Long total = queryCount(jpql, params);
        return new PageImpl<T>(rows, pageable, total);
    }

    /***/
    @Override
    public List<?> query(String jpql, Map<String, Object> params) {
        return createQuery(jpql, params).getResultList();
    }

    @Override
    public <T> T querySingleResult(Class<T> resultClass, String jpql, Map<String, Object> params) {
        return createTypedQuery(resultClass, jpql, params).getSingleResult();
    }

    @Override
    public <T> List<T> query(Class<T> resultClass, String jpql, Map<String, Object> params) {
        return createTypedQuery(resultClass, jpql, params).getResultList();
    }

    @Override
    public List<?> queryPagingList(Pageable pageable, String jpql, Map<String, Object> params) {
        Integer pageNumber = pageable.getPageNumber();
        Integer pageSize = pageable.getPageSize();
        Integer startPosition = pageNumber * pageSize;
        return createQuery(jpql, params).setFirstResult(startPosition).setMaxResults(pageSize).getResultList();
    }

    @Override
    public <T> List<T> queryPagingList(Class<T> resultClass, Pageable pageable, String jpql, Map<String, Object> params) {
        Integer pageNumber = pageable.getPageNumber();
        Integer pageSize = pageable.getPageSize();
        Integer startPosition = pageNumber * pageSize;
        return createTypedQuery(resultClass, jpql, params).setFirstResult(startPosition).setMaxResults(pageSize).getResultList();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Page query(Pageable pageable, String jpql, Map<String, Object> params) {
        List<?> rows = queryPagingList(pageable, jpql, params);
        Long total = queryCount(jpql, params);
        return new PageImpl(rows, pageable, total);
    }

    @Override
    public <T> Page<T> query(Class<T> resultClass, Pageable pageable, String jpql, Map<String, Object> params) {
        List<T> rows = queryPagingList(resultClass, pageable, jpql, params);
        Long total = queryCount(jpql, params);
        return new PageImpl<T>(rows, pageable, total);
    }

    @Override
    public Long queryCount(String jpql, Object... params) {
        jpql = StringUtils.substringBefore(jpql, "order by"); // 去掉order by, 提升执行效率

        // 去重和分组只能使用NativeSQL统计查询
        if (jpql.contains("distinct") || jpql.contains("group by")) {
            String countSql = generateCountSql(jpql);
            Object count = createNativeQuery(countSql, params).getSingleResult();
            return ((Number) count).longValue();
        } else { // 使用jpql统计查询
            String countJpql = generateCountJpql(jpql);
            return (Long) createQuery(countJpql, params).getSingleResult();
        }
    }

    @Override
    public Long queryCount(String jpql, Map<String, Object> params) {
        jpql = StringUtils.substringBefore(jpql, "order by"); // 去掉order by, 提升执行效率

        // 去重和分组只能使用NativeSQL统计查询
        if (jpql.contains("distinct") || jpql.contains("group by")) {
            String countSql = generateCountSql(jpql);
            Object count = createNativeQuery(countSql, params).getSingleResult();
            return ((Number) count).longValue();
        } else { // 使用jpql统计查询
            String countJpql = generateCountJpql(jpql);
            return (Long) createQuery(countJpql, params).getSingleResult();
        }
    }

    @Override
    public int executeUpdate(String jpql, Object... params) {
        return createQuery(jpql, params).executeUpdate();
    }



    // -====================================== 本地查询 ======================================-

    @SuppressWarnings("unchecked")
    @Override
    public List<Object[]> nativeQuery(String nativeSql, Object... params) {
        return createNativeQuery(nativeSql, params).getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> nativeQuery(Class<T> resultClass, String nativeSql, Object... params) {
        List cacheList =  getNativeQuery(resultClass, nativeSql, params).getResultList();
        return transformModelObject(resultClass, cacheList);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T nativeQuerySingleResult(Class<T> resultClass, String nativeSql, Object... params) {
        Object cacheObject =  getNativeQuery(resultClass, nativeSql, params).getSingleResult();
        return transformModelObject(resultClass, cacheObject);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Object[]> nativeQueryPagingList(Pageable pageable, String nativeSql, Object... params) {
        Integer pageNumber = pageable.getPageNumber();
        Integer pageSize = pageable.getPageSize();
        Integer startPosition = pageNumber * pageSize;
        return createNativeQuery(nativeSql, params).setFirstResult(startPosition).setMaxResults(pageSize).getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> nativeQueryPagingList(Class<T> resultClass, Pageable pageable, String nativeSql, Object... params) {
        Integer pageNumber = pageable.getPageNumber();
        Integer pageSize = pageable.getPageSize();
        Integer startPosition = pageNumber * pageSize;
        List cacheList = getNativeQuery(resultClass, nativeSql, params).setFirstResult(startPosition).setMaxResults(pageSize).getResultList();
        return transformModelObject(resultClass, cacheList);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Page nativeQuery(Pageable pageable, String nativeSql, Object... params) {
        List<Object[]> rows = nativeQueryPagingList(pageable, nativeSql, params);
        Long total = nativeQueryCount(nativeSql, params);
        return new PageImpl(rows, pageable, total);
    }

    @Override
    public <T> Page<T> nativeQuery(Class<T> resultClass, Pageable pageable, String nativeSql, Object... params) {
        List<T> rows = nativeQueryPagingList(resultClass, pageable, nativeSql, params);
        Long total = nativeQueryCount(nativeSql, params);
        return new PageImpl<T>(rows, pageable, total);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Object[]> nativeQuery(String nativeSql, Map<String, Object> params) {
        return createNativeQuery(nativeSql, params).getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> nativeQuery(Class<T> resultClass, String nativeSql, Map<String, Object> params) {
        List cacheList =  getNativeQuery(resultClass, nativeSql, params).getResultList();
        return transformModelObject(resultClass, cacheList);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T nativeQuerySingleResult(Class<T> resultClass, String nativeSql, Map<String, Object> params) {
        Object cacheObject =  getNativeQuery(resultClass, nativeSql, params).getSingleResult();
        return transformModelObject(resultClass, cacheObject);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Object[]> nativeQueryPagingList(Pageable pageable, String nativeSql, Map<String, Object> params) {
        Integer pageNumber = pageable.getPageNumber();
        Integer pageSize = pageable.getPageSize();
        Integer startPosition = pageNumber * pageSize;
        return createNativeQuery(nativeSql, params).setFirstResult(startPosition).setMaxResults(pageSize).getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> nativeQueryPagingList(Class<T> resultClass, Pageable pageable, String nativeSql, Map<String, Object> params) {
        Integer pageNumber = pageable.getPageNumber();
        Integer pageSize = pageable.getPageSize();
        Integer startPosition = pageNumber * pageSize;
        List cacheList = getNativeQuery(resultClass, nativeSql, params).setFirstResult(startPosition).setMaxResults(pageSize).getResultList();
        return transformModelObject(resultClass, cacheList);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Page nativeQuery(Pageable pageable, String nativeSql, Map<String, Object> params) {
        List<Object[]> rows = nativeQueryPagingList(pageable, nativeSql, params);
        Long total = nativeQueryCount(nativeSql, params);
        return new PageImpl(rows, pageable, total);
    }

    @Override
    public <T> Page<T> nativeQuery(Class<T> resultClass, Pageable pageable, String nativeSql, Map<String, Object> params) {
        List<T> rows = nativeQueryPagingList(resultClass, pageable, nativeSql, params);
        Long total = nativeQueryCount(nativeSql, params);
        return new PageImpl<T>(rows, pageable, total);
    }

    @Override
    public Long nativeQueryCount(String nativeSql, Object... params) {
        nativeSql = StringUtils.substringBefore(nativeSql, "order by"); // 去掉order by, 提升执行效率
        String countSql = "select count(*) from (" + nativeSql + ")";
        Object count = createNativeQuery(countSql, params).getSingleResult();
        return ((Number) count).longValue();
    }

    @Override
    public Long nativeQueryCount(String nativeSql, Map<String, Object> params) {
        nativeSql = StringUtils.substringBefore(nativeSql, "order by"); // 去掉order by, 提升执行效率
        String countSql = "select count(*) from (" + nativeSql + ")";
        Object count = createNativeQuery(countSql, params).getSingleResult();
        return ((Number) count).longValue();
    }

    @Override
    public int nativeExecuteUpdate(String nativeSql, Object... params) {
        return createNativeQuery(nativeSql, params).executeUpdate();
    }

    // -=================================== 其它 ===========================================-

    private Query createQuery(String jpql, Object... params) {
        jpql = cleanSql(jpql);
        Query q = em.createQuery(jpql);
        if(params!=null && params.length>0)
        setParameter(q, params);
        return q;
    }

    private Query createQuery(String jpql, Map<String,Object> params) {
        jpql = cleanSql(jpql);
        Query q = em.createQuery(jpql);
        if(params!=null && params.size()>0)
        setParameter(q, params);
        return q;
    }

    private <T> TypedQuery<T> createTypedQuery(Class<T> resultClass, String jpql, Object... params) {
        jpql = cleanSql(jpql);
        TypedQuery<T> q = em.createQuery(jpql, resultClass);
        if(params!=null && params.length>0)
        setParameter(q, params);
        return q;
    }

    private <T> TypedQuery<T> createTypedQuery(Class<T> resultClass, String jpql, Map<String,Object> params) {
        jpql = cleanSql(jpql);
        TypedQuery<T> q = em.createQuery(jpql, resultClass);
        if(params!=null && params.size()>0)
        setParameter(q, params);
        return q;
    }

    private <T> Query getNativeQuery(Class<T> resultClass, String sql, Object... params) {
        sql = cleanSql(sql);
        Query q = isEntity(resultClass) ?
                createNativeQuery(resultClass, sql, params) : createNativeQuery(sql, params);
        return q;
    }

    private <T> Query getNativeQuery(Class<T> resultClass, String sql, Map<String,Object> params) {
        sql = cleanSql(sql);
        Query q = isEntity(resultClass)?createNativeQuery(sql, params, resultClass): createNativeQuery(sql, params);
        return q;
    }

    private <T> Boolean isEntity(Class<T> resultClass) {
        return BaseEntity.class.isAssignableFrom(resultClass);
    }

    private Query createNativeQuery(String sql, Object... params) {
        sql = cleanSql(sql);
        Query q = em.createNativeQuery(sql);
        setParameter(q, params);
        return q;
    }

    private <T> Query createNativeQuery(Class<T> resultClass, String sql, Object... params) {
        sql = cleanSql(sql);
        Query q = em.createNativeQuery(sql, resultClass);
        if(params!=null && params.length>0)
        setParameter(q, params);
        return q;
    }

    private Query createNativeQuery(String sql, Map<String,Object> params) {
        sql = cleanSql(sql);
        Query q = em.createNativeQuery(sql);
        if(params!=null && params.size()>0)
        setParameter(q, params);
        return q;
    }

    private <T> Query createNativeQuery(Class<T> resultClass, String sql, Map<String,Object> params) {
        sql = cleanSql(sql);
        Query q = em.createNativeQuery(sql, resultClass);
        if(params!=null && params.size()>0)
        setParameter(q, params);
        return q;
    }

    /**
     * 执行统计查询
     * @param jpql
     * @return
     */
    private String generateCountJpql(String jpql) {
        return "select count(*) from " + StringUtils.substringAfter(jpql, "from");
    }

    /**
     * 通过jpql生成统计sql
     * @param jpql
     * @return
     */
    private String generateCountSql(String jpql) {
        return "select count(*) c from (" + jpqlToSql(jpql) + ") _count";
    }

    /**
     * 通过hibernate的翻译器(QueryTranslator)将jpql翻译成sql
     * @param jpql
     * @return
     */
    private String jpqlToSql(String jpql) {
        QueryTranslator qt = new QueryTranslatorImpl(jpql, jpql,
                Collections.EMPTY_MAP,
                (SessionFactoryImplementor) getHibernateSessionFactory());
        qt.compile(Collections.EMPTY_MAP, false);
        return qt.getSQLString();
    }

    private <T> List<T> transformModelObject(Class<T> resultClass, List cacheList){
        List<T> resultList = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(cacheList)){
            for (Object obj : cacheList) {
                try {
                    T row = null;
                    Object[] columns = (Object[])obj;
                    //获取所有公共的构造器
                    Constructor[] constructors = resultClass.getConstructors();
                    for (Constructor constructor: constructors) {
                        if(constructor.getParameterTypes().length == columns.length){
                            boolean clazzCheck = true; //参数类型检查
                            for (int i = 0; i < constructor.getParameterTypes().length; i++){
                                String clazzName = constructor.getParameterTypes()[i].getName();
                                if(columns[i]==null){
                                    continue;
                                }else if (!clazzName.equalsIgnoreCase(columns[i].getClass().getName())){
                                    clazzCheck = false;
                                    break;
                                }
                            }

                            if(clazzCheck){
                                row = (T)constructor.newInstance(columns);
                                resultList.add(row);
                            }else{
                                continue;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        return resultList;
    }

    private <T> T transformModelObject(Class<T> resultClass, Object cache){

        if(cache!=null){
            try {
                T row = null;
                Object[] columns = (Object[])cache;
                //获取所有公共的构造器
                Constructor[] constructors = resultClass.getConstructors();
                for (Constructor constructor: constructors) {
                    if(constructor.getParameterTypes().length == columns.length){
                        boolean clazzCheck = true; //参数类型检查
                        for (int i = 0; i < constructor.getParameterTypes().length; i++){
                            String clazzName = constructor.getParameterTypes()[i].getName();
                            if(columns[i]==null){
                                continue;
                            }else if(!clazzName.equalsIgnoreCase(columns[i].getClass().getName())){
                                clazzCheck = false;
                                break;
                            }
                        }

                        if(clazzCheck){
                            row = (T)constructor.newInstance(columns);
                        }else{
                            continue;
                        }
                    }
                }

                return row;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private void setParameter(Query q, Object... params){
        for (int i=0; i<params.length ;i++) {
            Object param = params[i];
            if(param instanceof Date){
                q.setParameter(i+1, (Date)param, TemporalType.DATE);
            }else if(param instanceof Integer){
                q.setParameter(i+1, (Integer)param);
            }else if(param instanceof Long){
                q.setParameter(i+1, (Long)param);
            }else if(param instanceof Float){
                q.setParameter(i+1, (Float)param);
            }else if(param instanceof Double){
                q.setParameter(i+1, (Double)param);
            }else if(param instanceof BigDecimal){
                q.setParameter(i+1, (BigDecimal)param);
            }else if(param instanceof Boolean){
                q.setParameter(i+1, (Boolean)param);
            }else if(param instanceof Char){
                q.setParameter(i+1, (Char)param);
            }else{
                q.setParameter(i+1, param);
            }
        }
    }

    private <T> void setParameter(TypedQuery<T> q, Object... params){
        for (int i=0; i<params.length ;i++) {
            Object param = params[i];
            if(param instanceof Date){
                q.setParameter(i+1, (Date)param, TemporalType.DATE);
            }else if(param instanceof Integer){
                q.setParameter(i+1, (Integer)param);
            }else if(param instanceof Long){
                q.setParameter(i+1, (Long)param);
            }else if(param instanceof Float){
                q.setParameter(i+1, (Float)param);
            }else if(param instanceof Double){
                q.setParameter(i+1, (Double)param);
            }else if(param instanceof BigDecimal){
                q.setParameter(i+1, (BigDecimal)param);
            }else if(param instanceof Boolean){
                q.setParameter(i+1, (Boolean)param);
            }else if(param instanceof Char){
                q.setParameter(i+1, (Char)param);
            }else{
                q.setParameter(i+1, param);
            }
        }
    }

    private void setParameter(Query q, Map<String, Object> params){
        for (String key: params.keySet()) {
            Object param = params.get(key);
            if(param instanceof Date){
                q.setParameter(key, (Date)param, TemporalType.DATE);
            }else if(param instanceof Integer){
                q.setParameter(key, (Integer)param);
            }else if(param instanceof Long){
                q.setParameter(key, (Long)param);
            }else if(param instanceof Float){
                q.setParameter(key, (Float)param);
            }else if(param instanceof Double){
                q.setParameter(key, (Double)param);
            }else if(param instanceof BigDecimal){
                q.setParameter(key, (BigDecimal)param);
            }else if(param instanceof Boolean){
                q.setParameter(key, (Boolean)param);
            }else if(param instanceof Char){
                q.setParameter(key, (Char)param);
            }else{
                q.setParameter(key, param);
            }
        }
    }

    private <T> void setParameter(TypedQuery<T> q, Map<String, Object> params){
        for (String key: params.keySet()) {
            Object param = params.get(key);
            if(param instanceof Date){
                q.setParameter(key, (Date)param, TemporalType.DATE);
            }else if(param instanceof Integer){
                q.setParameter(key, (Integer)param);
            }else if(param instanceof Long){
                q.setParameter(key, (Long)param);
            }else if(param instanceof Float){
                q.setParameter(key, (Float)param);
            }else if(param instanceof Double){
                q.setParameter(key, (Double)param);
            }else if(param instanceof BigDecimal){
                q.setParameter(key, (BigDecimal)param);
            }else if(param instanceof Boolean){
                q.setParameter(key, (Boolean)param);
            }else if(param instanceof Char){
                q.setParameter(key, (Char)param);
            }else{
                q.setParameter(key, param);
            }
        }
    }



    private String cleanSql(String sql){
        return sql.replaceAll("\r|\n"," ");
    }
}
