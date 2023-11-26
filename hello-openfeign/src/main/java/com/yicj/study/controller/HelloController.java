package com.yicj.study.controller;

import com.yicj.study.feign.HelloFeignClient;
import com.yicj.study.model.vo.RestResponse;
import com.yicj.study.model.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * HelloController
 * </p>
 *
 * @author yicj
 * @since 2023年11月26日 19:23
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    private HelloFeignClient helloFeignClient ;

    @GetMapping("/hello/listAllUser")
    public RestResponse<List<UserVO>> listAllUser(){
        RestResponse<List<UserVO>> list = helloFeignClient.listAllUser();
        log.info("list : {}", list);
        return list ;
    }

}
