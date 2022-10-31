package com.yicj.hello.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class LogFilter implements WebFilter {

    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        // [1]
        log.info("request before, url:{}, statusCode:{}", exchange.getRequest().getURI(), exchange.getResponse().getStatusCode());
        return chain.filter(exchange)
            .doFinally(s -> {
                // [2]
                log.info("request after, url:{}, statusCode:{}", exchange.getRequest().getURI(), exchange.getResponse().getStatusCode());
            });
    }
}