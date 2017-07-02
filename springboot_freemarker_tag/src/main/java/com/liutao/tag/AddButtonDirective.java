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
 * 新增按钮标签
 *
 * @author LIUTAO
 * @version 2017/6/27
 * @see
 */
@Component
public class AddButtonDirective implements TemplateDirectiveModel {
    private Logger logger = LoggerFactory.getLogger(AddButtonDirective.class);
    private String onclick = "addItem()";
    private String text = "新增";
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {
        Writer out = env.getOut();
        String addButton;
        //获取属性
        if (null != params.get("text")) {
            this.text = ((TemplateModel) params.get("text")).toString();
        }

        if (null != params.get("onclick")){
            this.onclick =  ((TemplateModel) params.get("onclick")).toString();
        }

        logger.debug("text:" + text);
        logger.debug("onclick:" + onclick);

        addButton = "<button type=\"button\" class=\"btn btn-primary\" onclick=\""+onclick+"\">"+text+"</button>";
        out.write(addButton);
    }
}
