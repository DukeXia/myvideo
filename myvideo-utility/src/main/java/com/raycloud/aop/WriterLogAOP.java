package com.raycloud.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.aspectj.AspectJAroundAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/4/30.
 */
@Aspect
@Component
public class WriterLogAOP {

    //@Around("execution(* com.raycloud..add*(..))")
    public void get(ProceedingJoinPoint point){
        try {
            System.out.println("-----拦截前");


            point.proceed();

            System.out.println("-----拦截后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
