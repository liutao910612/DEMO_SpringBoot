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
public class DataGridDirective extends BasicGridDirective {

    private Logger logger = LoggerFactory.getLogger(DataGridDirective.class);

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
            throw new RuntimeException("missing body");
        }
    }

    /**
     * 构建table
     *
     * @return
     */
    private StringBuffer getTableString() {
        StringBuffer sb = new StringBuffer();
        sb.append("<table id=\"skuInfoTable\" style=\"width:auto;width:auto\">\n")
                .append("<script type=\"text/javascript\">\n")
                .append("    $(function () {\n" )
                .append("        var dg = $('#skuInfoTable').datagrid({\n" )
                .append("            method: 'post',\n" )
                .append("            dataType: 'json',\n" )
                .append("            remoteFilter: true,\n" )
                .append("            remoteFilterUrl: '/liutao/springboot/freemark/users',\n" )
                .append("            url: '/liutao/springboot/freemark/users',\n" )
                .append("            width: 'auto',\n" )
                .append("            height: 'auto',\n" )
                .append("\n" )
                .append("            //开启合计功能\n" )
                .append("            showFooter:true,\n" )
                .append("\n" )
                .append("            striped: true,\n" )
                .append("            fitColumns: 'false',\n" )
                .append("            loadMsg: \"数据加载中，请稍后……\",\n" )
                .append("            pagination: true,\n" )
                .append("            scrollOnSelect:true,\n" )
                .append("            frozenColumns: [[\n" )
                .append("            {\n" )
                .append("                field: 'ck', //列字段名称\n" )
                .append("                width: 10,   //列宽度\n" )
                .append("                checkbox:true\n" )
                .append("            },]],\n" )
                .append("            columns: [[          //列配置对象\n" )
                .append("                {field: 'id', hidden: true, sortable: false, title: '用户id', width: 20},\n" )
                .append("                {field: 'name', hidden: false,  title: '姓名', width: 20},\n" )
                .append("                {field: 'age', hidden: false, sortable: false, sortable: true,title: '年龄', width: 20},\n" )
                .append("                {field: 'password', hidden: false, sortable: false, title: '密码', width: 20},\n" )
                .append("                {field: 'email', hidden: false, sortable: false, title: '邮箱', width: 20},\n" )
                .append("                {field: 'type', hidden: false, sortable: false, title: '年龄阶段', width: 20},\n" )
                .append("                {\n" )
                .append("                    field: '_operate',\n" )
                .append("                    width: 100,\n" )
                .append("                    align: 'center',\n" )
                .append("                    formatter: function (value, row, index) {\n" )
                .append("                        return \"<a href='#' onclick='findBasInfoDetail(\" ) index ) \")'>查看详情</a>&nbsp;&nbsp;" )
                .append("                                 <a href='#' onclick='modifyBasSkuInfo(\" ) index ) \")'>编辑</a>&nbsp;&nbsp;" )
                .append("                                 <a href='#' onclick='deleteItem(\" ) index ) \")'>删除</a>&nbsp;&nbsp;\"\n" )
                .append("                    },\n" )
                .append("                    title: '操作'\n" )
                .append("                },\n" )
                .append("\n" )
                .append("            ]],\n" )
                .append("            onClickRow: function (rowIndex, rowData) {\n" )
                .append("                $(this).datagrid('unselectRow', rowIndex);\n" )
                .append("            }\n" )
                .append("        });\n" )
                .append("\n" )
                .append("//        添加过滤\n" )
                .append("        dg.datagrid('enableFilter', [\n" )
                .append("            {\n" )
                .append("                field: 'name',\n" )
                .append("                type: 'text'\n" )
                .append("            },\n" )
                .append("            {\n" )
                .append("                field: 'type',\n" )
                .append("                type: 'combobox',\n" )
                .append("                options: {\n" )
                .append("                    panelHeight: 'auto',\n" )
                .append("                    data: [\n" )
                .append("                            {value: '', text: '所有'},\n" )
                .append("                            {value: '老', text: '老'},\n" )
                .append("                            {value: '中', text: '中'},\n" )
                .append("                            {value: '青', text: '青'},\n" )
                .append("                            {value: '少', text: '少'},\n" )
                .append("                            {value: '幼', text: '幼'}\n" )
                .append("                    ],\n" )
                .append("                    onChange: function (value) {\n" )
                .append("                        if (value == '') {\n" )
                .append("                            dg.datagrid('removeFilterRule', 'type');\n" )
                .append("                        } else {\n" )
                .append("                            dg.datagrid('addFilterRule', {\n" )
                .append("                                field: 'type',\n" )
                .append("                                op: 'equal',\n" )
                .append("                                value: value\n" )
                .append("                            });\n" )
                .append("                        }\n" )
                .append("                        dg.datagrid('doFilter');\n" )
                .append("                    }\n" )
                .append("                }\n" )
                .append("            }\n" )
                .append("        ]);\n" )
                .append("\n" )
                .append("        //设置分页控件\n" )
                .append("        var p = dg.datagrid('getPager');\n" )
                .append("        $(p).pagination({\n" )
                .append("            pageSize: 10,//每页显示的记录条数，默认为5\n" )
                .append("            pageList: [10, 20, 30, 50],//可以设置每页记录条数的列表\n" )
                .append("//            pageHeight:auto;\n" )
                .append("            beforePageText: '第',//页数文本框前显示的汉字\n" )
                .append("            afterPageText: '页    共 {pages} 页',\n" )
                .append("            displayMsg: '显示 {from} - {to} 条,共 {total} 条'\n" )
                .append("        });\n" )
                .append("    });\n")
                .append("</script>");
        return sb;
    }
}
