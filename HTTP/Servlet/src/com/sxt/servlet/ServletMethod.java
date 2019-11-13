package com.sxt.servlet;
/**
 * Service与doPost和doGet方法的区别
 * Service方法：可以接受get和post（如果同时存在三者，优先执行service）
 * doGet：只可以接受get的请求
 * doPost：值可以接受post的请求
 * 注意：如果在重写的service方法中调用了父类的service方法（spuer.service（xxx,xxx））
 *       则service方法处理完后，会再次根据请求方式响应doget或dopost。
 *      所以一般情况下，不在重写的service中保留super。
 * Servlet常见错误：
 * 404错误：资源未找到
 * 原因一：在请求地址中servlet的别名错误
 * 原因二：虚拟项目拼写错误
 * 500错误：内部服务器错误
 *      1.在web.xml中校验sevlet类的全限定路劲拼写错误
 *      2.service方法体执行代码逻辑存在逻辑错误
 * 405错误：请求方式不支持
 *      请求方式和servlet中的方法不匹配
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
