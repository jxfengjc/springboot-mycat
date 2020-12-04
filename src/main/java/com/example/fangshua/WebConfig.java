package com.example.fangshua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebConfig
 * @Description: TODO
 * @Author fengjc
 * @Date 2020/12/3
 * @Version V1.0
 **/
/*
 * springboot可以自定义配置类（标注了Configuration 的类）来实现webMvcConfigurer 接口，并重写addInterceptor()方法来配置拦截器
 * */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    final FangshuaInterceptor fangshuaInterceptor;

    @Autowired
    public WebConfig(FangshuaInterceptor fangshuaInterceptor) {
        this.fangshuaInterceptor = fangshuaInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(fangshuaInterceptor);
        //指定拦截器要拦截的请求(支持*通配符)
        //对url  /fangshua 之后的拦截
        interceptorRegistration.addPathPatterns("/fangshua/**");
        //指定拦截器不拦截的请求(支持*通配符)
        interceptorRegistration.excludePathPatterns("/redis/**");

    }

}
