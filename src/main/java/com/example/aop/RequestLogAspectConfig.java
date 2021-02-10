package com.example.aop;

import com.example.util.FileBeatLogUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Modifier;

/**
 * @ClassName RequestLogAspectConfig
 * @Description: TODO
 * @Author fengjc
 * @Date 2021/2/9
 * @Version V1.0
 **/
@Aspect
@Order(1)
@Component
public class RequestLogAspectConfig {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private Environment env;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 定义一个切入点表达式,用来确定哪些类需要代理
     * execution(* aop.*.*(..))代表aop包下所有类的所有方法都会被代理
     */
    @Pointcut("execution(* com.example.aop..*.*(..))")
   public void methodPointCut(){

   }
    /**
     * 前置方法,在目标方法执行前执行
     * @param joinPoint 封装了代理方法信息的对象,若用不到则可以忽略不写
     */
    @Before("methodPointCut()")
    void before(JoinPoint joinPoint){
        authLogic(joinPoint);
    }

    private void authLogic(JoinPoint joinPoint) {
        try {
            /**
             * 测试下joinPoint
             */
            System.out.println("目标方法名为:" + joinPoint.getSignature().getName());
            System.out.println("目标方法所属类的简单类名:" +        joinPoint.getSignature().getDeclaringType().getSimpleName());
            System.out.println("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
            System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));

            String applicationName = env.getProperty("spring.application.name");
            //获取当前http请求
            String reqName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
            String requestParams = FileBeatLogUtil.getParams(joinPoint);
            FileBeatLogUtil.writeRequestInfo(request, applicationName, reqName, requestParams);
        }catch (Exception e){
            logger.error("RequestLogAspectConf;authLogic;Exception:{}", e.getMessage());
        }
    }
    /**
     * 环绕方法,可自定义目标方法执行的时机
     * @param pjd JoinPoint的子接口,添加了
     *            Object proceed() throws Throwable 执行目标方法
     *            Object proceed(Object[] var1) throws Throwable 传入的新的参数去执行目标方法
     *            两个方法
     * @return 此方法需要返回值,返回值视为目标方法的返回值
     */
    @Around("methodPointCut()")
    public Object aroundMethod(ProceedingJoinPoint pjd){
        Object result = null;

        try {
            //前置通知
            System.out.println("目标方法执行前...");
            //执行目标方法
            result = pjd.proceed();
            //用新的参数值执行目标方法
           // result = pjd.proceed(new Object[]{"newSpring","newAop"});
            //返回通知
            System.out.println("目标方法返回结果后...");
        } catch (Throwable e) {
            //异常通知
            System.out.println("执行目标方法异常后...");
            throw new RuntimeException(e);
        }
        //后置通知
        System.out.println("目标方法执行后...");

        return result;
    }

}
