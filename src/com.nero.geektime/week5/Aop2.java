package com.nero.geektime.week5;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class Aop2 {

    @Pointcut(value = "execution(* com.nero.geektime.*.Klass.*dong(..))")
    public void point() {

    }

    //前置通知
    @Before(value = "point()")
    public void before() {
        System.out.println("begin klass dong...");
    }

    //后置通知
    @After(value = "point()")
    public void after() {
        System.out.println("after klass dong...");
    }

    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around begin klass dong");
        joinPoint.proceed();
        System.out.println("around after klass dong");
    }
}
