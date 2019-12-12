package com.guigu.springaop.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Order(1)//使用order改变执行顺序
public class ValidateAspect {
    @Before("com.guigu.springaop.utils.LogUtils.kechongyong()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(":VA方法开始执行，用的参数列表："+ Arrays.asList(args)
                +"方法名："+name);
    }
    @AfterReturning(value = "com.guigu.springaop.utils.LogUtils.kechongyong()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result)
    {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name+":VA方法执行完成，计算结果是："+result);
    }

    @AfterThrowing(value = "com.guigu.springaop.utils.LogUtils.kechongyong()",throwing ="e")
    public void logException(JoinPoint joinPoint, Exception e){
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name+":VA方法执行完成，计算结果是：");
    }

    @After("com.guigu.springaop.utils.LogUtils.kechongyong()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+":VA方法彻底执行完毕");
    }
}
