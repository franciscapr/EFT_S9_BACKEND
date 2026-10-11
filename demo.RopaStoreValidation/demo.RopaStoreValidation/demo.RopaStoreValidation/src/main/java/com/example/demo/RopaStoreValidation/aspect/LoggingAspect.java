package com.example.demo.RopaStoreValidation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.example.demo.RopaStoreValidation.service..*(..))")
    public void metodosServicio() {}

    @Before("metodosServicio()")
    public void registrarAntes(JoinPoint joinPoint) {
        log.info("[AOP LOG] Ejecutando: {}() con parametros: {}",
                joinPoint.getSignature().getName(),
                joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "metodosServicio()", returning = "resultado")
    public void registrarDespues(JoinPoint joinPoint, Object resultado) {
        log.info("[AOP LOG] Metodo {} finalizado exitosamente.",
                joinPoint.getSignature().getName());
    }
}