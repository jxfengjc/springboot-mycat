package com.example.fangshua;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @ClassName AccessLimit
 * @Description: TODO
 * @Author fengjc
 * @Date 2020/12/3
 * @Version V1.0
 **/
@Retention(RUNTIME)
@Target(METHOD)
public @interface AccessLimit {
    int seconds();
    int maxCoint();
    boolean needLogin()default true;
}
