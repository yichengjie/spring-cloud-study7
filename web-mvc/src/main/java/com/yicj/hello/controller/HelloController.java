package com.yicj.hello.controller;

import com.yicj.hello.model.vo.RestResponse;
import com.yicj.hello.model.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    public String hello(){
        return "hello world" ;
    }


    @GetMapping("/listAllUser")
    public RestResponse<List<UserVO>> listAllUser(){
        List<UserVO> retList = IntStream.range(1, 100000)
                .mapToObj(item -> {
                    UserVO vo = new UserVO();
                    vo.setId(UUID.randomUUID().toString());
                    vo.setUsername("intellij-generateAllSetMethod, generate setter default values when cursor on local variable " + item);
                    vo.setAddress("generate converter when cursor in method generate List Set Map return value Installation" + item);
                    vo.setCompany("support following product build version > 141" + item);
                    vo.setJob("IntelliJ IDEA Community Edition");
                    vo.setPartnerId("change the code and run the task to see the change" + item);
                    return vo;
                }).collect(Collectors.toList());
        RestResponse<List<UserVO>> response = RestResponse.success(retList);
        return response ;
    }



}
