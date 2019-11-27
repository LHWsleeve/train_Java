package com.sxt.servlet;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener("com.sxt.servlet.MyL")
public class MyL implements ServletRequestListener, HttpSessionListener, ServletContextAttributeListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("我Myl被销毁");
    }
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("MyL我被创建");

    }

    //监听session的创建
    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }
//session的销毁
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {

    }
}
