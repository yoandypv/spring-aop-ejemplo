package com.yoandypv.aspectos.auditoria.aop.monitoring;

import com.yoandypv.aspectos.auditoria.aop.annotation.Watcher;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class WatchUserActions {

    @After( "@annotation(com.yoandypv.aspectos.auditoria.aop.annotation.Watcher)")
    public void watchUserActions(JoinPoint point) {
        try {
            // Obtenemos la accion colocada en la anotacion
            MethodSignature ms = (MethodSignature) point.getSignature();
            Method method = ms.getMethod();
            Watcher watcher = method.getAnnotation(Watcher.class);
            String action = watcher.action();

            // Obtenemos los parametros del metodo
            Object [] methodArgs = point.getArgs();
            System.out.print("Parametros: ");
            for(Object o: methodArgs)
                System.out.print(o.toString());
            System.out.println("");


            // Podemos agregar el usuario que hizo la accion (Si tuvieramos el usuario en el contexto )
            //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            //String name = auth.getName(); //get logged in username
            String name = "userlogged";

            // Fecha
            Date date = new Date();

            String msg = String.format("El usuario %s realizó la acción %s pasandi %s arguments las %s", name, action, methodArgs.length, date);
            System.out.println(msg);

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
