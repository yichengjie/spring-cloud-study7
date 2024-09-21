package com.yicj.hello.controller;

import com.yicj.hello.hystrix.DoHystrix;
import com.yicj.web.exception.AppException;
import com.yicj.web.response.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yicj1
 * @create 2022-11-01 11:14
 **/
@Slf4j
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

    @GetMapping("/timeout")
    @DoHystrix(timeoutValue = 350, returnJson = "{\"code\":\"1111\",\"message\":\"调用方法超过350毫秒，熔断返回！\"}")
    public RestResponse<String> timeout() throws InterruptedException {
        Thread.sleep(1000);
        return RestResponse.success("timeout") ;
    }


    private void testAppException(){

        throw new AppException("10011", "测试自定义业务异常！") ;
    }
}
