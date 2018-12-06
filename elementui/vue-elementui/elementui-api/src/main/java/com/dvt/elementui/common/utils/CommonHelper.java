package com.dvt.elementui.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

public class CommonHelper {

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
}
