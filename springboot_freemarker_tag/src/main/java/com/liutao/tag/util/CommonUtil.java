package com.liutao.tag.util;

import org.springframework.cglib.beans.BeanMap;

import java.util.Map;

/**
 * tag工具类
 *
 * @author LIUTAO
 * @version 2017/7/2
 * @see
 * @since
 */
public class CommonUtil {

    /**
     * 将map转换成javaBean
     * @param map
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> T mapToBean(Map<String, Object> map, T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }
}
