package com.yicj.hello.controller;

import com.yicj.hello.hystrix.DoHystrix;
import com.yicj.hello.methodext.DoMethodExt;
import com.yicj.hello.ratelimiter.DoRateLimiter;
import com.yicj.web.exception.AppException;
import com.yicj.web.response.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 测试：http://localhost:8080/api/queryUserInfo?userId=aaa
     */
    @DoRateLimiter(permitsPerSecond = 1, returnJson = "{\"code\":\"1111\",\"message\":\"调用方法超过最大次数，限流返回！\"}")
    @RequestMapping(path = "/api/queryUserInfo", method = RequestMethod.GET)
    public RestResponse<String> queryUserInfo(@RequestParam String userId) throws InterruptedException {
        log.info("查询用户信息，userId：{}", userId);
        return RestResponse.success("查询用户信息，userId：" + userId) ;
    }

    /**
     * 放行：http://localhost:8081/api/queryUserInfo?userId=aaa
     * 拦截：http://localhost:8081/api/queryUserInfo?userId=bbb
     */
    @DoMethodExt(method = "blacklist", returnJson = "{\"code\":\"1111\",\"message\":\"自定义校验方法拦截，不允许访问！\"}")
    @RequestMapping(path = "/api/queryUserInfo2", method = RequestMethod.GET)
    public String queryUserInfo2(@RequestParam String userId) {
        log.info("查询用户信息，userId：{}", userId);
        return "虫虫:" + userId ;
    }

    /**
     * 自定义黑名单，拦截方法
     */
    public boolean blacklist(String userId) {
        if ("bbb".equals(userId) || "222".equals(userId)) {
            log.info("拦截自定义黑名单用户 userId：{}", userId);
            return false;
        }
        return true;
    }


    private void testAppException(){

        throw new AppException("10011", "测试自定义业务异常！") ;
    }
}
