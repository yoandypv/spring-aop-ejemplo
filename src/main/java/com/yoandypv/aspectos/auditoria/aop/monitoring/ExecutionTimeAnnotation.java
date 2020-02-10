package com.yoandypv.aspectos.auditoria.aop.monitoring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAnnotation {
    @Around("@annotation(com.yoandypv.aspectos.auditoria.aop.annotation.GrabExecutionTime)")
    public void grabExecutionTime(ProceedingJoinPoint point) {
        try {
            Long tiempo1 = System.currentTimeMillis();
            point.proceed();
            Long tiempo2 = System.currentTimeMillis();
            Long total = tiempo2 - tiempo1;
            System.out.println("[With annotation]The time execution is: " + total);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
