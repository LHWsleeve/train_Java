package com.guigu.tx;

import static org.junit.Assert.assertTrue;

import com.guigu.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicateionContext.xml");

    @Test
    public void  test01() throws InterruptedException {
        BookService bean = ioc.getBean(BookService.class);
        bean.check("Tom","ISBN-001");

    }
}
