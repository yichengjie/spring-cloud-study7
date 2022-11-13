package com.yicj.hello.feign.fallback;

import com.yicj.hello.feign.HelloFeignClient;
import com.yicj.web.response.RestResponse;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloFeignClientFallback implements FallbackFactory<HelloFeignClient> {
    @Override
    public HelloFeignClient create(Throwable throwable) {
        return new HelloFeignClient() {
            @Override
            public RestResponse<String> hello() {
                log.error("hello fallback : {}", throwable.getMessage(), throwable);
                // [600] during [GET] to [http://localhost:8080/hello2/exception]
                // [HelloFeignClient#exception()]:
                // [{"code":"10011","message":"测试自定义业务异常！","data":null}]
                return null;
            }

            @Override
            public RestResponse<String> exception() {
                log.error("exception fallback : {}", throwable.getMessage(), throwable);
                return null;
            }
        };
    }
}
