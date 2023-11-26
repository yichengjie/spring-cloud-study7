//package com.yicj.hello.handler;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.server.ServerRequest;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//import java.util.List;
//
///**
// * @program: spring-cloud-study7
// * @description:
// * @author: yicj1
// * @create: 2022-10-31 10:19
// **/
//@Slf4j
//@Component
//public class HelloHandler {
//
//    public Mono<ServerResponse> hello(ServerRequest request){
//        HttpHeaders headers = request.headers().asHttpHeaders();
//        headers.forEach((key, value) -> log.info("key : {}", value));
//        return ServerResponse.ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(Flux.just("hello", "world", "test"), List.class) ;
//    }
//
//    public Mono<ServerResponse> world(ServerRequest request){
//        List<String> tokenList = request.headers().header("token");
//        List<String> extTokenList = request.headers().header("x-token");
//        log.info("===> token : {}", tokenList);
//        log.info("===> extTokenList : {}", extTokenList);
//        return ServerResponse.ok()
//                .contentType(MediaType.TEXT_PLAIN)
//                .body(BodyInserters.fromValue("world")) ;
//    }
//
//    public Mono<ServerResponse> exception(ServerRequest request){
//        String token = request.headers().firstHeader("token");
//        String xtoken = request.headers().firstHeader("x-token");
//        log.info("===> token : {}", token);
//        log.info("===> xtoken : {}", xtoken);
//        return ServerResponse.ok()
//                .contentType(MediaType.TEXT_PLAIN)
//                .body(this.obtainException(), String.class) ;
//    }
//
//    private Mono<String> obtainException(){
//        int i = 1/0 ;
//        return Mono.just("exception") ;
//    }
//}
