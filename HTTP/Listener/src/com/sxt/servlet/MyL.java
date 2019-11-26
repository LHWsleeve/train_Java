package com.sxt.servlet;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener("com.sxt.servlet.MyL")
public class MyL implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("我Myl被销毁");
    }
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("MyL我被创建");

    }
}
