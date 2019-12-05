package com.guigu.factory;

import com.guigu.spring.Book;
import org.springframework.beans.factory.FactoryBean;

import java.util.UUID;

/**
 * 实现了FactoryBean接口的类是Spring可以认识的工厂类
 * Spring会自动的调用工厂方法创建实例
 * 1。编写FactoryBean的实现类
 * 2.在Spring中注册
 */
public class MyFactoryBeanImple implements FactoryBean<Book> {

    /**
     * getObject：工厂方法
     * @return创建的对象
     * @throws Exception
     */
    @Override
    public Book getObject() throws Exception {
        System.out.println("MyFactoryBean帮你创建对象");
        Book book = new Book();
        book.setBookName(UUID.randomUUID().toString());
        return book;
    }

    /**
     * 返回创建的对象的类型
     * Spring会自动调用这个方法来确认创建的对象是什么类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    /**
     * 是单例嘛？
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}