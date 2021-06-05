package com.nero.geektime.week5;

import org.aspectj.lang.ProceedingJoinPoint;

public class Aop1 {
    //前置通知
    public void startTransaction() {
        System.out.println("begining ding...");
    }

    //后置通知
    public void commitTransaction() {
        System.out.println("finish ding...");
    }

    //环绕通知
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around begin ding");
        //执行process()方法才真正执行实际被代理的方法
        joinPoint.proceed();
        System.out.println("around finish ding");
    }
}
