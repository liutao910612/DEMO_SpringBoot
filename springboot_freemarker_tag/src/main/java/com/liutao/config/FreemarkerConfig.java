package com.liutao.config;

import com.liutao.tag.*;
import freemarker.template.Configuration;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * freemarker标签配置
 *
 * @author LIUTAO
 * @version 2017/6/27
 * @see
 */
@Component
public class FreemarkerConfig {

    @Autowired
    private Configuration configuration;
    @Autowired
    private DataGridDirective dataGridDirective;
    @Autowired
    private ColDirective colDirective;
    @Autowired
    private DetailDirective detailDirective;
    @Autowired
    private LinkDirective linkDirective;
    @Autowired
    private OperateDirective operateDirective;
    @Autowired
    private AddButtonDirective addButtonDirective;
    @Autowired
    private DeleteButtonDirective deleteButtonDirective;
    @Autowired
    private TreeGridDirective treeGridDirective;

    @PostConstruct
    public void setSharedVariable() throws TemplateModelException {
        configuration.setSharedVariable("dataGrid", dataGridDirective);
        configuration.setSharedVariable("col", colDirective);
        configuration.setSharedVariable("detail", detailDirective);
        configuration.setSharedVariable("link", linkDirective);
        configuration.setSharedVariable("operate", operateDirective);
        configuration.setSharedVariable("addButton", addButtonDirective);
        configuration.setSharedVariable("deleteButton", deleteButtonDirective);
        configuration.setSharedVariable("treeGrid", treeGridDirective);
    }

}