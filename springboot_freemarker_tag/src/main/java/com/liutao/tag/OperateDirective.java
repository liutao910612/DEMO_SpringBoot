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
 * 数据操作
 *
 * @author LIUTAO
 * @version 2017/6/27
 * @see
 */
@Component
public class OperateDirective implements TemplateDirectiveModel {
    private Logger logger = LoggerFactory.getLogger(OperateDirective.class);
    private StringBuffer bodyStr = new StringBuffer("");
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {
        Writer out = env.getOut();
        String field;
        String title;
        int width = 80;

        if (null == params.get("field")) {
            throw new RuntimeException("field must be existed!");
        } else {
            field = ((TemplateModel) params.get("field")).toString();
        }

        if (null == params.get("title")) {
            throw new RuntimeException("title must be existed!");
        } else {
            title = ((TemplateModel) params.get("title")).toString();
        }

        if (null!=params.get("width")){
            width = Integer.valueOf(((TemplateModel) params.get("width")).toString());
        }

        logger.debug("field:" + field);
        logger.debug("title:" + title);
        logger.debug("width:" + width);
        bodyStr = new StringBuffer("");
        //判断是否有非空的嵌入体
        if (body != null) {
            logger.debug("begin bodywriter");
            body.render(new BodyWriter(out));
            String tableStr = getOperateString(field, title,width, bodyStr.toString()).toString();
            out.write(tableStr);
        } else {
            throw new RuntimeException("missing body");
        }
    }

    /**
     * 构建operate
     * @param field
     * @param title
     * @param width
     * @param col
     * @return
     */
    private StringBuffer getOperateString(String field, String title,int width, String col) {
        StringBuffer sb = new StringBuffer();
        sb.append("{\n");
        sb.append("field: '"+field+"', width: "+width+", align: 'center', formatter: function (value,row,index) {\n");
        sb.append("return \"");
        sb.append(col);
        sb.append("\"\n");
        sb.append("}, title: '"+title+"'\n");
        sb.append("}");
        return sb;
    }

    /**
     * 输出内部类
     */
    private class BodyWriter extends Writer {
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

            logger.debug("get tableStr begin");
            bodyStr.append(String.valueOf(chars))
                    .append("&nbsp;&nbsp;");
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
