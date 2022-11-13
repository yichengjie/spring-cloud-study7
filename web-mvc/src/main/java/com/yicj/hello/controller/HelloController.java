package com.yicj.hello.controller;

import com.yicj.web.exception.AppException;
import com.yicj.web.response.RestResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public RestResponse<String> hello(){
        return RestResponse.success("hello world") ;
    }

    @GetMapping("/exception")
    public RestResponse<String> exception(){
        this.testAppException();
        return RestResponse.success("exception") ;
    }


    private void testAppException(){

        throw new AppException("10011", "测试自定义业务异常！") ;
    }
}
