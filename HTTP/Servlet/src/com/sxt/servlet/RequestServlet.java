package com.sxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RequestServlet",urlPatterns = "/req")
public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * request对象中封存了当前请求的所有信息
     * 使用：获取请求头数据/行数据/用户数据
     * 注意：resquest对象由tomcat服务器创建，并作为实参传递给处理请求的servlet的service方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求头包括以下：
        //获取请求方式
        String method = req.getMethod();
        System.out.println(method);
        //获取请求URL
        StringBuffer url = req.getRequestURL();
        System.out.println(url);
        String uri = req.getRequestURI();
        System.out.println(uri);
        //获取协议
        String h = req.getScheme();
        System.out.println(h);
    }
}
