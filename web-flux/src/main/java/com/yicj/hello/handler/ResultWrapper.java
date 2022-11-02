package com.yicj.hello.handler;

import lombok.Builder;
import lombok.Data;

/**
 * @program: spring-cloud-study7
 * @description:
 * @author: yicj1
 * @create: 2022-10-31 12:44
 **/
@Data
@Builder
public class ResultWrapper {

    private String message ;

}
