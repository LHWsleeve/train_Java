package com.sxt.servlet;
/**
 * servlet生命周期
 * 1.从第一次调用到服务器关闭
 * 2.若servlet配置了load-on-startup，则生命周期为从服务器启动到服务器关闭
 * 注意：init方法是对servlet进行初始化的一个方法，会在servlet第一次加载如内存时执行
 * desytroy方法是服务器关闭时执行
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletLife",urlPatterns = "/life",loadOnStartup = 1)
public class ServletLife extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
//真正处理请求的方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("yemian sheng cheng servlert");
        System.out.println("servlet");
    }

    //初始化方法，在Servlet第一次加载内容的时候被调用
    @Override
    public void init() throws ServletException {
        System.out.println("初始化");
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
