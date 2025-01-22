package com.wzb.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 通过AOP统计员工操作的耗时
 */
@Component
@Aspect // 将其标记为切面类
@Slf4j
public class RecordTimeAspect {

    @Around("execution(* com.wzb.service.impl.EmpServiceImpl.*(..))")
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
        // 记录方法开始时间
        Long begin = System.currentTimeMillis();
        // 调用原始方法
        Object result = pjp.proceed();
        // 记录方法结束时间
        Long end = System.currentTimeMillis();
        // 计算方法耗时
        log.info("执行方法耗时：{}ms", end - begin);
        return result;
    }
}
