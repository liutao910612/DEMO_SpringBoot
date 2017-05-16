package com.liutao.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 错误拦截器
 *
 * @author LIUTAO
 * @version 2017/5/5
 * @see
 * @since
 */
public class ErrorInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(ErrorInterceptor.class);
    /**
     * 进行处理器拦截
     * 本方法主要针对Controller，实在处理之前进行的。可以同时多个拦截器存在，然后在调用的时候一次调用每个拦截器。
     * 注意：当此方法返回false的时候将会中断整个请求，仅仅当返回true的时候请求才能继续进行。
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.debug("enter the preHandle of errorInterceptor");

        //这里可以对请求的参数和地址进行相关的处理
        return true;
    }

    /**
     * 进行处理器拦截
     * 这个方法只有当preHandle返回true的时候才能够执行，是在Controller处理后进行拦截处理的，也就是是对返回的
     * ModelAndView进行处理的。但是该处理实在视图渲染前进行的
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.debug("处理是在Controller处理之后，但是在视图渲染前进行的");
        int status = httpServletResponse.getStatus();
        if (status == 500){
            modelAndView.setViewName("errorPage/500");
        }else if (status == 404){
            modelAndView.setViewName("errorPage/404");
        }
    }

    /**
     * 进行资源的处理
     * 该方法实在试图渲染完成后进行的，当然也需要preHandle方法返回true才能执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.debug("视图渲染后执行，多用于清理资源");
    }
}
