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
        // 注意：如果想要用类型，一定用他的接口类型，不要用它本类
        //AOP的底层就是动态代理,！容器中保存的组件是他的代理对象！：class com.sun.proxy.$Proxy23
       //并且按照名称取bean的时候不能类型不能是本类，必须是接口类
        Calculator bean = ioc.getBean(Calculator.class);
        bean.add(1,12);
        System.out.println(bean.getClass());


    }

    @Test
    public void aoptest03()
    {
        //没有实现接口
        //此时class com.guigu.springaop.impl.MyMath$$EnhancerBySpringCGLIB$$ce543e30。
        //cglib帮我们创建了代理对象
        //按照名称取bean的时候可以是本类
        MyMath myMath = ioc.getBean(MyMath.class);
        myMath.add(1,5);
        System.out.println(myMath.getClass());
    }


    /**
    try {
       @Before
        method. invoke(obj, args)
       @AfterReturning
    }catch(){
     @AfterThrowing
    }finally{
    @After
    }
     *
     * 通知方法的执行顺序
     * 正常执行：@Before前置通知---->@After（后置）--->@AfterReturning（正常）
     * 异常执行：@Before前置通知---->@After（后置）---> @AfterThrowing（异常）
     */
    @Test
    public void aoptest04()
    {
        MyMath myMath = ioc.getBean(MyMath.class);
        myMath.add(1,4);
        System.out.println("=====================");
        myMath.div(1,4);

    }

    /**
     * 测试环绕
     * 如果环绕通值和普通通知共存，会混乱。
     * 环绕通知会优先于普通通知执行，执行顺序：
     * 环挠通知：是优先于苷通通知执行，执行顾序
     * [普通前置]
     * {
     * 环绕前置
     * try{
     *      环绕前宣
     *      环绕执行：目标方法执行
     *      环绕返回/出现异常
     * }Caych{
     *      环绕出现异常
     * }finally{
     *      环绕后置
     * }
     * 环绕执行：目标方法执行
     * 环绕返回/出现异常
     * 环统后置
     * }
     * [昔通后置]
     * [普通方法返回/方法异常]
     *
     * 新的顺序：
     *      环绕前置---普通前置----目标方法执行---环绕正常返回出现异常-环绕后置-通后置--昔通返回或者异常
     */
    @Test
    public void aoptest05()
    {
        MyMath myMath = ioc.getBean(MyMath.class);
        myMath.add(1,4);
    }
}
