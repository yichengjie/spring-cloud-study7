package com.yicj.hello.feign;

import com.yicj.hello.HelloWorldApplication;
import com.yicj.web.response.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloWorldApplication.class)
public class HelloFeignClientTest {

    @Autowired
    private HelloFeignClient feignClient ;

    @Test
    public void hello(){
        RestResponse<String> response = feignClient.hello();
        log.info("rest response : {}", response);
    }

    @Test
    public void exception(){
        RestResponse<String> response = feignClient.exception();
        log.info("rest response : {}", response);
    }
}
