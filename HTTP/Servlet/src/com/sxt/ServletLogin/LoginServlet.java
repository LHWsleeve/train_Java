package com.sxt.ServletLogin;

/**
 * 使用ServletContext对象完成网页计数器
 * 在用户登陆较严重创建计数器并实现自增-->存储到ServletContext中
 * 在主页面取出计数器数据，显示给用户
 */

import com.sxt.pojo.User;
import com.sxt.service.LoginService;
import com.sxt.service.impl.LoginSerivceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
//            req.getRequestDispatcher("main").forward(req,resp);
            //创建Cookie信息实现三天免登录
            Cookie c = new Cookie("Id",u.getId()+"");
            c.setMaxAge(3*24*3600);
            c.setPath("/login/ck");//路径一定要正确。
            resp.addCookie(c);
            //将数据存储到session对象中
            HttpSession hs = req.getSession();
            hs.setAttribute("user",u);
            //获取计数器
            ServletContext sc = this.getServletContext();
            //判断第一次
            if (null != sc.getAttribute("nums")){
                String nums = String.valueOf( Integer.parseInt(String.valueOf((String)sc.getAttribute("nums")))+1);
                sc.setAttribute("nums",nums);
            }else{
                sc.setAttribute("nums",1);
            }

            //重定向
            resp.sendRedirect("/login/main");
            return;
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
