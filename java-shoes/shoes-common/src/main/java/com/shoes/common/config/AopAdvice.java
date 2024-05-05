package com.shoes.common.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author: Tomcat
 * @Date: 2024/5/5
 **/
@Aspect
@Component
public class AopAdvice {
    private static final Logger logger = LoggerFactory.getLogger(AopAdvice.class);

    @Pointcut("execution(* com.shoes.*.service.impl.*.*(..))")
    public void serviceLog(){
        System.out.println("beforeAdvice");
    }

    @Before("serviceLog()")
    public void beforeAdvice(){}

    @After("serviceLog()")
    public void afterAdvice(){}

    @Around("serviceLog()")
    public void roundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        Object[] args = proceedingJoinPoint.getArgs();
        String name = proceedingJoinPoint.getSignature().getName();
        logger.info("roundBefore: {}, {}", name, Arrays.toString(args));
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        }catch (Throwable t){
            t.printStackTrace();
        }
        logger.info("roundAfter: {}", result);
    }
}
