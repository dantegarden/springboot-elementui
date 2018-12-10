package com.dvt.elementui.common.plugin;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import java.util.Collection;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;

public class MyMapperPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

//    @Override
//    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
//        try {
//            Field field = sqlMap.getClass().getDeclaredField("isMergeable");
//            field.setAccessible(true);
//            field.setBoolean(sqlMap, false);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return super.sqlMapGenerated(sqlMap, introspectedTable);
//    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        boolean result = super.clientGenerated(interfaze, topLevelClass, introspectedTable);
        addAnnotation(interfaze);
        return result;
    }

    private void addAnnotation(Interface interfaze) {
        for (Annotations annotation : Annotations.values()) {
            interfaze.addImportedType(annotation.javaType);
            interfaze.addAnnotation(annotation.name);
        }
    }

    private enum Annotations {
        REPOSITORY("repository", "@Repository", "org.springframework.stereotype.Repository");
        private final String paramName;
        private final String name;
        private final FullyQualifiedJavaType javaType;
        Annotations(String paramName, String name, String className) {
            this.paramName = paramName;
            this.name = name;
            this.javaType = new FullyQualifiedJavaType(className);
        }

        private static Annotations getValueOf(String paramName) {
            for (Annotations annotation : Annotations.values())
                if (String.CASE_INSENSITIVE_ORDER.compare(paramName, annotation.paramName) == 0)
                    return annotation;
            return null;
        }
    }
}