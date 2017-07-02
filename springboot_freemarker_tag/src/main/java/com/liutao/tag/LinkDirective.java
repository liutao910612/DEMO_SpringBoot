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
 * 超链接标签
 *
 * @author LIUTAO
 * @version 2017/6/28
 * @see
 * @since
 */
@Component
public class LinkDirective implements TemplateDirectiveModel {
    private Logger logger = LoggerFactory.getLogger(LinkDirective.class);
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {
        String href = "#";  //链接地址
        String text;        //文本内容
        String onclick = "";     //方法
        Writer out = env.getOut();
        String a;
        //获取属性
        if (null == params.get("text")) {
            throw new RuntimeException("text must be existed!");
        } else {
            text = ((TemplateModel) params.get("text")).toString();
        }

        if (null != params.get("href")){
            href = ((TemplateModel) params.get("href")).toString();
        }

        if (null != params.get("onclick")){
            onclick = ((TemplateModel) params.get("onclick")).toString();
        }

        logger.debug("href:" + href);
        logger.debug("text:" + text);
        logger.debug("onclick:" + onclick);


        a = "<a href='"+href+"' onclick='"+onclick+"'>"+text+"</a>";
        out.write(a, 0, a.length());
        out.flush();
        out.close();
    }
}
