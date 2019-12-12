package com.guigu.springaop.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 何如将这个类(切面类)中的这些方法（通知方法）动态的在目标方法运行的各个位置切入
 *
 * 在通知方法运行的时候，拿到目标方法的详细信息。
 * 1.只需要为通知方法的参数列表上写一个参数，JoinPo,
 * JoinPoint joinPoint:封装了当前目标方法的详细信息。
 *
 */
@Aspect
@Component
public class LogUtils {
    /**
     *告诉Spring每个方法什么时候运行
     * @Before：在执行目标方法之前 ：前置通知
     * @After；目标方法彻底结束之后 ：后置通知
     * @AfterReturning;在目标方法执行结果return之后返回 ：返回通知
     * @AfterThrowing；目标方法抛出异常之后执行 ：异常通知
     * @Around：环绕 ：环绕通知
     *
     *
     * 抽取可重用的切入点表达式;
     * 1.随便声明一个没有实现的返回void的空方法
     * 2.加上@Pointcut
     *3.此时改一处就能改全部
     */
    @Pointcut("execution(public int com.guigu.springaop.impl.MyMath.*(int,int))")
    public void kechongyong(){

    }




     /**
     *
     * Spring对通知方法要求不严格：
     * 唯一要求的就是方法的参数列表一定不能乱写
     * 通知方法是 Spring利用反射调用的，每次方法调用得确定这个方法的参数表的值参数表上的每一个参数，Spring都得知道是什么？
     * pinPoint：认识
     *
     *
     */
    //想在执行目标方法之前执行.写切入表达式
    //execution（访问权限 返回值类型 方法签名）

    @Before(value = "kechongyong()")
    public static void logStart(JoinPoint joinPoint){
        //获取到目标方法运行时使用的参数
        Object[] args = joinPoint.getArgs();
        //获取到方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("方法开始执行，用的参数列表："+Arrays.asList(args)
        +"方法名："+name);
    }

    /**
     * 切入点表达式的写法：
     * 固定格式:execution（访问权限 返回值类型 方法签名（参数表））
     *  支持通配符：
     *      *：1.匹配一个或者多个字符
     *         2.匹配任意参数 （int,*）
     *         3.权限位置不能写*，public可写可不写，默认public
     *      ..:1.匹配任意多个，任意类型 (..)
     *         2.匹配任意多层路径 aa..bb,aa下的任意多层路径中的bb
     *  支持逻辑操作符：
     *  &&；||；!
     */


    //目标方法正常结束之后执行
    // 告诉Spring，result用来接收返回值 returning ="result
    @AfterReturning(returning ="result",value = "kechongyong()")
    public static void logReturn(JoinPoint joinPoint,Object result)
            {
                Signature signature = joinPoint.getSignature();
                String name = signature.getName();

                System.out.println(name+"方法执行完成，计算结果是："+result);
    }

// 目标方法出现异常时候执行
    // 告诉Spring，e用来接收异常 throwing = "e"
    //接受异常，异常类型要写大了。。所有都能接收到
    @AfterThrowing(throwing = "e",value = "kechongyong()")
    public static void logException(JoinPoint joinPoint, Exception e){
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name+"方法执行完成，计算结果是：");
    }
//目标方法完全结束之后执行
    @After(value = "kechongyong()")
    public static void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"方法彻底执行完毕");
    }


    /**
     * * @Around：环绕 ：环绕通知
     * 是最强大的通知。  环绕通知就是前面四种通知合体
     * 环绕通知中有一个参数，PreceddingJoinPont
     * @return
     */
    @Around("kechongyong()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //就是利用反射调用目标方法即可,就是method.invoke()
        Object[] args = proceedingJoinPoint.getArgs();
        Object proceed = proceedingJoinPoint.proceed(args);
        System.out.println("环绕结束hhhh");
        //反射调用后的返回值，要return
        return proceed;

    }
}
