package com.sxt.ServletLogin;


import com.sxt.pojo.User;
import com.sxt.service.LoginService;
import com.sxt.service.impl.LoginSerivceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        String uname = req.getParameter("uname");
       String pwd = req.getParameter("pwd");
        System.out.println(uname+":"+pwd);
        //处理请求信息
            //获取业务层对象
        LoginService ls = new LoginSerivceImpl();
        User u = ls.checkLoginService(uname,pwd);

        System.out.println(u);

        //响应处理结果
        if (u!=null){
            resp.getWriter().write("登陆成功");
        }else {
//            resp.getWriter().write("登陆失败");
            System.out.println("登陆失败");
            //使用request对象实现不同Servlet的数据流转
            req.setAttribute("str","用户名或密码错误");
            //使用请求转发回到登陆页面
            req.getRequestDispatcher("page").forward(req,resp);
            return;
        }

    }
}
