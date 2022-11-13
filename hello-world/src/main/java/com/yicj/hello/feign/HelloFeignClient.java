package com.yicj.hello.feign;

import com.yicj.hello.feign.fallback.HelloFeignClientFallback;
import com.yicj.web.response.RestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "web-mvc",
        contextId = "helloFeignClient",
        fallbackFactory = HelloFeignClientFallback.class,
        url = "localhost:8080")
public interface HelloFeignClient {

    @GetMapping("/hello2/hello")
    RestResponse<String> hello() ;


    @GetMapping("/hello2/exception")
    RestResponse<String> exception() ;
}
