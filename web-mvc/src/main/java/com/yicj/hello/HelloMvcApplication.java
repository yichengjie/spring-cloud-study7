package com.yicj.hello;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author yicj1
 * @create 2022-10-31 10:06
 **/
@SpringBootApplication
public class HelloMvcApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(HelloMvcApplication.class)
                .main(HelloMvcApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args) ;
    }
}
