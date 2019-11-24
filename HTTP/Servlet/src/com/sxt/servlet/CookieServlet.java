package com.sxt.servlet;

import com.sxt.pojo.User;
import com.sxt.service.LoginService;
import com.sxt.service.impl.LoginSerivceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie信息校验
 * 判断请求中是否携带正确Cookie信息
 * 若错误则请求转发给登陆页面
 * 若正确直接响应主页面给用户
 * 若每日有Cookie则请求转发给登陆页面
 */
@WebServlet(name = "CookieServlet", urlPatterns = "/ck")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Cookie[] cks = req.getCookies();
        if (cks!=null){
            //遍历Cookie信息
            String Id = "";
            for(Cookie c:cks){
                if ("Id".equals(c.getName())){
                    Id = c.getValue();
                }
            }
            //校验Id是否存在
            if ("".equals(Id)){
                req.getRequestDispatcher("page").forward(req,resp);
            }else {
                //校验Id用户信息
                //获取业务层对象
                LoginService ls = new LoginSerivceImpl();
                User u = ls.checkLoginService(Id);
                System.out.println(u);
                System.out.println(Id);
                if (u!=null){
                    //将用户数据存储到session中
                    req.getSession().setAttribute("user",u);
                    resp.sendRedirect("/login/main");
                    return;
                }else {
                    req.getRequestDispatcher("page").forward(req,resp);

                }
            }
        }else {
            req.getRequestDispatcher("page").forward(req,resp);
        }
    }
}
