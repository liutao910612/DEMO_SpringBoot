package com.liutao.tag;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * 表格标签
 *
 * @author LIUTAO
 * @version 2017/6/27
 * @see
 */
@Component
public class TreeGridDirective extends BasicGridDirective {

    private Logger logger = LoggerFactory.getLogger(TreeGridDirective.class);

    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {
        Writer out = env.getOut();

        //获取表格相关数据
        getBasicSetting(params);

        bodyStr = new StringBuffer("");
        //判断是否有非空的嵌入体
        if (body != null) {
            logger.debug("begin bodywriter");
            body.render(new BodyWriter(out));
            String tableStr = getTableString().toString();
            out.write(tableStr);
        } else {
            throw new RuntimeException(" missing body");
        }
    }

    /**
     * 构建table
     *
     * @return
     */
    private StringBuffer getTableString() {
        StringBuffer sb = new StringBuffer();

        sb.append("<table id=\"" + dataGridModel.getId() + "\" >\n")
                .append("</table>\n")
                .append("<script>\n")
                .append("$(function () {\n")
                .append("var tree = $('#").append(dataGridModel.getId()).append("');\n")
                .append("tree.treegrid({\n")
                .append("url: '").append(dataGridModel.getUrl()).append("',\n")
                .append("width: '").append(dataGridModel.getWidth()).append("',\n")
                .append("height: '").append(dataGridModel.getHeight()).append("',\n")
                .append("animate: true,\n")
                .append("fitColumns: true,\n")
                .append("rownumbers: ").append(dataGridModel.isRownumbers()).append(",\n")
                .append("collapsible: true,\n")
                .append("idField: 'id',\n")
                .append("treeField: 'name',\n")
                .append("pagination: ").append(dataGridModel.isPagination()).append(",\n")
                .append("striped:true,\n")
                .append("singleSelect: ").append(dataGridModel.isSingleSelect()).append(",\n")
                .append("pageSize: 10,\n")
                .append("pageNumber: 1,\n")
                .append("columns: [[\n")
                .append(bodyStr.toString())
                .append("]],\n")
                .append("onCheck: function (node) {\n")
                .append("var childrenNodes = tree.treegrid(\"getChildren\", node.id);\n")
                .append("for (var i = 0; i < childrenNodes.length; i++) {\n")
                .append("tree.treegrid(\"select\", childrenNodes[i].id);\n")
                .append("}\n")
                .append("},\n")
                .append("onUncheck: function (node) {\n")
                .append("var childrenNodes = tree.treegrid(\"getChildren\", node.id);\n")
                .append("for (var i = 0; i < childrenNodes.length; i++) {\n")
                .append("tree.treegrid(\"unselectRow\", childrenNodes[i].id);\n")
                .append("}\n")
                .append("}//设置分页控件\n")
                .append("\n")
                .append("});\n")
                .append("var p = tree.treegrid('getPager');\n")
                .append("$(p).pagination({\n")
                .append("pageSize: ").append(dataGridModel.getPageSize()).append(",//每页显示的记录条数，默认为5\n")
                .append("pageList: ").append(dataGridModel.getPageList()).append(",//可以设置每页记录条数的列表\n")
                .append("beforePageText: '第',//页数文本框前显示的汉字\n")
                .append("afterPageText: '页    共 {pages} 页',\n")
                .append("displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',\n")
                .append("});\n")
                .append("})\n")
                .append("</script>");
        return sb;
    }
}
