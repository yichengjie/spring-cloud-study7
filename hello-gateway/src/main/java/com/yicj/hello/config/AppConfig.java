package com.yicj.hello.config;

import com.yicj.hello.filter.CustomOrderLogGlobalFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
public class AppConfig {

    @Bean
    public GlobalFilter filter1(){
        return new CustomOrderLogGlobalFilter("filter1", -1) ;
    }

    @Bean
    public GlobalFilter filter2(){
        return new CustomOrderLogGlobalFilter("filter2", 0) ;
    }

    @Bean
    public GlobalFilter filter3(){
        return new CustomOrderLogGlobalFilter("filter3", 1) ;
    }

}