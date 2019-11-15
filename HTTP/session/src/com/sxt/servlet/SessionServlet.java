package com.sxt.servlet;

import org.apache.catalina.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * session：一个用户的不同请求处理的数据共享
 * 方法：手使用session技术
 * 原理：用户第一次访问服务器，服务器创建一个session对象给此用户，并将改session对象的JSESSIONID使用cookie
 * 技术存储到浏览器中，保证用户的其他请求能够获取到同一个session对象，也保证了不同请求能够获取到共享的数据。
 *特点：
 * 存储在服务器端
 * 服务器进行创建
 * 依赖Cookie技术
 * Session的有效期：一次会话
 * 作用：解决了一个用户不同请求处理的数据共享问题
 *使用：创建session/获取session对象
 * HttpSession hs = req.getSession()：
 *      如果请求中拥有session的标识符=JSESSIONID则返回其对应的Session对象
 *      如果请求中没有标识符，则创建新的Session对象并将其JSESSIONID作为Cookie数据存储到浏览器
 *      如果session对象失效，重新创建对象并将其存入Cookie
 *      默认存储时间是30min
 *
 * 设置session存储时间：
 *      hs.setMaxInactiveInterval(5);
 *      ※销毁时间为：再指定的时间内Session对象没有被使用则销毁，若使用，重新计时。
 *设置Session强制失效：
 *
 *
 * 注意：JSESSIONID存储在了Cookie临时空间中，浏览器关闭即失效
 */

@javax.servlet.annotation.WebServlet(name = "SessionServlet",urlPatterns = "/ss")
public class SessionServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String name = "张三";
        //创建session对象（如果有session返回原session，若没有随机生成一个新的）
        HttpSession hs = req.getSession();//1.判断是否有session，创建session，2.创建cookie，3.把session加入cookie
//        hs.setMaxInactiveInterval(5);
        System.out.println(hs.getId());
//设置Sesion强制失效
        hs.invalidate();//立马失效
        resp.getWriter().write("session信息");

    }
}
