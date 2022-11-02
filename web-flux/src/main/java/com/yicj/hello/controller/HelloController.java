package com.yicj.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @program: spring-cloud-study7
 * @description:
 * @author: yicj1
 * @create: 2022-11-01 11:14
 **/
@RestController
@RequestMapping("/hello2")
public class HelloController {

    @GetMapping("/hello")
    public Mono<String> hello(){

        return Mono.just("hello world") ;
    }
}
