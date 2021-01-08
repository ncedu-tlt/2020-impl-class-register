package com.pozhenskii.spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {
    //Все доступы, всу возвр параметры, все методы
    //всех классов в пакете dao, с любым кол-вом параметров
    @Around("execution(* com.pozhenskii.spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature =
                (MethodSignature) proceedingJoinPoint.getSignature();
        //получаем название из сигнатуры
        String methodName = methodSignature.getName();

        System.out.println("Begin of " + methodName);

        //выполняем
        Object targetMethodResult = proceedingJoinPoint.proceed();

        System.out.println("End of " + methodName);

        return targetMethodResult;
    }
}
