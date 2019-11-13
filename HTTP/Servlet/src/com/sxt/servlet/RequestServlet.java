package com.sxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

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
        //获取请求行数据
           //获取指定请求行信息
     String value = req.getHeader("Host");
        System.out.println(value);
           //获取所有请求行的键的枚举
        Enumeration<String> e = req.getHeaderNames();
        while (e.hasMoreElements()){
            String name = e.nextElement();
            String value2 = req.getHeader(name);
            System.out.println(name+":"+value2);
        }
        //获取用户数据(浏览器请求服务器时会将post和get解析，实际二者一样)
        String name2 = req.getParameter("uname");//均用getParamter方法
        String pwd = req.getParameter("pwd");//getParamter不能获取通键不通值的多项选择，应使用getParamterValues，返回一个值数组
        System.out.println(name2+":"+pwd);
        //获取所有的用户请求数据的键的枚举 req.getParameterNames()
    }
}
