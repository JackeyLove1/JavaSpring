package com.example.helloworld.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class MyAspect {
    @Pointcut("@annotation(MyLog)")
    private void pt() {
    }

    @Before("pt()")
    public void myLog() {
        System.out.println("My Aspect");
    }

    @Around("pt()")
    public Object printInfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("After running MyLog");
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        log.info("className:{}", className);

        String methodName = proceedingJoinPoint.getSignature().getName();
        log.info("methodName:{}", methodName);

        Object[] args = proceedingJoinPoint.getArgs();
        log.info("Args: {}", Arrays.toString(args));

        return proceedingJoinPoint.proceed();
    }

}
