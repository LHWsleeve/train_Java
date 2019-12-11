package com.guigu.springaop.impl;

import com.guigu.springaop.inter.Calculator;

public class MyMath implements Calculator {
    @Override
    public int add(int i, int j) {
//        System.out.println("add方法开始了");
//        System.out.print("add方法完成:i+j=");
//        System.out.println(i+j);

        return i+j;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("sub方法开始了");
        return i-j;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("mul方法开始了");
        return i*j;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("div方法开始了");
        return i/j;
    }
}
