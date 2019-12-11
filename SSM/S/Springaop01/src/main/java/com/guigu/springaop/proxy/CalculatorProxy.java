package com.guigu.springaop.proxy;

import com.guigu.springaop.inter.Calculator;
import com.guigu.springaop.utils.LogUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 生辰给代理对象
 * Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
 */
public class CalculatorProxy {
    /**
     * 为传入的参数对象创建一个动态代理对象
     * @param calculator:传入的是被代理对象
     * @return 返回的代理对象
     */
    public static Calculator getProxy(final Calculator calculator) {
        //方法执行器。帮我们目标对象执行方法
        InvocationHandler h = new InvocationHandler() {
            /**
             *
             * @param proxy 这个是代理对象，给jdk使用，任何时候都不要动这个对象
             * @param method 当前将要执行那个的目标对象方法
             * @param args 这个方法调用时外交传入的参数值
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("这是动态代理帮你执行方法");
                Object result = null;
                //利用反射执行目标方法
                try {
                    LogUtils.logStart(method,args);
                    result =  method.invoke(calculator,args);
                    LogUtils.logReturn(method,result);
                }catch (Exception e){
                    LogUtils.logException(method,result);
                }finally {
                    System.out.println(method.getName()+"方法结束");
                }

                //执行后返回
                return result;
            }
        };
        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        ClassLoader classLoader = calculator.getClass().getClassLoader();
        //Proxy为目标创建代理对象
        Object proxy = Proxy.newProxyInstance(classLoader,interfaces,h);
        return (Calculator) proxy;
    }
}
