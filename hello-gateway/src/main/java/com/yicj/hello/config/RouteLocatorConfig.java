package com.yicj.hello.config;


import org.springframework.cloud.gateway.filter.factory.StripPrefixGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class RouteLocatorConfig {

    @Bean
    public RouteLocator registerRouteLocator(RouteLocatorBuilder locatorBuilder){
        return locatorBuilder.routes()
//                .route("register",
//                        fn -> fn.path("/register").uri("https://www.baidu.com")
//                )
                .route("login",
                        fn -> fn.path("/login")
                                .uri("https://www.baidu.com")
                )
                .build() ;
    }

}
