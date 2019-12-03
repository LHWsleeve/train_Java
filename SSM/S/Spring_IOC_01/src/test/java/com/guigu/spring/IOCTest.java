package com.guigu.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 存在的几个问题：
 * 1.target是类路径的开始，所有源码包和资源包的内容都放入里面
 */
public class IOCTest {
    //从容其中拿到组件
    @Test
    public void test() {
        //ApplicationContext代表ioc容器
        //ClassPathXmlApplicationContext：当前应用的xml配置文件在ClassPath下
        //根据Spring的配置文件得到ioc容器对象
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
        //容器中对象的创建，在容器启动完成的的时候就已经创建。即，先创建所有再启动容器
        //同一个组件在ioc容器中是单实例的。
        //容器中如果没有这个组件，报异常
        //ioc容器在创建组件的时候会利用setter方法为javaBean赋值。
        //JavaBean的属性名是由getter/setter方法决定的（去掉set和get后面部分改小字母）。所有getter/setter自动生成。
//        Person bean = (Person) ioc.getBean("person01");

//        System.out.println(bean.toString());
        Person bean03 = (Person) ioc.getBean("person03");
        System.out.println(bean03.toString());

    }
}
