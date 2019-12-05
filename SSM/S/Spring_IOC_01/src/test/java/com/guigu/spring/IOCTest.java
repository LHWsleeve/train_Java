package com.guigu.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

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
        Person bean = (Person) ioc.getBean("person01");

        System.out.println(bean.toString());
//        Person bean03 = (Person) ioc.getBean("person03");
//        System.out.println(bean03.toString());
        Person bean03 = (Person) ioc.getBean("person06");
        System.out.println(bean03.toString());
    }
    @Test
    public void test02(){
        ApplicationContext ioc2 = new ClassPathXmlApplicationContext("ioc2.xml");
        Person ioc_bean01 = (Person) ioc2.getBean("person01");
        System.out.println(ioc_bean01.toString());
        System.out.println(ioc_bean01.getCar().toString());
        Car car = (Car) ioc2.getBean("car01");
        System.out.println(car==ioc_bean01.getCar());//这俩car其实是有个car，因为用的是引用ref
    }

    @Test
    public void test03(){
        ApplicationContext ioc2 = new ClassPathXmlApplicationContext("ioc2.xml");
        Person person = (Person) ioc2.getBean("person01");
        System.out.println(person.getCar().toString());
    }


    @Test
    public void test04() {
        ApplicationContext ioc2 = new ClassPathXmlApplicationContext("ioc2.xml");
        Person person = (Person) ioc2.getBean("person02");
        List<Book> books = person.getBooks();
        System.out.println(books);
    }

    /**
     * 级联属性因为使用的是引用，所以会修改被引用的属性
     */
    @Test
    public void test05() {
        ApplicationContext ioc2 = new ClassPathXmlApplicationContext("ioc2.xml");
        Person person = (Person) ioc2.getBean("person04");
        Map<String,Object> map = person.getMaps();
//        Car car = (Car) ioc2.getBean("car01");
//        System.out.println(car.toString());
        System.out.println(person.getCar().toString());
        Person person2 = (Person) ioc2.getBean("person06");
        System.out.println(person2.toString());

    }

    @Test
    public void test06() {
        System.out.println("容器启动完成");
        ApplicationContext ioc2 = new ClassPathXmlApplicationContext("ioc2.xml");
        ApplicationContext ioc3 = new ClassPathXmlApplicationContext("ioc3.xml");
        Book book01 = (Book) ioc2.getBean("book01");
    }

    @Test
    public void test07() {
        ApplicationContext ioc3 = new ClassPathXmlApplicationContext("ioc3.xml");
        System.out.println("容器启动完成");
//        Object bean = ioc3.getBean("airPlane01");
//        System.out.println(bean.toString());
        Object bean02 = ioc3.getBean("airPlane02");
        System.out.println(bean02);
    }

    @Test
    public void test08() {
        ApplicationContext ioc3 = new ClassPathXmlApplicationContext("ioc3.xml");
         Object bean = ioc3.getBean("myFactoryBeanImple");
        System.out.println(bean.toString());
    }
}