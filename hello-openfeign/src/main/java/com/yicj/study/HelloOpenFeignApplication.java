package com.yicj.study;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yicj1
 */
@EnableFeignClients(basePackages = "com.yicj.study.feign")
@SpringBootApplication
public class HelloOpenFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloOpenFeignApplication.class, args) ;
    }
}