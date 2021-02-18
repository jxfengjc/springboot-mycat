package com.example.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName GlobalExceptionHandler
 * @Description: 统一异常处理
 * @Author fengjc
 * @Date 2021/2/18
 * @Version V1.0
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @Autowired
    Environment env;

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String  exceptionHandler(HttpServletRequest request,Exception e) throws UnknownHostException {
        //其他异常处理（自定义的异常）

        //剩下的异常处理
        String activeProfile = env.getActiveProfiles()[0];
        StackTraceElement[] err = e.getStackTrace();
        StringBuilder sb = new StringBuilder();
        sb.append("服务器ip：").append(InetAddress.getLocalHost().getHostAddress());
        sb.append("\n");
        sb.append(e.toString());
        sb.append("\n");
        //仅打印 我们自己类的报错信息
        for (StackTraceElement element : err) {
            String errmsg = element.toString();
            if (errmsg.contains("com.example")) {
                sb.append("\n");
                sb.append(element.toString());
            }
        }
        //钉钉处理
        DingDingUtil.sendExceptionMsg(activeProfile,"测试"+ request.getRequestURI(),sb.toString());
        return sb.toString();
    }
}
