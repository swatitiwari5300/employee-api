package com.employee.api.employee_api.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.aspectj.lang.reflect.MethodSignature;
@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* com.employee.api.employee.api.controller..*(..)")
    public void appMethods() {}

    @Before("appMethods()")
    public void beforeMethods(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        log.info("Method Signature: {}", methodSignature);
    }

    @AfterReturning(value = "appMethods()", returning = "result")
    public void afterMethods(JoinPoint joinPoint, Object result){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info("Method Signature: {}, result: {}", methodSignature, result);
    }

    @AfterThrowing(value = "appMethods()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Throwable th){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.error("Method Signature: {}, error: {}", methodSignature, th);
    }
}
