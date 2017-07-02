package com.liutao.tag;

import com.liutao.tag.model.DataGridModel;
import com.liutao.tag.util.CommonUtil;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateModel;
import org.springframework.cglib.beans.BeanMap;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * 数据网格基础类
 *
 * @author LIUTAO
 * @version 2017/7/2
 * @see
 * @since
 */
public abstract class BasicGridDirective implements TemplateDirectiveModel {
    protected StringBuffer bodyStr = new StringBuffer("");  //嵌入体
    protected DataGridModel dataGridModel = new DataGridModel();

    /**
     * 获取表格设置参数
     * @param params
     */
    protected void getBasicSetting(Map params) {

//        if (paramIsNull(params,"fitColumns")){
//            dataGridModel.setFitColumns(Boolean.valueOf(((TemplateModel) params.get("fitColumns")).toString()));
//        }
//
//        if (paramIsNull(params, "id")) {
//            dataGridModel.setId(((TemplateModel) params.get("id")).toString());
//        } else {
//            throw new RuntimeException("id must be existed!");
//        }
//
//        if (paramIsNull(params, "url")) {
//            dataGridModel.setUrl(((TemplateModel) params.get("url")).toString());
//        } else {
//            throw new RuntimeException("url must be existed!");
//        }
//
//        if (paramIsNull(params, "checkbox")) {
//            dataGridModel.setCheckbox(Boolean.valueOf(((TemplateModel) params.get("checkbox")).toString()));
//        }
//
//        if (paramIsNull(params, "selectOnCheck")) {
//            dataGridModel.setSelectOnCheck(Boolean.valueOf(((TemplateModel) params.get("selectOnCheck")).toString()));
//        }
//
//        if (paramIsNull(params, "checkOnSelect")) {
//            dataGridModel.setCheckOnSelect(Boolean.valueOf(((TemplateModel) params.get("checkOnSelect")).toString()));
//        }
//
//        if (paramIsNull(params, "singleSelect")) {
//            dataGridModel.setSingleSelect(Boolean.valueOf(((TemplateModel) params.get("singleSelect")).toString()));
//        }
//
//        if (paramIsNull(params, "pagination")) {
//            dataGridModel.setPagination(Boolean.valueOf(((TemplateModel) params.get("pagination")).toString()));
//        }
//
//        if (paramIsNull(params, "rownumbers")) {
//            dataGridModel.setRownumbers(Boolean.valueOf(((TemplateModel) params.get("rownumbers")).toString()));
//        }
//
//        if (paramIsNull(params, "height")) {
//            dataGridModel.setHeight(((TemplateModel) params.get("height")).toString());
//        }
//
//        if (paramIsNull(params, "width")) {
//            dataGridModel.setWidth(((TemplateModel) params.get("width")).toString());
//        }
//
//        if (paramIsNull(params, "pageList")) {
//            dataGridModel.setPageList(((TemplateModel) params.get("pageList")).toString());
//        }
//
//        if (paramIsNull(params, "pageSize")) {
//            dataGridModel.setPageSize(Integer.valueOf(((TemplateModel) params.get("pageSize")).toString()));
//        }

        dataGridModel = CommonUtil.mapToBean(params,dataGridModel);
    }

    /**
     * 判断参数是否存在
     * @param params
     * @param id
     * @return
     */
    protected boolean paramIsNull(Map params, String id) {
        return null != params.get(id);
    }



    /**
     * 输出内部类
     */
    protected class BodyWriter extends Writer {
        private final Writer out;

        BodyWriter(Writer out) {
            this.out = out;
        }

        @Override
        public void write(char[] cbuf, int off, int len) throws IOException {

            char[] chars = new char[len];

            for (int k = 0; k < len; k++) {
                chars[k] = cbuf[k];
            }

            bodyStr.append(String.valueOf(chars))
                    .append(",\n");
        }

        @Override
        public void flush() throws IOException {
            out.flush();
        }

        @Override
        public void close() throws IOException {

        }
    }
}
