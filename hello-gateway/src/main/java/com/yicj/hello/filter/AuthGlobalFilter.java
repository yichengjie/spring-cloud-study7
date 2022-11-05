package com.yicj.hello.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferWrapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @program: spring-cloud-study7
 * @description:
 * @author: yicj1
 * @create: 2022-11-02 10:26
 **/
@Slf4j
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String path = request.getURI().getPath();
        log.info("path : {}", path);
        if (path.contains("login")){
            log.info("this is a login request ...");
            response.getHeaders().add("token", "hello");
            response.setStatusCode(HttpStatus.OK) ;
            DataBufferFactory bufferFactory = response.bufferFactory();
            DataBuffer dataBuffer = bufferFactory.wrap("login success".getBytes(StandardCharsets.UTF_8));
            return response.writeAndFlushWith(Mono.fromSupplier(()-> Mono.just(dataBuffer))) ;
            //response.writeWith(Mono.just(dataBuffer))
            //return exchange.getResponse().setComplete() ;
        }
        HttpHeaders headers = request.getHeaders();
        String token = headers.getFirst("token");
        log.info("======> token : {}", token);
        ServerHttpRequest newRequest = exchange.getRequest()
                .mutate()
                .header("x-token", token)
                .header("token", "789")
                .build();
        ServerWebExchange newExchange = exchange.mutate()
                .request(newRequest).build();

        // exchange.getResponse().setComplete() ;
        return chain.filter(newExchange);
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE + 10;
    }
}
