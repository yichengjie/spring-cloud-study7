//package com.yicj.hello.config;
//
//import com.yicj.hello.filter.AuthFilter;
//import com.yicj.hello.handler.HelloHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.function.server.*;
//
///**
// * @program: spring-cloud-study7
// * @description:
// * @author: yicj1
// * @create: 2022-10-31 10:07
// **/
//@Configuration
//public class RouteConfig {
//
//    @Autowired
//    private HelloHandler handler ;
//
//    @Autowired
//    private AuthFilter authFilter ;
//
//    @Bean
//    public RouterFunction<ServerResponse> helloRouter(){
//        return RouterFunctions
//                .route(RequestPredicates.GET("/hello/hello"), handler::hello)
//                .andRoute(RequestPredicates.GET("/hello/world"), handler::world)
//                .andRoute(RequestPredicates.GET("/exception"), handler::exception)
//                .filter(authFilter);
//    }
//}
