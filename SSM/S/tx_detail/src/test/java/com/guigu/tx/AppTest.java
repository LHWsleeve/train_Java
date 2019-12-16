package com.guigu.tx;

import static org.junit.Assert.assertTrue;

import com.guigu.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 有事物的业务逻辑，容器中保存的是这个业务逻辑的代理对象。
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
