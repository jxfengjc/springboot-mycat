package com.example.fangshua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName WebConfig
 * @Description: TODO
 * @Author fengjc
 * @Date 2020/12/3
 * @Version V1.0
 **/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Autowired
    FangshuaInterceptor fangshuaInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(fangshuaInterceptor);
    }

}
