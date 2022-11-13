package com.yicj.web;

import com.yicj.web.interceptor.CustomExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebMvcConfigAutoConfiguration {

    @Bean
    public CustomExceptionHandler customExceptionHandler(){

        return new CustomExceptionHandler() ;
    }
}
