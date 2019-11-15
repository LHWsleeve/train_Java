package com.sxt.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *Cookie：解决发送不同请求的数据共享问题
 * 使用：1.创建Cookie对象
 * 2.响应Cookie信息给客户端
 * 注意：一个Cookie对象顿出一条数据，多条数据。创建多个Cookie
 * 特点：浏览器端的数据存储技术
 * 存储的数据声明在服务器端，只有访问带有Cookie的浏览器才能存储Cookie
 * 临时存储：存储在浏览器的运行内存中，浏览器关闭即失效。
 * 定时存储：存储一次Cookie后，Cookie有效期存储在客户端硬盘内。在有效期内，符合路径要求的请求都会附带该信息
 *默认Cookie信息存储好之后，每次请求都会附带，除非设置有效路径。
 */
@WebServlet(name = "CookieServlet",urlPatterns = "/ck")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //取请求信息
        //处理请求信息
        //响应处理结果
        //使用Cookie进行浏览器端的数据存储
        Cookie c = new Cookie("mouse","errerewtg");
        Cookie c2 = new Cookie("23","er32423423432rerewtg");
        //设置Cookie+有效期
        //设置有效路径
        c2.setMaxAge(3*24*3600);
        c2.setPath("/Cookie/gc");
        resp.addCookie(c2);
        //响应Cookie信息
        resp.addCookie(c);
        //直接响应
        resp.getWriter().write("COOkie学习");
        //请求转发
        //重定向

    }
}
