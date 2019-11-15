package com.sxt.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetCookieServlet",urlPatterns = "/gc")
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
       Cookie[] cks = req.getCookies();
       if (cks!=null) {//判断Cookie是否为Null
           for (Cookie c : cks) {
               String name = c.getName();
               String value = c.getValue();
               System.out.println(name + ":" + value);
           }
       }
    }
}
