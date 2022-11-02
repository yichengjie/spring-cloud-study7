package com.yicj.hello.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * @program: spring-cloud-study7
 * @description:
 * @author: yicj1
 * @create: 2022-11-02 10:17
 **/
@Slf4j
@RequiredArgsConstructor
public class CustomOrderLogGlobalFilter implements GlobalFilter, Ordered {

    private final String filterName ;

    private final Integer order ;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("{} pre ...", filterName);
        return chain.filter(exchange)
                .then(Mono.fromRunnable(() -> log.info("{} post ..", filterName)));
    }

    @Override
    public int getOrder() {
        return Optional.ofNullable(order)
                .orElse(0);
    }
}
