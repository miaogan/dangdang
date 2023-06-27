package com.ac.dang_dang.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LogAOP {
    @Around("execution(* com.ac.dang_dang.service..*(..))")
    public  Object consoleLog(ProceedingJoinPoint JoinPoint) throws Throwable {
        long begin=System.currentTimeMillis();
        Object result=JoinPoint.proceed();
        long end=System.currentTimeMillis();
        log.info("日志输出:{} 执行了{}ms",JoinPoint.getSignature(),end-begin);
        return  result;
    }
}
