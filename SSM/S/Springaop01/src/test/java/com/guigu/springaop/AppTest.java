package com.guigu.springaop;

import static org.junit.Assert.assertTrue;

import com.guigu.springaop.impl.MyMath;
import com.guigu.springaop.inter.Calculator;
import com.guigu.springaop.proxy.CalculatorProxy;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * 动态代理，日志强大，而且于业务逻辑解耦
     */
    @Test
    public void aoptest01()
    {
        Calculator calculator = new MyMath();
        calculator.add(1,2);
        System.out.println("=============");
        //如果拿到了这个对象的代理对象，代理对象执行加减乘除；
        Calculator proxy = CalculatorProxy.getProxy(calculator);
        proxy.add(4,5);
        //class com.sun.proxy.$Proxy4<---是代理对象的真实类。
        //代理对象和被代理对象必须靠实现同一个接口(Calculator)来产生关联.:[interface com.guigu.springaop.inter.Calculator]
        System.out.println(proxy.getClass());
        System.out.println(Arrays.asList(proxy.getClass().getInterfaces()));

    }
}
