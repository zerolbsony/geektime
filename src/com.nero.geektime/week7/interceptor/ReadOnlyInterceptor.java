package com.nero.geektime.week7.interceptor;

import com.nero.geektime.week7.DbContextHolder;
import com.nero.geektime.week7.annotate.ReadOnly;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ReadOnlyInterceptor implements Ordered {

    @Around("@annotation(readOnly)")
    public Object setRead(ProceedingJoinPoint joinPoint, ReadOnly readOnly) throws Throwable {
        try {
            DbContextHolder.setDbType(DbContextHolder.READ);
            return joinPoint.proceed();
        } finally {
            //清楚DbType一方面为了避免内存泄漏，更重要的是避免对后续在本线程上执行的操作产生影响
            DbContextHolder.clearDbType();
            log.info("清除threadLocal");
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}