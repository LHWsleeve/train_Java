package com.guigu.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1.实现接口
 * 2.在springmvc配置文件中，注册这个拦截器
 *          需要配置这个拦截器拦截那些请求
 *
 */
public class MyfirstInterceptor implements HandlerInterceptor {
    /**
     * 目标方法运行之前运行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.format("MyFirstInterceptor...preHandle\n");
        return true;//true==放行
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.format("MyFirstInterceptor...postHandle\n");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.format("MyFirstInterceptor...afterCompletion\n");

    }
}
