package com.liutao.tag.model;

import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * EasyUi列表获取参数对象
 *
 * @author LIUTAO
 * @version 2017/7/2
 * @see
 * @since
 */
public class RequestModel {
    private Integer page = 1;  //第几页
    private Integer rows = 5;  //页面大小
    private Integer startRow;
    private Integer endRow;
    private String sort;  //排序field
    private String order = "desc";  //排序规则
    private String filterRules;
    private List<FilterRuleModel> filterRulelList;

    public RequestModel() {
    }

    public RequestModel(Integer page, Integer rows, Integer startRow, Integer endRow, String sort,
                        String order, String filterRules) {
        this.page = page;
        this.rows = rows;
        this.startRow = startRow;
        this.endRow = endRow;
        this.sort = sort;
        this.order = order;
        this.filterRules = filterRules;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
        this.startRow = (this.page-1)*this.rows;
        this.endRow = this.page*this.rows;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getEndRow() {
        return endRow;
    }

    public void setEndRow(Integer endRow) {
        this.endRow = endRow;
    }


    public String getFilterRules() {
        return filterRules;
    }

    public void setFilterRules(String filterRules) {
        this.filterRules = filterRules;
        JSONArray jsonArray = JSONArray.fromObject(this.filterRules);
        this.filterRulelList = JSONArray.toList(jsonArray,FilterRuleModel.class);
    }

    @Override
    public String toString() {
        return "RequestModel{" +
                "page=" + page +
                ", rows=" + rows +
                ", startRow=" + startRow +
                ", endRow=" + endRow +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                ", filterRules='" + filterRules + '\'' +
                ", filterRulelList=" + filterRulelList +
                '}';
    }
}
