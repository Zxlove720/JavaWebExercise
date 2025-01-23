package com.wzb.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 测试AOP
 */
@Slf4j
// @Aspect
@Component
@Order(0)
public class MyAspect2 {

//    @Around("execution(* com.wzb.service.impl.EmpServiceImpl.*(..))")
//    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
//        // 记录开始时间
//        Long begin = System.currentTimeMillis();
//        // 执行原始方法
//        Object result = pjp.proceed();
//        // 记录结束时间
//        Long end = System.currentTimeMillis();
//        // 计算耗时
//        log.info("方法运行耗时：{}ms", (end - begin));
//        return result;
//    }

    /**
     * 切入点方法
     */
    @Pointcut("execution(* com.wzb.service.impl.EmpServiceImpl.addEmp(..)) || " +
            "execution(* com.wzb.service.impl.EmpServiceImpl.login(..))")
    public void pt() {}

    /**
     * 前置通知，在目标方法运行前执行
     * @param joinPoint 连接点
     */
    @Before("pt()")
    public void before(JoinPoint joinPoint) {
        log.info("MyAspect2 before...");
    }

    /**
     * 环绕通知，在目标方法运行前后都会执行
     * @param pjp 连接点
     * @return 目标方法运行返回值
     * @throws Throwable 目标方法运行抛出异常
     */
    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("MyAspect2 around before...");
        Object result = pjp.proceed();
        // 假如目标方法运行报错，则不会执行方法后面的代码
        log.info("MyAspect2 around after...");
        return result;
    }

    /**
     * 后置通知，在目标方法运行后执行，不论目标方法是否成功运行，后置通知都会执行
     * @param joinPoint 连接点
     */
    @After("pt()")
    public void after(JoinPoint joinPoint) {
        log.info("MyAspect2 after...");
    }

    /**
     * 返回后通知，在目标方法运行成功后执行，若运行失败则不执行
     * @param joinPoint 连接点
     */
    @AfterReturning("pt()")
    public void afterReturning(JoinPoint joinPoint) {
        log.info("MyAspect2 afterReturning...");
    }

    /**
     * 异常通知，在目标方法运行失败，抛出异常后执行，和AfterReturning通知不可能同时执行
     * @param joinPoint 连接点
     */
    @AfterThrowing("pt()")
    public void afterThrowing(JoinPoint joinPoint) {
        log.info("MyAspect2 afterThrowing");
    }


}
