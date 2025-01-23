package com.wzb.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * AOP通知类型测试
 */
@Slf4j
@Aspect
@Component
@Order(1)
public class MyAspect1 {

    /**
     * 抽取切入点表达式
     * 抽取到切入点方法中
     */
    @Pointcut("execution(* com.wzb.service.impl.EmpServiceImpl.*(..))")
    private void pt() {}


    /**
     * Before 前置通知，在方法运行前执行
     * @param joinPoint 连接点
     */
    @Before("pt()")
    public void before(JoinPoint joinPoint) {
        log.info("before 前置通知");
    }

    /**
     * Around 环绕通知，在方法运行前后都会执行
     * @param pjp 连接点
     * @return 方法返回值
     * @throws Throwable 原始方法运行时抛出异常
     */
    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("before around");
        // 调用目标对象的原始方法执行
        Object result = pjp.proceed();
        // 假如原始方法执行时有异常，那么环绕通知的后置代码就不会执行
        log.info("after around");
        return result;
    }

    /**
     * After 后置通知方法运行后执行
     * @param joinPoint 连接点
     */
    @After("pt()")
    public void after(JoinPoint joinPoint) {
        log.info("after 后置通知");
    }


    /**
     * 返回后通知 目标方法必须正常运行才会执行返回后通知
     * @param joinPoint 连接点
     */
    @AfterReturning("pt()")
    public void afterReturning(JoinPoint joinPoint) {
        log.info("afterReturning 返回后通知");
    }

    /**
     * 异常通知 目标方法必须抛出异常，执行出错才会执行异常通知，异常通知和返回后通知互斥
     * @param joinPoint 连接点
     */
    @AfterThrowing("pt()")
    public void afterThrowing(JoinPoint joinPoint) {
        log.info("afterThrowing 异常通知");
    }


}
