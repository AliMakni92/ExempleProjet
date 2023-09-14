package com.example.LoggingAspect;

import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @Around("execution(* com.example.myapp.controllers.*.*(..))")
    public Object logMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        
        logger.info(
            "{}() executed in {} ms",
            joinPoint.getSignature().toShortString(),
            (endTime - startTime)
        );
        
        return result;
    }
}

