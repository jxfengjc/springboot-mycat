package com.example.operationlog;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName OperationLog
 * @Description: 操作日志 注解
 * @Author fengjc
 * @Date 2020/12/9
 * @Version V1.0
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface OperationLog {
    /**
     * 操作模块名称
     */
    String operateName();

    /**
     *  操作内容
     */
    String content();

    /**
     *  操作类型
     */
    String operateType() default "";
}
