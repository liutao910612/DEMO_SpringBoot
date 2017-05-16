package com.liutao.config;

import com.liutao.interceptor.ErrorInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 拦截器配置类
 *
 * @author LIUTAO
 * @version 2017/5/5
 * @see
 * @since
 */

@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){

        //多个拦截器组成一个拦截器链
        //addPathPatterns 用于添加拦截规则
        //excludePathPatterns用于排除拦截规则
        interceptorRegistry.addInterceptor(new ErrorInterceptor()).addPathPatterns("/**");
        super.addInterceptors(interceptorRegistry);
    }
}
