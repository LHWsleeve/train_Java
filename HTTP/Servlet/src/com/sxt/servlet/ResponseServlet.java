package com.sxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Respene
 * 作用：用来响应数据到浏览器的一个对象
 * 使用：
 * 设置响应头
 * 设置相应实体
 */
@WebServlet(name = "ResponseServlet",urlPatterns = "/res")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求信息
          //获取请求头
          //获取请求行
          //获取用户数据
        //处理请求

        //响应处理结果
           //设置响应投
        resp.setHeader("mouse","xxxxx");//在响应头中set会覆盖同键值，add不会
        resp.addHeader("key","bbbb");
           //设置响应状态码
//        resp.sendError(404,"sorry");
           //设置相应实体
        resp.getWriter().write("<b>bu neng xie zhong wen</b>");
    }
}
