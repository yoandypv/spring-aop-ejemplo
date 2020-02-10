package com.yoandypv.aspectos.auditoria.aop.monitoring;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ErrorInterceptor {

    @AfterThrowing(pointcut = "execution(* com.yoandypv.aspectos.auditoria.*.* (..))", throwing = "ex")
    public void errorInterceptor(Exception ex) {
         System.out.println(ex.getMessage());
    }
}
