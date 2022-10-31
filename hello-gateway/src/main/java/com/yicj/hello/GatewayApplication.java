package com.yicj.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @program: spring-cloud-study7
 * @description:
 * @author: yicj1
 * @create: 2022-10-31 11:17
 **/
@SpringCloudApplication
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {

        SpringApplication.run(GatewayApplication.class, args) ;
    }
}
