package com.guigu.spring;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class IOCTest
{
    ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext03.xml");

    /**
     * 单例Bean的生命周期：(容器启动)构造器-->xml中init-method初始化方法-->容器关闭（进行销毁）
     * 多实例Bean的生命周期：(获取对象时候)构造器-->初始化方法-->容器关闭（不会销毁）
     * 单实例后置处理器的Bean生命周期：容器启动，构造器启动---后置处理器before---初始化方法--后置处理器after--初始化完成--销毁
     *无论Bean是否有初始化方法，都会执行。如果没有自定义init-method方法，也会执行后置处理器
     */
    @Test
    public void test01(){
//        Book book = (Book) ioc.getBean("book01");

        ioc.close();
        //        Object bean = ioc.getBean("book01");
    }

    @Test
    public void test02() throws SQLException {
        //从容器中拿到连接池
            //按照id获取
//        DataSource conn = (DataSource) ioc.getBean("pooledDataSource");
        //xml中只有一个该类型的时候，按照类型获取组件，可以获取到这个类型下的所有实现类子类
        DataSource bean = ioc.getBean(DataSource.class);
        System.out.println(bean.getConnection());//拿到链接
        Car bean2 = ioc.getBean(Car.class);
        System.out.println(bean2);
    }


    @Test
    public void test03(){
        Person bean = (Person) ioc.getBean("person01");
        System.out.println(bean);
    }
}
