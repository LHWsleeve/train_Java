package com.guigu.spring03;

import static org.junit.Assert.assertTrue;

import com.guigu.dao.BookDao;
import com.guigu.servlet.BookServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     *使用注解和使用配置方式加入容器中的组件的行为都是一样的。
     */
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void test01()
    {
       BookDao bean = (BookDao) ioc.getBean("bookDao");
        BookDao bean2 = (BookDao) ioc.getBean("bookDao");
        System.out.println(bean==bean2);
    }

    /**
     * 属性自动注入
     */
    @Test
    public void test02()
    {
      BookServlet bookServlet = ioc.getBean(BookServlet.class);
      bookServlet.Do();
    }
}
