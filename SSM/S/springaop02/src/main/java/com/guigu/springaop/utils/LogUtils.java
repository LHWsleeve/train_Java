package com.guigu.springaop.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 何如将这个类(切面类)中的这些方法（通知方法）动态的在目标方法运行的各个位置切入
 */
@Aspect
@Component
public class LogUtils {
    /**
     *告诉Spring每个方法什么时候运行
     *
     *
     * @Before：在执行目标方法之前 ：前置通知
     * @After；目标方法彻底结束之后 ：后置通知
     * @AfterReturning;在目标方法执行结果return之后返回 ：返回通知
     * @AfterThrowing；目标方法抛出异常之后执行 ：异常通知
     * @Around：环绕 ：环绕通知
     */
    //想在执行目标方法之前执行.写切入表达式
    //execution（访问权限 返回值类型 方法签名）
    @Before("execution(public int com.guigu.springaop.impl.MyMath.*(int,int))")
    public static void logStart(){
        System.out.println("方法开始执行，用的参数列表：");
    }

    //目标方法正常结束之后执行
    @AfterReturning("execution(public int com.guigu.springaop.impl.MyMath.*(int,int))")
    public static void logReturn()
            {
        System.out.println("方法执行完成，计算结果是：");
    }

// 目标方法出现异常时候执行
    @AfterThrowing("execution(public int com.guigu.springaop.impl.MyMath.*(int,int)  )")
    public static void logException(){
        System.out.println("方法执行完成，计算结果是：");
    }
//目标方法完全结束之后执行
    @After("execution(public int com.guigu.springaop.impl.MyMath.*(int,int))")
    public static void logEnd(){
        System.out.println("方法彻底执行完毕");
    }
}
