package com.wzb.aspect;

import com.wzb.mapper.OperateLogMapper;
import com.wzb.pojo.OperateLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 记录操作日志AOP
 */
@Slf4j
@Component
//@Aspect
public class LogAspect {

    private final OperateLogMapper operateLogMapper;

    @Autowired
    public LogAspect(OperateLogMapper operateLogMapper) {
        this.operateLogMapper = operateLogMapper;
    }

    @Around("@annotation(com.wzb.annotation.LogOperation)")
    public Object recordOperateLog(ProceedingJoinPoint pjp) throws Throwable {
        // 记录方法开始时间
        long begin = System.currentTimeMillis();
        // 执行目标方法
        Object result = pjp.proceed();
        // 获取执行耗时
        long costTime = System.currentTimeMillis() - begin;

        // 构建日志对象
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(getCurrentUserId());
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(pjp.getTarget().getClass().getName());
        operateLog.setMethodName(pjp.getSignature().getName());
        operateLog.setMethodParams(Arrays.toString(pjp.getArgs()));
        operateLog.setReturnValue(result.toString());
        operateLog.setCostTime(costTime);

        // 插入日志
        operateLogMapper.insertLog(operateLog);
        return result;
    }

    //TODO待完善的获取当前用户id的方法
    private int getCurrentUserId() {
        return 1;
    }
}
