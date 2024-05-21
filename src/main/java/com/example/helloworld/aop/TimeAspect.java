package com.example.helloworld.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
@Order(1)
public class TimeAspect {
    @Around("execution(* com.example.helloworld.controller.*.*(..))")
    public Object recordTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info("{}.{}() 耗时 {} ms",
                proceedingJoinPoint.getSignature().getDeclaringTypeName(),
                proceedingJoinPoint.getSignature().getName(),
                end - begin);
        return result;
    }

    @Before("execution(* com.example.helloworld.controller.*.*(..))")
    public void before() {
        log.info("before");
    }

    @After("execution(* com.example.helloworld.controller.*.*(..))")
    public void after() {
        log.info("after");
    }

    @Pointcut("execution(* com.example.helloworld.controller.*.*(..))")
    public void pt(){
        log.info("pointcut");
    }

    @AfterReturning("pt()")
    public void afterReturning() {
        log.info("afterReturning");
    }
}
