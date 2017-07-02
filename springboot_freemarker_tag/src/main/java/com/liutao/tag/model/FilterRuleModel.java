package com.liutao.tag.model;

/**
 * 过滤条件model
 *
 * @author LIUTAO
 * @version 2017/7/2
 * @see
 * @since
 */
public class FilterRuleModel {
    private String field;   //属性
    private String op;      //规则
    private String value;   //条件

    public FilterRuleModel() {
    }

    public FilterRuleModel(String field, String op, String value) {
        this.field = field;
        this.op = op;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "FilterModel{" +
                "field='" + field + '\'' +
                ", op='" + op + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
