package com.example.aop;

import com.example.util.FileBeatLogUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ClassName ExceptionLogAspect
 * @Description: TODO
 * @Author fengjc
 * @Date 2021/2/9
 * @Version V1.0
 **/
@Aspect
@Order(1)
@Component
public class ExceptionLogAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(* com.example.aop..*.*(..))")
    public void methodPointCut(){

    }
    @AfterThrowing(throwing = "ex", pointcut = "methodPointCut()")
    private void throwss(JoinPoint joinPoint, Exception ex){
        try {
            String methodArgs = Arrays.toString(joinPoint.getArgs());
            System.out.println("错误的方法"+methodArgs);
            System.out.println("错误原因"+ex.getMessage());
            FileBeatLogUtil.writeExceptionLog(joinPoint.getSignature().toString(), methodArgs, ex.getMessage());
        } catch (Exception e) {
            logger.error("ExceptionLogAspect;writeExceptionLog;Exception:{}", e.getMessage());
        }
    }
}
