package com.sxt.servlet;

import com.sxt.pojo.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MyServlet",urlPatterns = "/main")
public class MyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //设置请求编码格式,tomcat9.0之后默认utf-8
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
            //获取session中的数据
        User u = (User) req.getSession().getAttribute("user");
        ServletContext sc= this.getServletContext();
        String b = (String) sc.getAttribute("nums");
        int count = (int) sc.getAttribute("count");
        //处理请求信息
        //响应处理结果
        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("<h3>欢迎"+u.getName()+"访问</h3>");
        resp.getWriter().write("当前网页浏览次数为:"+b);
        resp.getWriter().write("当前在线人数为:"+count);

        resp.getWriter().write("<hr>");
        resp.getWriter().write("<form action='show' method='get'>");
        resp.getWriter().write("<input type='submit' value='查看个人信息'>");
        resp.getWriter().write("</form>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");
    }
}
