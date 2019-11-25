package com.sxt.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * servletcontext：
 * 问题：不同的用户使用相同的数据
 * 解决：
 * servletcontext对象
 * 特点：
 * 服务器创建
 * 用户共享
 * 作用域：
 * 整个项目内
 * 使用：
 * 创建servletcontext对象sc(三种)
 * 使用servletContxt对象完成数据共享：
 * 数据存储：
 * sc.setAttribute (String name, object value)
 *数据获取
 *           *sc.getAttribute（"str"）返回的是 object类型
 *          注意：不同的用户可以给 Servletcontext对象进行数据的存取。
 *          获取的数据不存在返回null
 * 获取项目中web.xml文件中的全局配置数据
 */
@javax.servlet.annotation.WebServlet(name = "ServletContextServlet",urlPatterns = "/context")
public class ServletContextServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//获取servletcontext对象
        //1.
        ServletContext sc = this.getServletContext();
        //2.
        ServletContext sc2 = this.getServletConfig().getServletContext();
        //3.
        ServletContext sc3 = req.getSession().getServletContext();
        System.out.println(sc==sc2);
        System.out.println(sc==sc3);
        //使用servletContext对象完成数据共享
            //数据存储
        sc.setAttribute("str","ServletContext对象学习");
        //获取服务器信息
        String str = sc.getServerInfo();
        System.out.println(str);
        //动态获取项目根目录下的资源绝对路径
        String path = sc.getRealPath("/doc/1.txt");
        System.out.println(path);
        //获取项目根目录下的资源的流对象
       InputStream is =  sc.getResourceAsStream("/doc/1.txt");

    }
}
