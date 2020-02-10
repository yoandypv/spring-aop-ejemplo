package com.yoandypv.aspectos.auditoria.aop.monitoring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTime {

    /*
    @Around("execution(* com.yoandypv.aspectos.auditoria.service.*.*(*))")
    public void getServicesExecutionTime(ProceedingJoinPoint point) {
        try {
            Long tiempo1 = System.currentTimeMillis();
            point.proceed();
            Long tiempo2 = System.currentTimeMillis();
            Long total = tiempo2 - tiempo1;
            System.out.println("[Without annotation] The time execution is: " + total);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

     */
}
