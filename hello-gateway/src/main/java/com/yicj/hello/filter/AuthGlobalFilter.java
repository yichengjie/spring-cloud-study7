package com.yicj.hello.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

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
        HttpHeaders headers = request.getHeaders();
        String token = headers.getFirst("token");
        log.info("======> token : {}", token);
        ServerHttpRequest newRequest = exchange.getRequest()
                .mutate()
                .header("x-token", token)
                .build();
        ServerWebExchange newExchange = exchange.mutate()
                .request(newRequest).build();
        return chain.filter(newExchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
