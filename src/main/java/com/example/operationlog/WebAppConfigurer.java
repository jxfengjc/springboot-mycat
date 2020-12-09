package com.example.operationlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {


    final private OperationLogInterception operationLogInterception;



    @Autowired
    public WebAppConfigurer(OperationLogInterception operationLogInterception) {
        this.operationLogInterception = operationLogInterception;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(operationLogInterception).addPathPatterns("/**");

    }
}
