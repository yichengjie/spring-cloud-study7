package com.yicj.hello.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.List;

/**
 * @program: spring-cloud-study7
 * @description:
 * @author: yicj1
 * @create: 2022-10-31 10:19
 **/
@Slf4j
@Component
public class HelloHandler {

    public Mono<ServerResponse> hello(ServerRequest request){
        ServerRequest.Headers headers = request.headers() ;

        String token = request.headers().firstHeader("x-token");
        log.info("===> token : {}", token);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Flux.just("hello", "world", "test"), List.class) ;
    }

    public Mono<ServerResponse> world(ServerRequest request){
        String token = request.headers().firstHeader("x-token");
        log.info("===> token : {}", token);
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("world")) ;
    }

    public Mono<ServerResponse> exception(ServerRequest request){
        String token = request.headers().firstHeader("x-token");
        log.info("===> token : {}", token);
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(this.obtainException(), String.class) ;
    }

    private Mono<String> obtainException(){
        int i = 1/0 ;
        return Mono.just("exception") ;
    }
}
