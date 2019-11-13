package com.sxt.servlet;
/**
 * Service与doPost和doGet方法的区别
 * Service方法：可以接受get和post（如果同时存在三者，优先执行service）
 * doGet：只可以接受get的请求
 * doPost：值可以接受post的请求
 * 注意：如果在重写的service方法中调用了父类的service方法（spuer.service（xxx,xxx））
 * 则service方法处理完后，会再次根据请求方式响应doget或dopost。
 * 所以一般情况下，不在重写的service中保留super。
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletMethod",urlPatterns = "/method")
public class ServletMethod extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我是doGet");
    }
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("我是servicce");
//    }
}
