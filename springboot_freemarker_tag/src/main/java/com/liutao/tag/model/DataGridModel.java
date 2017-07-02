package com.liutao.tag.model;

/**
 * DataGrid model
 *
 * @author LIUTAO
 * @version 2017/6/29
 * @see
 * @since
 */
public class DataGridModel {
    private Boolean fitColumns = false;         //是否自动扩大或缩小以适应网格的宽度
    private String resizeHandle = "right";      //调整列的位置
    private Boolean striped = false;            //是否条文化
    private String method = "POST";             //请求远程数据的方法
    private String loadMsg = "数据加载中，请稍后……";                //当从远程站点加载数据时，显示的提示消息。
    private String id;                  //表格id
    private String url;                 //表格url
    private boolean checkbox = true;    //是否复选
    private int pageSize = 5;           //分页默认大小
    private String pageList = "[5, 10, 20,40]"; //分页选择列表
    private String width = "auto";  //表格宽度
    private String height = "auto"; //表格高度
    private boolean rownumbers = false;//是否允许选择行号
    private boolean pagination = true;//是否允许分页
    private boolean singleSelect = false;
    private boolean checkOnSelect = true;
    private boolean selectOnCheck = true;
    private boolean showFooter = false;
    private boolean remoteFilter = false;
    private String remoteFilterUrl;

    public DataGridModel() {
    }

    public DataGridModel(Boolean fitColumns, String resizeHandle, Boolean striped, String method,
                         String loadMsg, String id, String url, boolean checkbox, int pageSize,
                         String pageList, String width, String height, boolean rownumbers, boolean pagination,
                         boolean singleSelect, boolean checkOnSelect, boolean selectOnCheck, boolean showFooter) {
        this.fitColumns = fitColumns;
        this.resizeHandle = resizeHandle;
        this.striped = striped;
        this.method = method;
        this.loadMsg = loadMsg;
        this.id = id;
        this.url = url;
        this.checkbox = checkbox;
        this.pageSize = pageSize;
        this.pageList = pageList;
        this.width = width;
        this.height = height;
        this.rownumbers = rownumbers;
        this.pagination = pagination;
        this.singleSelect = singleSelect;
        this.checkOnSelect = checkOnSelect;
        this.selectOnCheck = selectOnCheck;
        this.showFooter = showFooter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isCheckbox() {
        return checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageList() {
        return pageList;
    }

    public void setPageList(String pageList) {
        this.pageList = pageList;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public boolean isRownumbers() {
        return rownumbers;
    }

    public void setRownumbers(boolean rownumbers) {
        this.rownumbers = rownumbers;
    }

    public boolean isPagination() {
        return pagination;
    }

    public void setPagination(boolean pagination) {
        this.pagination = pagination;
    }

    public boolean isSingleSelect() {
        return singleSelect;
    }

    public void setSingleSelect(boolean singleSelect) {
        this.singleSelect = singleSelect;
    }

    public boolean isCheckOnSelect() {
        return checkOnSelect;
    }

    public void setCheckOnSelect(boolean checkOnSelect) {
        this.checkOnSelect = checkOnSelect;
    }

    public boolean isSelectOnCheck() {
        return selectOnCheck;
    }

    public void setSelectOnCheck(boolean selectOnCheck) {
        this.selectOnCheck = selectOnCheck;
    }

    public Boolean getFitColumns() {
        return fitColumns;
    }

    public void setFitColumns(Boolean fitColumns) {
        this.fitColumns = fitColumns;
    }

    public String getResizeHandle() {
        return resizeHandle;
    }

    public void setResizeHandle(String resizeHandle) {
        this.resizeHandle = resizeHandle;
    }

    public Boolean getStriped() {
        return striped;
    }

    public void setStriped(Boolean striped) {
        this.striped = striped;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getLoadMsg() {
        return loadMsg;
    }

    public void setLoadMsg(String loadMsg) {
        this.loadMsg = loadMsg;
    }

    public boolean isShowFooter() {
        return showFooter;
    }

    public void setShowFooter(boolean showFooter) {
        this.showFooter = showFooter;
    }

    public boolean isRemoteFilter() {
        return remoteFilter;
    }

    public void setRemoteFilter(boolean remoteFilter) {
        this.remoteFilter = remoteFilter;
    }

    public String getRemoteFilterUrl() {
        return remoteFilterUrl;
    }

    public void setRemoteFilterUrl(String remoteFilterUrl) {
        this.remoteFilterUrl = remoteFilterUrl;
    }

    @Override
    public String toString() {
        return "DataGridModel{" +
                "fitColumns=" + fitColumns +
                ", resizeHandle='" + resizeHandle + '\'' +
                ", striped=" + striped +
                ", method='" + method + '\'' +
                ", loadMsg='" + loadMsg + '\'' +
                ", id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", checkbox=" + checkbox +
                ", pageSize=" + pageSize +
                ", pageList='" + pageList + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                ", rownumbers=" + rownumbers +
                ", pagination=" + pagination +
                ", singleSelect=" + singleSelect +
                ", checkOnSelect=" + checkOnSelect +
                ", selectOnCheck=" + selectOnCheck +
                ", showFooter=" + showFooter +
                ", remoteFilter=" + remoteFilter +
                ", remoteFilterUrl='" + remoteFilterUrl + '\'' +
                '}';
    }
}
