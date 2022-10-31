package com.yicj.hello;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @program: spring-cloud-study7
 * @description:
 * @author: yicj1
 * @create: 2022-10-31 10:06
 **/
@SpringBootApplication
public class HelloMvcApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(HelloMvcApplication.class)
                .main(HelloMvcApplication.class)
                .web(WebApplicationType.REACTIVE)
                .run(args) ;
    }
}
