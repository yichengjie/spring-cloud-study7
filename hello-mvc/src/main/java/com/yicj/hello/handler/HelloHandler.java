package com.yicj.hello.handler;

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
@Component
public class HelloHandler {

    public Mono<ServerResponse> hello(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Flux.just("hello", "world", "test"), List.class) ;
    }

    public Mono<ServerResponse> world(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("world")) ;
    }

    public Mono<ServerResponse> exception(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(this.obtainException(), String.class) ;
    }

    private Mono<String> obtainException(){
        int i = 1/0 ;
        return Mono.just("exception") ;
    }
}
