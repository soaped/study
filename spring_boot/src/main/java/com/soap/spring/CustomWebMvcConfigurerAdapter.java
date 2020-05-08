package com.soap.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Created by soap on 2018/1/11.
 */
//标注此文件为一个配置项，spring boot才会扫描到该配置。该注解类似于之前使用xml进行配置
@Configuration
public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //对来自/** 这个链接来的请求进行拦截
//        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**");
//    }

    
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
