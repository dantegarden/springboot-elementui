package com.dvt.elementui.common.utils;

import com.dvt.elementui.biz.vo.demo.FieldFilterVO;
import com.dvt.elementui.biz.vo.demo.QueryForm;

import java.text.MessageFormat;
import java.util.List;

public class PivotUtils {

    public enum QueryFilterRelationEnum {
        /**
         * 筛选器 关联关系类型
         */
        AND("and"),
        OR("or");

        private String value;

        QueryFilterRelationEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }


    public static String transformToSql(QueryForm queryForm){
        StringBuilder sql = new StringBuilder();
        List<FieldFilterVO> fieldFilter = queryForm.getFieldFilter();
        for (FieldFilterVO ffvo: fieldFilter) {
            sql.append(" and ");

            if(ffvo.getRelation().equals("and")){
                List<List<String>> conditions = ffvo.getQuery();
                sql.append(" ( 1=1 ");
                for(List<String> items: conditions){
                    String field = items.get(0);
                    String relation = items.get(1);
                    String value = items.get(2);
                    transformFilter(QueryFilterRelationEnum.AND.getValue(), field, relation, value, sql);
                }
                sql.append(" ) ");
            }else if(ffvo.getRelation().equals("or")){
                List<List<String>> conditions = ffvo.getQuery();
                sql.append(" ( 1=0 ");
                for(List<String> items: conditions){
                    String field = items.get(0);
                    String relation = items.get(1);
                    String value = items.get(2);
                    transformFilter(QueryFilterRelationEnum.OR.getValue(), field, relation, value, sql);
                }
                sql.append(" ) ");
            }
        }
        //排序
        sql.append(" order by month ");
//        List<String> items = (List<String>) CollectionUtils.union(queryForm.getRowKeys(), queryForm.getColKeys());
//        if(CollectionUtils.isNotEmpty(items)){
//            sql.append(" order by ");
//            for(String item: items){
//                sql.append(item +",");
//                sql = new StringBuilder(sql.substring(0, sql.length()-1));
//            }
//        }

        return sql.toString();
    }

    private static void transformFilter(String type, String key,String relation, String value, StringBuilder sql){
        boolean flag = false;
        if("=".equals(relation)){
            sql.append(MessageFormat.format(" {0} {1} = ''{2}'' ", type, key,value));
        }else if("!=".equals(relation)){
            sql.append(MessageFormat.format(" {0} {1} != ''{2}'' ", type, key,value));
        }else if(">".equals(relation)){
            sql.append(MessageFormat.format(" {0} {1} > ''{2}'' ", type, key,value));
        }else if("<".equals(relation)){
            sql.append(MessageFormat.format(" {0} {1} < ''{2}'' ", type, key,value));
        }else if(">=".equals(relation)){
            sql.append(MessageFormat.format(" {0} {1} >= ''{2}'' ", type, key,value));
        }else if("<=".equals(relation)){
            sql.append(MessageFormat.format(" {0} {1} <= ''{2}'' ", type, key,value));
        }else if("like".equals(relation)){
            sql.append(MessageFormat.format(" {0} {1} like ''%{2}%'' ", type, key,value));
        }else if("not like".equals(relation)){
            sql.append(MessageFormat.format(" {0} {1} not like ''%{2}%'' ", type, key,value));
        }else if("startwith".equals(relation)){
            sql.append(MessageFormat.format(" {0} {1} like ''%{2}'' ", type, key,value));
        }else if("endwith".equals(relation)){
            sql.append(MessageFormat.format(" {0} {1} like ''{2}%'' ", type, key,value));
        }else if("null".equals(relation)){
            sql.append(MessageFormat.format(" {0} {1} is null ", type, key,value));
        }else if("not null".equals(relation)){
            sql.append(MessageFormat.format(" {0} {1} is not null ", type, key,value));
        }
    }
}
