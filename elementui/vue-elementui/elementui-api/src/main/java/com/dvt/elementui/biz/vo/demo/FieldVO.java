package com.dvt.elementui.biz.vo.demo;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class FieldVO {

    /**字段名**/
    private String field;
    /**字段名 中文**/
    private String label;
    /**字段类型**/
    private Enum<FieldVO.FieldTypeEnum> type = FieldVO.FieldTypeEnum.STRING;
    /**关系列表**/
    private List<RelationVO> relations;
    /**字典类型 仅限字段类型是Selection的**/
    private String dict;

    private static Map<Enum<FieldVO.FieldTypeEnum>, List<RelationVO>> relationsMap = ImmutableMap.of(
            FieldVO.FieldTypeEnum.STRING, ImmutableList.of(
                    RelationVO.of("包含","like"),
                    RelationVO.of("不包含","not like"),
                    RelationVO.of("等于","="),
                    RelationVO.of("不等于","!="),
                    RelationVO.of("找开头是","startwith"),
                    RelationVO.of("找结尾是","endwith"),
                    RelationVO.of("已设置","not null"),
                    RelationVO.of("未设置","null")),
            FieldVO.FieldTypeEnum.NUMBER, ImmutableList.of(
                    RelationVO.of("等于","="),
                    RelationVO.of("不等于","!="),
                    RelationVO.of("大于",">"),
                    RelationVO.of("小于","<"),
                    RelationVO.of("大于等于",">="),
                    RelationVO.of("小于等于","<="),
                    RelationVO.of("已设置","not null"),
                    RelationVO.of("未设置","null")),
            FieldVO.FieldTypeEnum.DATE, ImmutableList.of(
                    RelationVO.of("等于","="),
                    RelationVO.of("不等于","!="),
                    RelationVO.of("晚于",">"),
                    RelationVO.of("早于","<"),
                    RelationVO.of("不早于",">="),
                    RelationVO.of("不晚于","<="),
                    RelationVO.of("已设置","not null"),
                    RelationVO.of("未设置","null")),
            FieldVO.FieldTypeEnum.DATETIME, ImmutableList.of(
                    RelationVO.of("等于","="),
                    RelationVO.of("不等于","!="),
                    RelationVO.of("晚于",">"),
                    RelationVO.of("早于","<"),
                    RelationVO.of("不早于",">="),
                    RelationVO.of("不晚于","<="),
                    RelationVO.of("已设置","not null"),
                    RelationVO.of("未设置","null")),
            FieldVO.FieldTypeEnum.SELECTION, ImmutableList.of(
                    RelationVO.of("是","="),
                    RelationVO.of("不是","!="),
                    RelationVO.of("已设置","not null"),
                    RelationVO.of("未设置","null"))
    );





    public enum FieldTypeEnum {
        /**
         * 字段类型
         */
        STRING("String"),
        NUMBER("Number"),
        DATE("Date"),
        DATETIME("DateTime"),
        SELECTION("Selection");

        private String value;

        FieldTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public FieldVO() {
    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Enum<FieldVO.FieldTypeEnum> getType() {
        return this.type;
    }

    public void setType(Enum<FieldVO.FieldTypeEnum> type) {
        this.type = type;
        this.relations = relationsMap.get(type);
    }

    public String getDict() {
        return this.dict;
    }

    public void setDict(String dict) {
        this.dict = dict;
    }

    public FieldVO(String field, String label) {
        this.field = field;
        this.label = label;
        this.relations = relationsMap.get(FieldVO.FieldTypeEnum.STRING);
    }

    public FieldVO(String field, String label, Enum<FieldVO.FieldTypeEnum> type) {
        this.field = field;
        this.label = label;
        this.type = type;
        this.relations = relationsMap.get(type);
    }

    public FieldVO(String field, String label, String dict) {
        this.field = field;
        this.label = label;
        this.type = FieldTypeEnum.SELECTION;
        this.relations = relationsMap.get(FieldTypeEnum.SELECTION);
        this.dict = dict;
    }

    public List<RelationVO> getRelations() {
        return this.relations;
    }

    public void setRelations(List<RelationVO> relations) {
        this.relations = relations;
    }
}
