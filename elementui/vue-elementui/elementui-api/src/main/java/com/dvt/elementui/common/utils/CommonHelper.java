package com.dvt.elementui.common.utils;

import com.google.common.collect.ImmutableList;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CommonHelper {

    public static final char UNDERLINE = '_';

    public static String[] getNullPropertyNames (Object source, boolean doNotCopyBlankStr) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());

            if(doNotCopyBlankStr)
            if (srcValue instanceof String && StringUtils.isBlank((String)srcValue)){
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static void copyPropertiesIgnoreNull(Object src, Object target){
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src, false));
    }

    public static void copyPropertiesIgnoreNull(Object src, Object target, Boolean doNotCopyBlankStr){
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src, doNotCopyBlankStr));
    }

    /**
     * map 转 java bean
     *
     * @return
     */
    public static <T> T map2JavaBean(Map<String, T> map, Class<T> beanClass) throws Exception {
        if (map == null)
            return null;
        T obj = beanClass.newInstance();
        org.apache.commons.beanutils.BeanUtils.populate(obj, map);
        return obj;
    }

    /**
     * java bean 转 map
     *
     * @return
     */
    public static <String, T> Map<String, T> javaBean2Map(Object obj) {
        if(obj == null)
            return null;
        return (Map<String, T>) new org.apache.commons.beanutils.BeanMap(obj);
    }

    /**
     * 驼峰格式字符串转换为下划线格式字符串
     *
     * @param param
     * @return
     */
    public static String camelToUnderline(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 下划线格式字符串转换为驼峰格式字符串
     *
     * @param param
     * @return
     */
    public static String underlineToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == UNDERLINE) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static <T> void clearFields(T obj, String...targetFields){
        List<T> objs = ImmutableList.of(obj);
        if(targetFields!=null && targetFields.length>0){
            clearToMany(objs, targetFields);
        }else{
            clearToMany(objs);
        }
    }

    public static <T> void clearFields(List<T> list, String...targetFields){
        if(targetFields!=null && targetFields.length>0){
            clearToMany(list, targetFields);
        }else{
            clearToMany(list);
        }
    }

    private static <T> void clearToMany(List<T> list) {
        if(CollectionUtils.isEmpty(list)){ return; }
        Class clazz = list.get(0).getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation oneToManyAnno = field.getAnnotation(OneToMany.class);
            Annotation manyToManyAnno = field.getAnnotation(ManyToMany.class);
            Annotation manyToOneAnno = field.getAnnotation(ManyToOne.class);
            Annotation OneToOneAnno = field.getAnnotation(OneToOne.class);
            if(oneToManyAnno!=null || manyToManyAnno!=null){
                for(Method m : clazz.getMethods()){
                    if(m.getName().equalsIgnoreCase("set" + field.getName())){
                        System.out.println(m.getName());
                        list.forEach(el -> {
                            try {
                                m.invoke(el, (Object)null);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        });
                    }
                }
            }else if(manyToOneAnno!=null || OneToOneAnno!=null){
                for(Method m : clazz.getMethods()){
                    if(m.getName().equalsIgnoreCase("get" + field.getName())){
                        System.out.println(m.getName());
                        Class oneClass = m.getGenericReturnType().getClass();
                        list.forEach(el -> {
                            try {

                                Object one = m.invoke(el);
                                one = HibernateUtils.deproxy(one);
                                clearFields(one);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        });
                    }
                }
            }
        }
    }

    private static <T> void clearToMany(List<T> list, String...targetFields) {
        if(CollectionUtils.isEmpty(list)){ return; }
        Class clazz = list.get(0).getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (String targetField: targetFields){
                Field field =  clazz.getField(targetField);
                Annotation oneToManyAnno = field.getAnnotation(OneToMany.class);
                Annotation manyToManyAnno = field.getAnnotation(ManyToMany.class);
                Annotation manyToOneAnno = field.getAnnotation(ManyToOne.class);
                Annotation OneToOneAnno = field.getAnnotation(OneToOne.class);
                if(oneToManyAnno!=null || manyToManyAnno!=null){
                    Method m = clazz.getMethod("set" + StringUtils.capitalize(field.getName())); //首字母大写
                    list.forEach(el -> {
                        try {
                            m.invoke(el, (Object)null);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    });
                }else if(manyToOneAnno!=null || OneToOneAnno!=null){
                    Method m = clazz.getMethod("get" + StringUtils.capitalize(field.getName())); //首字母大写
                    list.forEach(el -> {
                        try {
                            Object one = m.invoke(el);
                            one = HibernateUtils.deproxy(one);
                            clearFields(one);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }


}
