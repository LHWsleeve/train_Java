package com.guigu.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest
{
    ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    /**
     * 单例Bean的生命周期：(容器启动)构造器-->初始化方法-->容器关闭（进行销毁）
     *      * 多实例Bean的生命周期：(获取对象时候)构造器-->初始化方法-->容器关闭（不会销毁）
     */
    @Test
    public void test01(){
        Book book = (Book) ioc.getBean("book01");

        ioc.close();
        //        Object bean = ioc.getBean("book01");
    }
}
