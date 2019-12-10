package com.guigu.spring;

import static org.junit.Assert.assertTrue;

import com.guigu.spring.service.BookService;
import com.guigu.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void test()
    {
        BookService bookBean= ioc.getBean(BookService.class);
        UserService userBean = ioc.getBean(UserService.class);
        bookBean.save();
        userBean.save();
    }
}
