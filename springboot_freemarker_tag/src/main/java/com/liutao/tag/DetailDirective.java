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
 * 详情标签
 *
 * @author LIUTAO
 * @version 2017/6/27
 * @see
 */
@Component
public class DetailDirective implements TemplateDirectiveModel {
    private Logger logger = LoggerFactory.getLogger(DetailDirective.class);
    private StringBuffer bodyStr = new StringBuffer("");

    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {
        Writer out = env.getOut();
        String id = ((TemplateModel) params.get("id")).toString();
        logger.debug("id:" + id);
        bodyStr = new StringBuffer("");
        //判断是否有非空的嵌入体
        if (body != null) {
            body.render(new DetailDirective.BodyWriter(out));
            String detailStr = getDetailString(id,bodyStr.toString()).toString();
            out.write(detailStr);
        } else {
            throw new RuntimeException("missing body");
        }
    }

    /**
     * 构建详细信息
     * @param id
     * @param detail
     * @return
     */
    private StringBuffer getDetailString(String id, String detail) {
        StringBuffer detailStr = new StringBuffer("");
        detailStr.append("<div class=\"easyui-tabs\" id=\"infoDetail\" style=\"width:auto;height:auto;margin-top: 20px;\">\n");
        detailStr.append(detail);
        detailStr.append("</div>");
        return detailStr;
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
