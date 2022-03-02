package com.arijeet.logging;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import lombok.extern.slf4j.Slf4j;

//@Component
@Slf4j
@Aspect
public class LoggingAsp {

    @Around("allMethods() && @annotation(com.arijeet.logging.ExecutionTime)")
    public Object execute(ProceedingJoinPoint joinPoint, ExecutionTime executionTime) throws Throwable {
        log.info("Logging -----------");
        long startTime = System.nanoTime();
        Object proceed = joinPoint.proceed();
        long endTime = System.nanoTime();
        String methodName = joinPoint.getSignature().getName();
        log.info("Execution of " + methodName + " took " +
                TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms");
        return proceed;
    }

    @Pointcut("within(com.arijeet.grpc.client.*)")
    public void allMethods() {
        log.debug("Inside all methods");
    }

}
