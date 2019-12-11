package com.guigu.springaop;

import com.guigu.springaop.impl.MyMath;
import com.guigu.springaop.inter.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Unit test for simple App.
 */
public class AopTest
{
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    /**
     */
    @Test
    public void aoptest02()
    {
        //从ioc容器中拿到目标对象；
        // 注意：如果想要用类型，一定用他的接口类型，不要用它本类       myMath = ioc.getBean()
        Calculator bean = ioc.getBean(Calculator.class);
        bean.add(1,12);

    }
}
