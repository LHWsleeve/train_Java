package com.sxt.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletContext2",urlPatterns = "/context2")
public class ServletContext2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建servletcontext对象
        ServletContext sc = this.getServletContext();
        //获取对象
        System.out.println("ServletContext2:"+sc.getAttribute("str"));
    }
}
