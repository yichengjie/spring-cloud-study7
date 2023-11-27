package com.yicj.study.feign;

import com.yicj.study.model.vo.RestResponse;
import com.yicj.study.model.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * <p>
 * HelloFeignClient
 * </p>
 *
 * @author yicj
 * @since 2023年11月26日 19:19
 */
@FeignClient(name = "hello-web-mvc", url = "http://192.168.1.214:8081")
public interface HelloFeignClient {

    @GetMapping("/hello2/listAllUser")
    RestResponse<List<UserVO>> listAllUser() ;

    @GetMapping("/hello2/listAllUser")
    String listAllUserString() ;
}
