package com.liutao.tag;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * 表格行标签
 *
 * @author LIUTAO
 * @version 2017/6/27
 * @see
 */
@Component
public class ColDirective implements TemplateDirectiveModel {
    private Logger logger = LoggerFactory.getLogger(ColDirective.class);
    private String field;              //col属性名
    private String title;              //标题
    private boolean sortable = false;     //是否排序
    private Integer width = 20;             //宽度
    private boolean hidden = false;      //是否隐藏

    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {
        Writer out = env.getOut();
        String col;
        //获取属性
        if (null == params.get("field")) {
            throw new RuntimeException("field must be existed!");
        } else {
            this.field = ((TemplateModel) params.get("field")).toString();
        }

        if (null == params.get("title")) {
            throw new RuntimeException("title must be existed!");
        } else {
            this.title = ((TemplateModel) params.get("title")).toString();
        }

        if (null != params.get("hidden")) {
            this.hidden = Boolean.valueOf(((TemplateModel) params.get("hidden")).toString());
        }

        if (null != params.get("width")) {
            this.width = Integer.valueOf(((TemplateModel) params.get("width")).toString());
        }

        if (null != params.get("sortable")) {
            this.sortable = Boolean.valueOf(((TemplateModel) params.get("sortable")).toString());
        }

        col = "{field: '" + field + "', hidden: " + hidden + ", sortable: " + sortable + ", title: '" + title + "', width: " + width + "}";

        this.sortable = false;
        this.width = 20;
        this.hidden = false;
        out.write(col, 0, col.length());
        out.flush();
        out.close();
    }
}
