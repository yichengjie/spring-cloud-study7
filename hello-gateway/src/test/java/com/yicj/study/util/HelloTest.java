package com.yicj.study.util;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @program: spring-cloud-study7
 * @description:
 * @author: yicj1
 * @create: 2022-11-02 15:16
 **/
public class HelloTest {

    @Test
    public void testError() {
        Flux.range(1, 6)
            .map(n -> {
                if (n == 5) {
    //                throw new RuntimeException("exception");
                    return Mono.error(new Exception("exception"));
                }
                System.out.println("--> " + n);
                return Mono.just(n);
            })
            //.collectList()
//            .map(list -> {
//                System.out.println(list.size());
//                return Mono.just("");
//            })
            .subscribe(System.out::println);
    }
}
