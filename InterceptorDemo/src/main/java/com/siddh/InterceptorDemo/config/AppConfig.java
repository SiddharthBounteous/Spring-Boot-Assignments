package com.siddh.InterceptorDemo.config;

import com.siddh.InterceptorDemo.interceptor.MyCustomInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//we have to register this interceptor for particular controller
@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    MyCustomInterceptor myCustomInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor(myCustomInterceptor)
                .addPathPatterns("/api/v1/*")  //apply to these url patterns
                .excludePathPatterns("/api/v1/updateUser","/api/v1/deleteUser");
    }
}
