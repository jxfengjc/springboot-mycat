package com.example.aop;

import org.springframework.stereotype.Component;

/**
 * @ClassName TargetClass
 * @Description: 被代理对象
 * @Author fengjc
 * @Date 2021/2/9
 * @Version V1.0
 **/

@Component
public class TargetClass {
    /**
     * 拼接两个字符串
     */
    public String joint(String str1, String str2) {
        return str1 + "+" + str2;
    }

}
