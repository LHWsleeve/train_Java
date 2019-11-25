package com.sxt.servlet;
/**
 * ServletContext对象：
 * 问题：如何获取在web，xm1中给每个serv1et单独配置的数据呢？
 * 解决：
 * 使用 ServletConfig对象
 * 使用：
 * 获取 Servletconfig对象获取web，xm1中的配置数据
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "ServletConfig",urlPatterns = "/config")
public class ServletConfig extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext对象
        javax.servlet.ServletConfig sc = this.getServletConfig();
 Enumeration<String> a = sc.getInitParameterNames();
    while (a.hasMoreElements()){
    System.out.println(a);
}
    }
}
