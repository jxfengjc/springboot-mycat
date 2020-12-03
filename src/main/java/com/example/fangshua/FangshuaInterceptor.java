package com.example.fangshua;

import com.alibaba.druid.support.json.JSONUtils;
import com.example.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @ClassName FangshuaInterceptor
 * @Description: TODO
 * @Author fengjc
 * @Date 2020/12/3
 * @Version V1.0
 **/
@Component
public class FangshuaInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    RedisService redisService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler){
        //判断请求是不是属于方法的请求
        if(handler instanceof HandlerMethod){
            HandlerMethod method = (HandlerMethod) handler;
            //获取该方法的注解，看看是否有该方法的注解
            AccessLimit accessLimit = method.getMethodAnnotation(AccessLimit.class);
            if(accessLimit == null){
                return true;
            }
            int second =accessLimit.seconds();
            int maxCount =accessLimit.maxCoint();
            boolean login =accessLimit.needLogin();
            String key =request.getRequestURI();
            if(login){
                //获取登录的session 进行判断
                key +=""+"1";//这里假设用户是1,项目中是动态获取的userId
            }
            //从redis中动态获取用户访问次数
            Integer count=null;
            String countStr= redisService.get(key);
            if(!StringUtils.isEmpty(countStr)){
                count = Integer.valueOf(countStr);
            }
            if(count == null){
                redisService.set(key,"1",second);
            }else if(count >= maxCount){
                render(response,"超出访问限制");
                return false;
            }else {
                redisService.increment(key);
            }

        }
    return true;
    }
    private void render(HttpServletResponse response,String str )  {
        response.setContentType("application/json;charset=UTF-8");
        try {
            OutputStream  out =response.getOutputStream();
            out.write(str.getBytes("UTF-8"));
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
