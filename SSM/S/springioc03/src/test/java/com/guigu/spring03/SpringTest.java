package com.guigu.spring03;

import com.guigu.dao.BookDao;
import com.guigu.servlet.BookServlet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring单元测试
 * 1、导包；Spring单元测试包 spring-test(Maven)
 * 2、@Context Configuration（locations=""）使用它来指定 Spring的配置文件的位置
 * 3.#RunWith指定用那种驱动进行单元测试，默认junit
 *      @RunWith(SpringJUnit4ClassRunner.class):
 *      使用Spring单元测试模块来执行标了@Test注解的测试方法；
 *      以前@Test的方法是由junit方法测试的，现在由Spring测试
 * 优点：不需要手动创建对象，Spring全都自动装配
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml" )
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {
    ApplicationContext ioc = null;
    @Autowired
    BookServlet bookServlet;
    @Autowired
    BookDao bookDao;

    @Test
    public void test(){
        System.out.println(bookDao);
    }
}
